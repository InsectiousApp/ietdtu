/*
 * Copyright 2015 Rudson Lima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.liveo.ndrawer.ui.fragment;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import br.liveo.ndrawer.R;

public class FragmentNotificationsfacebook extends Fragment implements GraphRequest.Callback, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    TextView tv_notification;
    CallbackManager callbackManager;
    LoginButton button;

    Activity activity;
    String _selectedItem;

    NotificationAdapter adapter2;
    ArrayList<Notification> data2;
    ListView lv;
    SQLiteDatabase db;

    Button brefresh;
    int postcount=0;


    NotificationSquliteOpenHelper helper;
    private int[] Countries;


    public static FragmentNotificationsfacebook newInstance(String text){
		FragmentNotificationsfacebook mFragment = new FragmentNotificationsfacebook();
		Bundle mBundle = new Bundle();
		mBundle.putString(TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());

        callbackManager = CallbackManager.Factory.create();

		View rootView = inflater.inflate(R.layout.fragment_fragment_note_detail, container, false);

        Log.i("methods", "oncreateview");

        button = (LoginButton)rootView.findViewById(R.id.fb_login_button);
        View vv=getView();

        registerForContextMenu(container);

        button.setReadPermissions(Arrays.asList("user_posts"));
        final Activity a  = getActivity();


                button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Log.i("facebooklog", AccessToken.getCurrentAccessToken().getToken());

                Toast.makeText(a, Profile.getCurrentProfile().getName(), Toast.LENGTH_LONG).show();

                //access token - CAALwq7ecy1kBABr2zkaYuKdtUZBREujKrmSeNpWbFqdZAp6jGZC6MfWKjSbQaL7Fq6aX6phXk4rbB4r1GZCk6S14A1yTiPFAU2jwjfDVOO1XQzZAijqXZC3GCoMakHQZCnH7YPRdHisi5mcdZBOujC16TRkKZB40EcoeYKAMlDnkRMd4sXlxJW51PcuZAhwo3E7KnSZCcb3llWDXdbcVAK1QcDG

            }

            @Override
            public void onCancel() {
               // Toast.makeText(a, "Cancelled" , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
              //  Toast.makeText(a, e.toString(), Toast.LENGTH_LONG).show();
            }
        });



      //  TextView mTxtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
    //    mTxtTitle.setText(getArguments().getString(TEXT_FRAGMENT));
        data2=new ArrayList<Notification>();

        lv = (ListView)rootView. findViewById(R.id.listview);


        LayoutInflater l=getActivity().getLayoutInflater();
        adapter2=new NotificationAdapter(getActivity(), 0, data2, l);

        lv.setAdapter(adapter2);

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);


        activity =getActivity();




        this.registerForContextMenu(lv);



		rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));

        //brefresh=(Button)rootView.findViewById(R.id.buttonrefresh);
      //  brefresh.setOnClickListener(this);



       // lv.setAdapter(adapter);

//data base work

        helper=new NotificationSquliteOpenHelper(getActivity());
        db=helper.getReadableDatabase();

        String[] col=new String[3];
        col[0]=NotificationSquliteOpenHelper.NOTIFICATION;
         col[1]=NotificationSquliteOpenHelper.NOTIFICATION_DATE;
        col[2]=NotificationSquliteOpenHelper.NOTIFICATION_TIME;

        String text=null;

        Cursor c=db.query(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, col, null, null, null, null, null);
        while(c.moveToNext())
        {
//            text=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION));
//           String datee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_DATE));
//           String timeee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_TIME));
//
//
//            String compare=datee+timeee;
//
//
//
//
//
//            Notification n1=new Notification(text, datee, timeee);
//            // Log.i("text get", text);
//           // postcount++;
//          //  Note nn1=new Note(text);
//            data2.add(n1);
//            adapter2.notifyDataSetChanged();
        }

        while(c.moveToPrevious())
        {

            text=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION));
            String datee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_DATE));
            String timeee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_TIME));



            Notification n1=new Notification(text, datee, timeee);
            // Log.i("text get", text);
            // postcount++;
            //  Note nn1=new Note(text);
            data2.add(n1);
            adapter2.notifyDataSetChanged();

        }


//        String[] col2=new String[1];
//        col2[0]=NotificationSquliteOpenHelper.NOTIFICATION_DATE;
//
//        String datee=null;
//
//        Cursor c2=db.query(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, col2, null, null, null, null, null);
//        while(c2!=null&&c2.moveToNext())
//        {
//
//            // String text=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION));
//            datee = c2.getString(c2.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_DATE));
//            //  String timeee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_TIME));
//
//
//           // Notification n1 = new Notification("text", datee, "time");
//            //  Log.i("noti date", datee);
//            // postcount++;
//            //  Note nn1=new Note(text);
//           // data2.add(n1);
//
//        }
//
//
//
//        String[] col3=new String[1];
//        col3[0]=NotificationSquliteOpenHelper.NOTIFICATION_TIME;
//
//        String timeee=null;
//
//        Cursor c3=db.query(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, col3, null, null, null, null, null);
//        while(c3!=null&&c3.moveToNext())
//        {
//
//            // String text=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION));
//           // datee = c3.getString(c3.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_DATE));
//              timeee=c3.getString(c3.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_TIME));
//
//
//          //  Notification n1 = new Notification("text", datee, "time");
//            //  Log.i("noti date", datee);
//            // postcount++;
//            //  Note nn1=new Note(text);
//          //  data2.add(n1);
//
//        }

      //  Notification n11=new Notification(text, datee, timeee);
       // data2.add(n11);
       // adapter2.notifyDataSetChanged();


        String postcountstring=String.valueOf(postcount);
       // Log.i("postcount", postcountstring);


		return rootView;		
	}


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu2, menu);
        
        //Select search item
       // final MenuItem menuItem = menu.findItem(R.id.menu_search);
       // menuItem.setVisible(true);

       // SearchView searchView = (SearchView) menuItem.getActionView();
      //  searchView.setQueryHint(this.getString(R.string.search));

        //((EditText) searchView.findViewById(R.id.search_src_text))
        //        .setHintTextColor(getResources().getColor(R.color.nliveo_white));
      //  searchView.setOnQueryTextListener(onQuerySearchView);

		menu.findItem(R.id.menu_add).setVisible(true);

		//mSearchCheck = false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {

		case R.id.menu_add:
            GraphRequest request = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "1464891230473651/posts", this);



            //  Log.i("access token", a);

            Bundle b = new Bundle();
            b.putInt("limit", 3);
            // b.putString("after","CAALwq7ecy1kBAKZAtYgV4lXEODs9qjGn3mGlUr38OxOv0UHZACWkFPrtONw7SWNvxp7zhJTrWvPRSadiy26mFc3wMatkQAfM4iDMdZCQdtZBKfxgwnXWeZCnwE7xJZBGw2547o2ZAwjojNNgYrmMVRl384MbSuDuvgAxVFdkrUD2xOYi06HM15DuQLIJCtEamSvZAvVDm6ZBTpihZCGH8Ivl4h");
            // b.putString("after", "QWFLMmtpVm9HU01YeW1UYWtjQVZUckdJQzFvZjlMdkhnNVRZMWZZaEE0TV80VllFaFppcFhBNDM4VDE0S3J6TGF6X3dWblJ0dGdBZnZUMVdOY3hNNEdWZF9VdFFSZzg3eS1hRmRYM2ROY1RfUnc=");
            b.putString("access_token", "CAABmayo2f0oBALQs8WEZAZB6JO21WivdcFsIT2wZArZBt4EJ7mZC329CPGtgAKODKNsPtC2Exk3IjFkoE6AWcsng6ZBXj7TYkmarf8yhdZA3SBZCGRxCV6ieVtOjtAlK9ltF4IA1O8TCVjvfrzi7msVaZCfmk8pOrJ7p3SmBIr8t0ZAu7YqzZBzzUH8dYqQBVAcDc9xK4LC0IscZCND6SxKhQlWY");
            request.setParameters(b);
            request.executeAsync();


            reloadfragment();
            reloadfragment();

            break;


		}
		return true;
	}

    private void reloadfragment() {

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        Fragment newFragment = this;
        this.onDestroy();
        ft.remove(this);
        ft.replace(R.id.container,newFragment);
        //container is the ViewGroup of current fragment
        ft.addToBackStack(null);
        ft.commit();


    }

    private SearchView.OnQueryTextListener onQuerySearchView = new SearchView.OnQueryTextListener() {
       @Override
       public boolean onQueryTextSubmit(String s) {
           return false;
       }

       @Override
       public boolean onQueryTextChange(String s) {
           if (mSearchCheck){
               // implement your search here
           }
           return false;
       }
   };

    @Override
    public void onCompleted(GraphResponse graphResponse) {

        int postreversecounter=1;
        ContentValues cv1 = null, cv2 = null, cv3=null, cv4=null;
        String abc1=null, abc2=null, abc3=null;

        Log.i("response",graphResponse.toString());

        JSONObject data1 = graphResponse.getJSONObject();
        try {
            if(data1!=null)
            {
                JSONArray friends = data1.getJSONArray("data");

                // JSONObject pagingInfo = data1.getJSONObject("paging");
                // Log.i("response-paging",pagingInfo.toString());
                for (int i =0; i < friends.length(); i++)
                {




                    JSONObject currentFriend = friends.getJSONObject(i);
                    Log.i("response1", currentFriend.toString());

                    String abc = currentFriend.getString("message");
                    String time=currentFriend.getString("created_time");
                    // Notification notimessage=new Notification(abc);
                    // Notification timestamp=new Notification(time);

                    // data2.add(timestamp);
                    // adapter2.notifyDataSetChanged();

                    //DATE

                    String year=time.substring(0, 4);
                    String month=time.substring(5, 7);
                    String dated=time.substring(8, 10);

                    Integer imonth=Integer.parseInt(month);

                    switch (imonth)
                    {
                        case 1:
                            month="Jan";
                            break;
                        case 2:
                            month="Feb";
                            break;
                        case 3:
                            month="Mar";
                            break;
                        case 4:
                            month="Apr";
                            break;
                        case 5:
                            month="May";
                            break;
                        case 6:
                            month="June";
                            break;
                        case 7:
                            month="July";
                            break;
                        case 8:
                            month="Aug";
                            break;
                        case 9:
                            month="Sep";
                            break;
                        case 10:
                            month="Oct";
                            break;
                        case 11:
                            month="Nov";
                            break;
                        case 12:
                            month="Dec";
                            break;
                    }

                    String date=dated+" "+month+", "+year;

                    Log.i("date", date);

                    Log.i("response year", year);

                    Log.i("response year_m", month);

                    Log.i("response year_d", date);


                    //DATE END



                    Log.i("response3", time);

                    //TIme

                    String meri="PM";

                    String utchh=time.substring(11, 13);
                    String utcmm=time.substring(14, 16);

                    Log.i("hh_h", utchh);
                    Log.i("hh_m", utcmm);

                    Integer iutchh=Integer.parseInt(utchh);
                    iutchh=iutchh+5;

                    if(iutchh>12)
                    {
                        iutchh=iutchh-12;
                        meri="PM";
                    }
                    else
                    {
                        iutchh=iutchh;
                        meri="AM";
                    }

                    Integer iutcmm=Integer.parseInt(utcmm);
                    iutcmm=iutcmm+30;
                    if(iutcmm>59)
                    {
                        iutcmm=iutcmm-60;
                        iutchh=iutchh+1;
                    }


                    String isthh=String.valueOf(iutchh);
                    String istmm=String.valueOf(iutcmm);

                    Log.i("time", isthh+" : "+istmm);

                    String ftime=isthh+":"+istmm+" "+meri;

                    //TIME Ends


                    //Toast.makeText(this, time, Toast.LENGTH_SHORT);

                    //check for duplicate

                    String[] col=new String[1];
                    col[0]=NotificationSquliteOpenHelper.NOTIFICATION;
                    // col[1]=NotificationSquliteOpenHelper.NOTIFICATION_DATE;
                    // col[2]=NotificationSquliteOpenHelper.NOTIFICATION_TIME;



                    String text="text";

                    int flag=0;

                    Cursor c=db.query(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, col, null, null, null, null, null);
                    while(c.moveToNext())
                    {
                        text=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION));
                        //  String datee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_DATE));
                        //   String timeee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_TIME));

                        // String

                        // Notification n1=new Notification(text);
                        //Log.i("text get", text);


                        if(text!=null&&text.contentEquals(abc))
                        {


                            flag=1;
                        }

                        Log.i("text flag", String.valueOf(flag));
                        // postcount++;
                        //  Note nn1=new Note(text);
                        //  data2.add(n1);
                    }

                        if (postreversecounter == 2) {

                            if (abc.contentEquals(abc1)) {
                                flag = 1;
                            }

                        } else if (postreversecounter == 3) {

                            if(abc.contentEquals(abc1)||abc.contentEquals(abc2))
                            {
                                flag=1;
                            }

                        } else if (postreversecounter == 4) {
                            if(abc.contentEquals(abc1)||abc.contentEquals(abc2)||abc.contentEquals(abc3))
                            {
                                flag=1;
                            }

                        }






                    if(flag!=1)
                    //
                    {
                        // data2.add(notimessage);
                        // adapter2.notifyDataSetChanged();

                        ContentValues cv = new ContentValues();
                        cv.put(NotificationSquliteOpenHelper.NOTIFICATION, abc);
                        cv.put(NotificationSquliteOpenHelper.NOTIFICATION_DATE, date);
                        cv.put(NotificationSquliteOpenHelper.NOTIFICATION_TIME, ftime);
                        SQLiteDatabase db = helper.getWritableDatabase();
                        //getContentResolver().insert(Studentsquliteopenhelper.STUDENT_TABLE, cv);
                        db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv);


                        if(postreversecounter==1)
                        {

                             abc1=abc;

                            cv1 = new ContentValues();
                            cv1.put(NotificationSquliteOpenHelper.NOTIFICATION, abc);
                            cv1.put(NotificationSquliteOpenHelper.NOTIFICATION_DATE, date);
                            cv1.put(NotificationSquliteOpenHelper.NOTIFICATION_TIME, ftime);

                            postreversecounter++;

                        }

                        //


                        //for 1st object


                        if(postreversecounter==2) {

                            abc2=abc;

                            cv2 = new ContentValues();
                            cv2.put(NotificationSquliteOpenHelper.NOTIFICATION, abc);
                            cv2.put(NotificationSquliteOpenHelper.NOTIFICATION_DATE, date);
                            cv2.put(NotificationSquliteOpenHelper.NOTIFICATION_TIME, ftime);

                            postreversecounter++;
                        }
                        //




                        //for 1st object


                        if(postreversecounter==3) {

                             abc3=abc;

                            cv3 = new ContentValues();
                            cv3.put(NotificationSquliteOpenHelper.NOTIFICATION, abc);
                            cv3.put(NotificationSquliteOpenHelper.NOTIFICATION_DATE, date);
                            cv3.put(NotificationSquliteOpenHelper.NOTIFICATION_TIME, ftime);

                            postreversecounter++;
                        }
                        //

//                        ContentValues cv2 = new ContentValues();
//                        cv2.put(NotificationSquliteOpenHelper.NOTIFICATION_DATE, date);
//                        db = helper.getWritableDatabase();
//                        //getContentResolver().insert(Studentsquliteopenhelper.STUDENT_TABLE, cv);
//                        db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv2);
//
//                        ContentValues cv3 = new ContentValues();
//                        cv3.put(NotificationSquliteOpenHelper.NOTIFICATION_TIME, ftime);
//                        db = helper.getWritableDatabase();
//                        //getContentResolver().insert(Studentsquliteopenhelper.STUDENT_TABLE, cv);
//                        db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv3);

                        Notification nn1=new Notification(abc, date, ftime);
                        data2.add(nn1);
                        adapter2.notifyDataSetChanged();


                        // Note nnew=new Note(getnote);

                        //data.add(nnew);
                        //adapter2.notifyDataSetChanged();
                    }


                }




            }
            else
            {
                Toast.makeText(getActivity(), "No internet Connection found", Toast.LENGTH_SHORT);
            }

            if(postreversecounter==4)
            {
               // db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv3);
               // db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv2);
               // db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv1);
            }
            else if(postreversecounter==3)
            {
               // db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv2);
               // db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv1);
            }
            else if(postreversecounter==2)
            {
                //db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv1);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i("methods", "onn resumee");

       getActivity().setTitle("Notifications");

        GraphRequest request = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "1464891230473651/posts", this);



        //  Log.i("access token", a);

        Bundle b = new Bundle();
        b.putInt("limit", 3);
        // b.putString("after","CAALwq7ecy1kBAKZAtYgV4lXEODs9qjGn3mGlUr38OxOv0UHZACWkFPrtONw7SWNvxp7zhJTrWvPRSadiy26mFc3wMatkQAfM4iDMdZCQdtZBKfxgwnXWeZCnwE7xJZBGw2547o2ZAwjojNNgYrmMVRl384MbSuDuvgAxVFdkrUD2xOYi06HM15DuQLIJCtEamSvZAvVDm6ZBTpihZCGH8Ivl4h");
        // b.putString("after", "QWFLMmtpVm9HU01YeW1UYWtjQVZUckdJQzFvZjlMdkhnNVRZMWZZaEE0TV80VllFaFppcFhBNDM4VDE0S3J6TGF6X3dWblJ0dGdBZnZUMVdOY3hNNEdWZF9VdFFSZzg3eS1hRmRYM2ROY1RfUnc=");
        b.putString("access_token", "CAABmayo2f0oBALQs8WEZAZB6JO21WivdcFsIT2wZArZBt4EJ7mZC329CPGtgAKODKNsPtC2Exk3IjFkoE6AWcsng6ZBXj7TYkmarf8yhdZA3SBZCGRxCV6ieVtOjtAlK9ltF4IA1O8TCVjvfrzi7msVaZCfmk8pOrJ7p3SmBIr8t0ZAu7YqzZBzzUH8dYqQBVAcDc9xK4LC0IscZCND6SxKhQlWY");
        request.setParameters(b);
        request.executeAsync();



    }

    @Override
    public void onClick(View view) {



    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Log.i("item click", "click");

//        GraphRequest request = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "1464891230473651/posts", this);
//
//
//
//        //  Log.i("access token", a);
//
//        Bundle b = new Bundle();
//        b.putInt("limit", 3);
//        // b.putString("after","CAALwq7ecy1kBAKZAtYgV4lXEODs9qjGn3mGlUr38OxOv0UHZACWkFPrtONw7SWNvxp7zhJTrWvPRSadiy26mFc3wMatkQAfM4iDMdZCQdtZBKfxgwnXWeZCnwE7xJZBGw2547o2ZAwjojNNgYrmMVRl384MbSuDuvgAxVFdkrUD2xOYi06HM15DuQLIJCtEamSvZAvVDm6ZBTpihZCGH8Ivl4h");
//        // b.putString("after", "QWFLMmtpVm9HU01YeW1UYWtjQVZUckdJQzFvZjlMdkhnNVRZMWZZaEE0TV80VllFaFppcFhBNDM4VDE0S3J6TGF6X3dWblJ0dGdBZnZUMVdOY3hNNEdWZF9VdFFSZzg3eS1hRmRYM2ROY1RfUnc=");
//        b.putString("access_token", "CAABmayo2f0oBALQs8WEZAZB6JO21WivdcFsIT2wZArZBt4EJ7mZC329CPGtgAKODKNsPtC2Exk3IjFkoE6AWcsng6ZBXj7TYkmarf8yhdZA3SBZCGRxCV6ieVtOjtAlK9ltF4IA1O8TCVjvfrzi7msVaZCfmk8pOrJ7p3SmBIr8t0ZAu7YqzZBzzUH8dYqQBVAcDc9xK4LC0IscZCND6SxKhQlWY");
//        request.setParameters(b);
//        request.executeAsync();
       // _selectedItem = (String)lv.getItemAtPosition(i);
       // getActivity().openContextMenu(lv);

    }

    Integer pos=null;
    AdapterView par=null;
    String newstring=null;

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long l) {

        Log.i("item long click2", "click2");
//
//        Notification newnote=(Notification)parent.getItemAtPosition(position);
//        String newstring=newnote.noti;
//
//        SQLiteDatabase db=helper.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(NotificationSquliteOpenHelper.NOTIFICATION, newstring);
//
//        db.delete(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, NotificationSquliteOpenHelper.NOTIFICATION+"= '"+newstring+"'", null);
//
//
//        data2.remove(position);
//        adapter2.notifyDataSetChanged();

       // _selectedItem = (String)lv.getItemAtPosition(position);

        Notification newnote=(Notification)parent.getItemAtPosition(position);
         newstring=newnote.noti;

        final SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NotificationSquliteOpenHelper.NOTIFICATION, newstring);

       // db.delete(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, NotificationSquliteOpenHelper.NOTIFICATION+"= '"+newstring+"'", null);


      //  data2.remove(position);
     //   adapter2.notifyDataSetChanged();


        pos=position;
      //  par=parent;
        getActivity().openContextMenu(lv);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        //alertDialogBuilder.setView(R.layout.sig_layout);

        alertDialogBuilder.setTitle("Delete this post ?");

        // alertDialogBuilder.setMessage("helwodosfoasdoifasdofudasofudso");

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        Log.i("button", "postitive button");

                        db.delete(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, NotificationSquliteOpenHelper.NOTIFICATION+"= '"+newstring+"'", null);


                        data2.remove(pos);
                        adapter2.notifyDataSetChanged();

                        reloadfragment();
                        reloadfragment();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

      //  ImageView iv=null;
      //  iv.setImageResource(R.drawable.example);

       // alertDialogBuilder.setCustomTitle(iv);
        alertDialogBuilder.setNegativeButton("No", dialogClickListener);
        alertDialogBuilder.setPositiveButton("Yes", dialogClickListener);

       // alertDialogBuilder.setPositiveButton("bUtton 1", );

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub

        super.onConfigurationChanged(newConfig);
      //  System.out.println("...11configuration is changed...");
    }

    static final String[] PENS = new String[]{
            "MONT Blanc",
            "Gucci",
            "Parker",
            "Sailor",
            "Porsche Design",
            "item1",
            "item2",
            "item3",
            "item4",
            "item5",
            "item6",
            "item7",
            "item8",
            "item9",
            "item10",
            "item11"  };



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        Log.i("item long click", "click2");

//        if (v.getId()==R.id.listview) {
//            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
//           /// menu.setHeaderTitle(Countries[info.position]);
//            String[] menuItems ={"item 1", "item 2", "item 3"};
//                    //getResources().getStringArray(R.array.menu);
//            for (int i = 0; i<menuItems.length; i++) {
//                menu.add(Menu.NONE, i, i, menuItems[i]);
//            }
//        }

       // super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(" Delete this post ?");

                  //  String[] menuItems ={"Yes", "item 2", "item 3"};
                    //getResources().getStringArray(R.array.menu);
//            for (int i = 0; i<menuItems.length; i++) {
           //     menu.add(Menu.NONE, 0, 0, "Yes");


       // menu.add(0, v.getId(), 0, "Yes");
      //  menu.add(0, v.getId(), 0, "Action 2");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="Yes"){

            Log.i("yes", "reached yes");


            if(pos!=null)
            {
                Log.i("yes2", "reached yes");



            }

        }
//        else if(item.getTitle()=="Action 2"){
//
//        }
        else {return false;}
        return true;
    }





    }



