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

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import net.grobas.view.MovingImageView;

import java.util.Random;

import br.liveo.ndrawer.CouncilList;
import br.liveo.ndrawer.Ietdtu1FlexiSpace;
import br.liveo.ndrawer.R;
import br.liveo.ndrawer.ui.activity.Armageddon;
import br.liveo.ndrawer.ui.activity.OtherEvents;
import br.liveo.ndrawer.ui.activity.Renaissance;

public class MainFragment extends Fragment implements View.OnClickListener {

    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    ImageView ivliveo1, ivliveo2, ivliveo3, ivliveo4, ivliveo5, ivliveo6, ivliveo7, ivliveo8;
    TextView tvliveo1, tvliveo2, tvliveo3, tvliveo4, tvliveo5, tvliveo6, tvliveo7, tvliveo8;
    int flag=0;


    MovingImageView image;
    boolean toggleState = true;
    boolean toggleCustomMovement = true;

    int[] imageList = {R.drawable.ren2final, R.drawable.groupdis1, R.drawable.wor2final};
    int[] colorList = {R.color.red,R.color.green,R.color.blue,R.color.purple,R.color.orange};


    int pos = 0;
    int counter=0;
    FrameLayout rl;



	public static MainFragment newInstance(String text){
		MainFragment mFragment = new MainFragment();
		Bundle mBundle = new Bundle();
		mBundle.putString(TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView mTxtTitle = (TextView) rootView.findViewById(R.id.txtTitle1);
        //mTxtTitle.setText(getArguments().getString(TEXT_FRAGMENT));

        image = (MovingImageView)rootView. findViewById(R.id.image);
        rl=(FrameLayout)rootView.findViewById(R.id.movingimage_relativelayout);

        ivliveo1=(ImageView)rootView.findViewById(R.id.imgLiveo1);
        ivliveo2=(ImageView)rootView.findViewById(R.id.imgLiveo2);
        ivliveo3=(ImageView)rootView.findViewById(R.id.imgLiveo3);
        ivliveo4=(ImageView)rootView.findViewById(R.id.imgLiveo4);
        ivliveo5=(ImageView)rootView.findViewById(R.id.imgLiveo5);
        ivliveo6=(ImageView)rootView.findViewById(R.id.imgLiveo6);
        ivliveo7=(ImageView)rootView.findViewById(R.id.imgLiveo7);
        ivliveo8=(ImageView)rootView.findViewById(R.id.imgLiveo8);

        tvliveo1=(TextView)rootView.findViewById(R.id.txtTitle1);
        tvliveo2=(TextView)rootView.findViewById(R.id.txtTitle2);
        tvliveo3=(TextView)rootView.findViewById(R.id.txtTitle3);
        tvliveo4=(TextView)rootView.findViewById(R.id.txtTitle4);
        tvliveo5=(TextView)rootView.findViewById(R.id.txtTitle5);
        tvliveo6=(TextView)rootView.findViewById(R.id.txtTitle6);
        tvliveo7=(TextView) rootView.findViewById(R.id.txtTitle7);
        tvliveo8=(TextView) rootView.findViewById(R.id.txtTitle8);


      //  tvliveo1.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo2.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo3.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo4.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo5.setTypeface(EasyFonts.captureIt(getActivity()));
     //   tvliveo6.setTypeface(EasyFonts.captureIt(getActivity()));
      //  tvliveo7.setTypeface(EasyFonts.captureIt(getActivity()));


        ivliveo1.setOnClickListener(this);
        ivliveo2.setOnClickListener(this);
        ivliveo3.setOnClickListener(this);
        ivliveo4.setOnClickListener(this);
        ivliveo5.setOnClickListener(this);
        ivliveo6.setOnClickListener(this);
        ivliveo7.setOnClickListener(this);
        ivliveo8.setOnClickListener(this);

		rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));		
		return rootView;		
	}

    @Override
    public void onResume() {
        super.onResume();
        Log.i("on Resume", "Resume");

        getActivity().setTitle("Home");

        zoomandtranslate();
    }

    private void zoomandtranslate() {


        //code for the background image animation




        // image.setColorFilter(Color.rgb(206,147,216), PorterDuff.Mode.OVERLAY);

        final int count=0;
        final ObjectAnimator animx=ObjectAnimator.ofFloat(image, "scaleX", 1.5f, 1.0f);

        animx.setDuration(20000);
        animx.setInterpolator(new LinearInterpolator());
        animx.start();

        // animx.pause();
        // animx.setRepeatCount(Animation.INFINITE);



        final ObjectAnimator animx2=ObjectAnimator.ofFloat(image, "scaleY",1.5f, 1.0f);

        animx2.setDuration(20000);
        animx2.setInterpolator(new LinearInterpolator());
        animx2.start();
        // animx2.pause();
        // animx2.setRepeatCount(Animation.INFINITE);


        image.getMovingAnimator().clearCustomMovement();
        image.getMovingAnimator().addCustomMovement().addHorizontalMoveToRight().addHorizontalMoveToLeft().start();



        image.getMovingAnimator().addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i("Sample MovingImageView", "Start");


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("Sample MovingImageView", "End");
                //      pos = (pos + 1) >= imageList.length ? 0 : pos + 1;
                //     image.setImageResource(imageList[pos]);
//                toggleCustomMovement = true;
                //Toast.makeText(this, "Next picture", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i("Sample MovingImageView", "Cancel");


            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("Sample MovingImageView", "Repeat");


                final ObjectAnimator animx=ObjectAnimator.ofFloat(image, "scaleX", 1.5f, 1.0f);

                animx.setDuration(20000);
                animx.setInterpolator(new LinearInterpolator());
                animx.start();

                // animx.pause();
                // animx.setRepeatCount(Animation.INFINITE);



                final ObjectAnimator animx2=ObjectAnimator.ofFloat(image, "scaleY", 1.5f, 1.0f);

                animx2.setDuration(20000);
                animx2.setInterpolator(new LinearInterpolator());
                animx2.start();
                // animx2.pause();
                // animx2.setRepeatCount(Animation.INFINITE);



                Random crazy = new Random();

                //  image.getMovingAnimator().cancel();

                pos = (pos + 1) >= imageList.length ? 0 : pos + 1;

               // pos=(pos+1)%(5);

                image.setImageResource(imageList[pos]);

                int[] cList = {Color.RED, Color.BLUE, Color.CYAN, Color.GREEN};


                //  image.setColorFilter(Color.rgb(206,147,216), PorterDuff.Mode.OVERLAY);
                //image.setY(0.5f);
//                image.getMovingAnimator().clearCustomMovement();
//                image.getMovingAnimator().addCustomMovement().addHorizontalMoveToRight().addDiagonalMoveToDownLeft().start();
                //  image.setMaxRelativeSize(7.0f);
                image.setAlpha(0.8f);


                // image.setTranslationX(3.0f);
                animx2.start();
                animx.start();

                if(counter==0)
                {
                    image.getMovingAnimator().clearCustomMovement();
                    image.getMovingAnimator().addCustomMovement().addHorizontalMoveToRight().addHorizontalMoveToLeft().start();
                    counter=(counter+1)%4;
                }
                else if(counter==1)
                {
                    image.getMovingAnimator().clearCustomMovement();
                    image.getMovingAnimator().addCustomMovement().addHorizontalMoveToRight().addHorizontalMoveToLeft().start();
                    counter=(counter+1)%4;
                }
                else if(counter==2)
                {
                    image.getMovingAnimator().clearCustomMovement();
                    image.getMovingAnimator().addCustomMovement().addHorizontalMoveToRight().addHorizontalMoveToLeft().start();
                    counter=(counter+1)%4;
                }else if(counter==3)
                {
                    image.getMovingAnimator().clearCustomMovement();
                    image.getMovingAnimator().addCustomMovement().addHorizontalMoveToRight().addHorizontalMoveToLeft().start();
                    counter=(counter+1)%4;
                }


//                image.getMovingAnimator().clearCustomMovement();
//                image.getMovingAnimator().addCustomMovement().addDiagonalMoveToDownRight().addHorizontalMoveToLeft()
//                        .addDiagonalMoveToUpRight().start();


                // toggleCustomMovement = true;
                //Toast.makeText(this, "Next picture", Toast.LENGTH_SHORT).show();
            }
        });



        //end background animation code



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
		inflater.inflate(R.menu.menu_main, menu);
        
        //Select search item
      //  final MenuItem menuItem = menu.findItem(R.id.menu_search);
      //  menuItem.setVisible(true);

      //  SearchView searchView = (SearchView) menuItem.getActionView();
       // searchView.setQueryHint(this.getString(R.string.search));
