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
package br.liveo.ndrawer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;
import br.liveo.ndrawer.R;
import br.liveo.ndrawer.ui.fragment.FragmentContactus;
import br.liveo.ndrawer.ui.fragment.MainFragment;
import br.liveo.ndrawer.ui.fragment.FragmentNotificationsfacebook;
import br.liveo.ndrawer.ui.fragment.ViewPagerFragment;

public class MainActivity extends NavigationLiveo implements OnItemClickListener, View.OnClickListener {

    private HelpLiveo mHelpLiveo;
    int strtposition=0;
    ImageView iv;
    @Override
    public void onInt(Bundle savedInstanceState) {

       // openDrawer();


        Intent i=getIntent();


        Bundle b = i.getExtras();
////                if (b != null) {


        if (b != null) {
            String insert = b.getString("flagstring");

            Log.i("flagstring2", insert);

            strtposition = Integer.parseInt(insert);
        }


//        iv = (ImageView)findViewById(R.mipmap.ic_person_pin_black_24dp);
//        iv.setPivotX(77);
//        iv.setPivotY(0);


        // User Information
        this.userName.setText("IET_DTU");
        this.userEmail.setText("Student Chapter");
        //this.userPhoto.setImageResource(R.drawable.navi_iet_logo);
        this.userBackground.setImageResource(R.drawable.naviimage);
        //tv_hello.setTypeface(EasyFonts.robotoThin(this));
        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add("Home", R.drawable.ic_store_mall_directory_black_24dp);
      //  mHelpLiveo.addSubHeader(getString(R.string.categories)); //Item subHeader

        mHelpLiveo.add("Notifications ", R.drawable.ic_trending_down_black_24dp);
        mHelpLiveo.add("Contact Us", R.drawable.ic_call_black_24dp);

     //   mHelpLiveo.addSeparator(); // Item separator



        with(this).startingPosition(strtposition) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())

                //{optional} - List Customization "If you remove these methods and the list will take his white standard color"
                //.selectorCheck(R.drawable.selector_check) //Inform the background of the selected item color
                //.colorItemDefault(R.color.nliveo_blue_colorPrimary) //Inform the standard color name, icon and counter
                //.colorItemSelected(R.color.nliveo_purple_colorPrimary) //State the name of the color, icon and meter when it is selected
                //.backgroundList(R.color.nliveo_black_light) //Inform the list of background color
                //.colorLineSeparator(R.color.nliveo_transparent) //Inform the color of the subheader line

                //{optional} - SubHeader Customization
                .colorItemSelected(R.color.nliveo_white2)
                .colorNameSubHeader(R.color.nliveo_orange_colorPrimaryDark)
                //.colorLineSeparator(R.color.nliveo_blue_colorPrimary)

              //  .footerItem(R.string.settings, R.mipmap.ic_settings_black_24dp)

                //{optional} - Footer Customization
                //.footerNameColor(R.color.nliveo_blue_colorPrimary)
                //.footerIconColor(R.color.nliveo_blue_colorPrimary)
                //.footerBackground(R.color.nliveo_white)

                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();

        int position = this.getCurrentPosition();
       // this.setElevationToolBar(position != 2 ? 15 : 0);
    }

    @Override
    public void onItemClick(final int position) {

        Thread time=new Thread(){
            public void run(){
                try{
                    sleep(220);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally{
                    Fragment mFragment;
                    FragmentManager mFragmentManager = getSupportFragmentManager();
                    mFragment = new ViewPagerFragment();
                    switch (position){
                        case 1:
                            //    mFragment = new ViewPagerFragment();

//                ObjectAnimator imageViewObjectAnimator2 = ObjectAnimator.ofFloat(iv ,"rotation", 75f, -75f);
//                imageViewObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
//                imageViewObjectAnimator2.setStartDelay((long)15);
//                imageViewObjectAnimator2.setDuration(50); // miliseconds
//                imageViewObjectAnimator2.start();

                            mFragment = FragmentNotificationsfacebook.newInstance(mHelpLiveo.get(position).getName());

                            Intent i=new Intent();
                            // i.setClass(MainActivity.this, MainActivityDemo.class);
                            //   i.setClass(MainActivity.this, Ietdtu1FlexiSpace.class);
                            //  startActivity(i);


                            break;

                        case 2:

                            mFragment = FragmentContactus.newInstance(mHelpLiveo.get(position).getName());
                            break;

                        default:
                            mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                            break;
                    }

                    if (mFragment != null){
                        mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
                    }

                }
            }
        };
        time.start();



       // setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "onClickPhoto :D", Toast.LENGTH_SHORT).show();
            //closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
          //  closeDrawer();
        }
    };

    @Override
    public void onClick(View view) {

        Log.i("Main Fragment", "on click");


    }
}

