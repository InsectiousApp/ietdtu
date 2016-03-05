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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import br.liveo.ndrawer.R;
import lt.lemonlabs.android.expandablebuttonmenu.ExpandableMenuOverlay;

public class FragmentContactus extends Fragment implements View.OnClickListener  {

    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    ImageView ivliveo1, ivliveo2, ivliveo3, ivliveo4, ivliveo5, ivliveo6, ivliveo7, ivliveo8;
    TextView tvliveo1, tvliveo2, tvliveo3, tvliveo4, tvliveo5, tvliveo6, tvliveo7, tvliveo8;
    int flag=0;


    ExpandableMenuOverlay menuOverlay;

    ImageView ivemaildtu, ivemailmukchaudhary, ivemailmukkumar, ivcallmukchaudhary, ivcallmukkumar;



	public static FragmentContactus newInstance(String text){
		FragmentContactus mFragment = new FragmentContactus();
		Bundle mBundle = new Bundle();
		mBundle.putString(TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		View rootView = inflater.inflate(R.layout.fragment_contactus, container, false);

        TextView mTxtTitle = (TextView) rootView.findViewById(R.id.txtTitle1);
        //mTxtTitle.setText(getArguments().getString(TEXT_FRAGMENT));

        ivemaildtu=(ImageView)rootView.findViewById(R.id.ivemail_dtu);
        ivemailmukchaudhary=(ImageView)rootView.findViewById(R.id.ivemail_mukcha);
        ivemailmukkumar=(ImageView)rootView.findViewById(R.id.ivemail_mukkum);
        ivcallmukchaudhary=(ImageView)rootView.findViewById(R.id.ivcall_mukcha);
        ivcallmukkumar=(ImageView)rootView.findViewById(R.id.ivcall_mukkum);


        ivemaildtu.setOnClickListener(this);
        ivemailmukchaudhary.setOnClickListener(this);
        ivemailmukkumar.setOnClickListener(this);

        ivcallmukchaudhary.setOnClickListener(this);
        ivcallmukkumar.setOnClickListener(this);

      //  tvliveo1.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo2.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo3.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo4.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo5.setTypeface(EasyFonts.captureIt(getActivity()));
     //   tvliveo6.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo7.setTypeface(EasyFonts.captureIt(getActivity()));




		rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));		
		return rootView;



	}

    private void emaildtu(View view) {



    }


    @Override
    public void onResume() {
        super.onResume();

       getActivity().setTitle("Contact Us");

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
		inflater.inflate(R.menu.menu_contactus, menu);
        
        //Select search item
      //  final MenuItem menuItem = menu.findItem(R.id.menu_search);
      //  menuItem.setVisible(true);

      //  SearchView searchView = (SearchView) menuItem.getActionView();
       // searchView.setQueryHint(this.getString(R.string.search));
//
      //  ((EditText) searchView.findViewById(R.id.search_src_text))
        //        .setHintTextColor(getResources().getColor(R.color.nliveo_white));
      //  searchView.setOnQueryTextListener(onQuerySearchView);

	//	menu.findItem(R.id.menu_add).setVisible(true);

		//mSearchCheck = false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		

		return true;
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
    public void onClick(View view) {

        Log.i("Main Fragment fragment", "on click");
        String tflag=null;

        switch (view.getId())
        {

            case R.id.ivemail_dtu:
                Intent i =new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:renaissance@dce.edu"));
                i.putExtra(Intent.EXTRA_SUBJECT,"Queries Regarding IET DTU Student Chapter");
                startActivity(i);

                break;
            case R.id.ivemail_mukcha:
                Intent i2 =new Intent(Intent.ACTION_SENDTO);
                i2.setData(Uri.parse("mailto:mukul0505@gmail.com"));
                i2.putExtra(Intent.EXTRA_SUBJECT,"Queries Regarding IET DTU Student Chapter");
                startActivity(i2);

                break;
            case R.id.ivemail_mukkum:
                Intent i3 =new Intent(Intent.ACTION_SENDTO);
                i3.setData(Uri.parse("mailto:mukulcj@gmail.com"));
                i3.putExtra(Intent.EXTRA_SUBJECT,"Queries Regarding IET DTU Student Chapter");
                startActivity(i3);

                break;
            case R.id.ivcall_mukcha:
                Intent i4 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:9873113748"));
                startActivity(i4);

                break;
            case R.id.ivcall_mukkum:
                Intent i5 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:9013616477"));
                startActivity(i5);

                break;

        }

    }




}