//
      //  ((EditText) searchView.findViewById(R.id.search_src_text))
        //        .setHintTextColor(getResources().getColor(R.color.nliveo_white));
      //  searchView.setOnQueryTextListener(onQuerySearchView);

		//menu.findItem(R.id.menu_add).setVisible(true);

	//	mSearchCheck = false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		

		return true;
	}	


    @Override
    public void onClick(View view) {

        Log.i("Main Fragment fragment", "on click");
        String tflag=null;

        switch (view.getId())
        {
            case R.id.imgLiveo1:



                flag=1;
                Intent i=new Intent();
                i.setClass(getActivity(), Ietdtu1FlexiSpace.class);


                tflag=String.valueOf(flag);

                Bundle b=new Bundle();
                b.putString("flag_for_text", tflag);
                i.putExtra("bundle", b);
                startActivity(i);




                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;

            case R.id.imgLiveo2:

                flag=2;



                Intent i2=new Intent();
                i2.setClass(getActivity(), Ietdtu1FlexiSpace.class);


                tflag=String.valueOf(flag);

                Bundle b2=new Bundle();
                b2.putString("flag_for_text", tflag);
                i2.putExtra("bundle", b2);
                startActivity(i2);


                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.imgLiveo3:

                flag=3;

                Intent i3=new Intent();
                i3.setClass(getActivity(), Renaissance.class);
                startActivity(i3);

                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.imgLiveo4:

                flag=4;
                Intent i4=new Intent();
                i4.setClass(getActivity(), Armageddon.class);
                startActivity(i4);



                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.imgLiveo5:

                flag=5;

                Intent i5=new Intent();
                i5.setClass(getActivity(), Ietdtu1FlexiSpace.class);


                tflag=String.valueOf(flag);

                Bundle b5=new Bundle();
                b5.putString("flag_for_text", tflag);
                i5.putExtra("bundle", b5);
                startActivity(i5);

                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.imgLiveo6:

                flag=6;

                Intent i6=new Intent();
                i6.setClass(getActivity(), Ietdtu1FlexiSpace.class);


                tflag=String.valueOf(flag);

                Bundle b6=new Bundle();
                b6.putString("flag_for_text", tflag);
                i6.putExtra("bundle", b6);
                startActivity(i6);

                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.imgLiveo7:

                flag=7;

                Intent i7=new Intent();
                i7.setClass(getActivity(), OtherEvents.class);
                startActivity(i7);

                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;

            case R.id.imgLiveo8:

                flag=7;

                Intent i8=new Intent();
                i8.setClass(getActivity(), CouncilList.class);
                startActivity(i8);


                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);

                break;



        }

    }




}
