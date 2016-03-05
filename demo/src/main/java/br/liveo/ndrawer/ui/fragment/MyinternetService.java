package br.liveo.ndrawer.ui.fragment;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.liveo.ndrawer.R;
import br.liveo.ndrawer.ui.activity.MainActivity;

/**
 * Created by Chetan on 7/20/2015.
 */
public class MyinternetService extends Service implements GraphRequest.Callback {

    CallbackManager callbackManager;
    SQLiteDatabase db;
    NotificationCompat.Builder b2;
    NotificationManager nm;

    Button brefresh;
    int postcount=0;


    NotificationSquliteOpenHelper helper;



    public MyinternetService() {
    }

    @Override
    public void onCreate() {
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        callbackManager = CallbackManager.Factory.create();

        Log.i("service", "reached service");

       // Toast.makeText(this, "Created service", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       // Toast.makeText(this, "on start command", Toast.LENGTH_SHORT).show();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        helper=new NotificationSquliteOpenHelper(this);
        db=helper.getReadableDatabase();

        GraphRequest request = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "1464891230473651/posts", this);



        //  Log.i("access token", a);

        Bundle b = new Bundle();
        b.putInt("limit", 3);
        // b.putString("after","CAALwq7ecy1kBAKZAtYgV4lXEODs9qjGn3mGlUr38OxOv0UHZACWkFPrtONw7SWNvxp7zhJTrWvPRSadiy26mFc3wMatkQAfM4iDMdZCQdtZBKfxgwnXWeZCnwE7xJZBGw2547o2ZAwjojNNgYrmMVRl384MbSuDuvgAxVFdkrUD2xOYi06HM15DuQLIJCtEamSvZAvVDm6ZBTpihZCGH8Ivl4h");
        // b.putString("after", "QWFLMmtpVm9HU01YeW1UYWtjQVZUckdJQzFvZjlMdkhnNVRZMWZZaEE0TV80VllFaFppcFhBNDM4VDE0S3J6TGF6X3dWblJ0dGdBZnZUMVdOY3hNNEdWZF9VdFFSZzg3eS1hRmRYM2ROY1RfUnc=");
        b.putString("access_token", "CAABmayo2f0oBALQs8WEZAZB6JO21WivdcFsIT2wZArZBt4EJ7mZC329CPGtgAKODKNsPtC2Exk3IjFkoE6AWcsng6ZBXj7TYkmarf8yhdZA3SBZCGRxCV6ieVtOjtAlK9ltF4IA1O8TCVjvfrzi7msVaZCfmk8pOrJ7p3SmBIr8t0ZAu7YqzZBzzUH8dYqQBVAcDc9xK4LC0IscZCND6SxKhQlWY");
        request.setParameters(b);
        request.executeAsync();

//
//        NotificationCompat.Builder b=new NotificationCompat.Builder(this);
//        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(startId, b.build());


        Intent i=new Intent();
        i.setClass(getApplicationContext(), MainActivity.class);

        int a=1;
        String as=String.valueOf(a);

        Bundle b3=new Bundle();
        b3.putString("flagstring", as);
        i.putExtra("bundle", b3);

        Log.i("flagstring", as);

        b2 = new NotificationCompat.Builder(this);
        nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        b2.setContentTitle("IET DTU");
        b2.setSmallIcon(R.drawable.bb2);

      //  b2.setTicker("New posts from IET DTU");

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.iet2);
        b2.setLargeIcon(bm);

       PendingIntent contentintent=PendingIntent.getActivity(getApplicationContext(), 0, i, 0);

        b2.setAutoCancel(true);

         b2.setContentIntent(contentintent);

//        Intent i1 = new Intent();
//        i1.setClass(this, MainActivity.class);
//        PendingIntent i = PendingIntent.getActivity(this, 1, i1, 0);
//        b.setContentIntent(i);
        // b.addAction(R.drawable.ic_launcher, "text", i);

       //

        startForeground(startId + 1, b2.build());

        int u = super.onStartCommand(intent, flags, startId);
        stopSelf();
        return u;
    }


//
//    private void startForeground(int startId, Notification.Builder b) {
//
//
//
//    }

    @Override
    public void onDestroy() {

      //  Toast.makeText(this, "on destroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCompleted(GraphResponse graphResponse) {

        int postreversecounter=1;
        ContentValues cv1 = null, cv2 = null, cv3=null, cv4=null;
        String abc1=null, abc2=null, abc3=null;

        int notificationcounter=0;

        JSONObject data1 = graphResponse.getJSONObject();
        try {
            if(data1!=null)
            {
                JSONArray friends = data1.getJSONArray("data");

                // JSONObject pagingInfo = data1.getJSONObject("paging");
                // Log.i("response-paging",pagingInfo.toString());

                postreversecounter=1;

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

                    int flag=0;

                    Cursor c=db.query(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, col, null, null, null, null, null);
                    while(c.moveToNext())
                    {
                        String text=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION));
                      //  String datee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_DATE));
                     //   String timeee=c.getString(c.getColumnIndex(NotificationSquliteOpenHelper.NOTIFICATION_TIME));

                       // String

                       // Notification n1=new Notification(text);
                      //  Log.i("text get", text);

                        if(text!=null&&text.contentEquals(abc))
                        {
                            flag=1;
                        }

                       // Log.i("text flag", String.valueOf(flag));
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

                        notificationcounter++;

                       // nm.notify(1, b2.build());

                        //for 1st object

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

                      //  Notification nn1=new Notification(abc, date, ftime);
                       // data2.add(nn1);
                       // adapter2.notifyDataSetChanged();


                        // Note nnew=new Note(getnote);

                        //data.add(nnew);
                        //adapter2.notifyDataSetChanged();
                    }


                }


            }
            else
            {
               // Toast.makeText(this, "No internet Connection found", Toast.LENGTH_SHORT);
            }


            //now to insert into database in correct order

            if(postreversecounter==4)
            {
             //   db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv3);
              //  db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv2);
              //  db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv1);
            }//
            else if(postreversecounter==3)
            {
              //  db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv2);
              //  db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv1);
            }
            else if(postreversecounter==2)
            {
                //  db.insert(NotificationSquliteOpenHelper.NOTIFICATION_TABLE, null, cv1);
            }


            //

        } catch (JSONException e) {
            e.printStackTrace();
        }

            if(notificationcounter!=0)
            {

                String noticounter=String.valueOf(notificationcounter);

                b2.setContentText("You have "+noticounter+" new notification(s)");
                nm.notify(1, b2.build());



            }

    }
}

