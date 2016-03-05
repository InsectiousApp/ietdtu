package br.liveo.ndrawer;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;

import static android.view.View.OnClickListener;


public class Ietdtu1FlexiSpace extends ActionBarActivity implements ObservableScrollViewCallbacks, OnClickListener {


    private static final float MAX_TEXT_SCALE_DELTA = 0.3f;

    private View mImageView;
    public View mOverlayView;
    private ObservableScrollView mScrollView;
    private TextView mTitleView;

    TextView tv_paragraph;

    private int mActionBarSize;
    private int mFlexibleSpaceShowFabOffset;
    private int mFlexibleSpaceImageHeight;
    private int mFabMargin;
    private View mFab;
    private boolean mFabIsShown;

    ActionBar ab;
    View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ietdtu1_flexi_space);

        tv_paragraph = (TextView) findViewById(R.id.flexi_tv_mainparagraph);
        mImageView = findViewById(R.id.image);




        //ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        // ab.setTitle("hwllooo");
        //  ab.setIcon(R.drawable.mes);
       // ab.setHomeButtonEnabled(true);
        //   ab.setIcon((R.drawable.ic_launcher));
      //  ab.setDisplayShowCustomEnabled(true);
      //  ab.setDisplayShowTitleEnabled(true);


        Intent data=getIntent();

        Bundle b = data.getExtras().getBundle("bundle");
////                if (b != null) {
        String insert = b.getString("flag_for_text");

        int fflag=0;
        fflag=Integer.parseInt(insert);

        Log.i("string", insert);

        switch (fflag)
        {
            case 1:

            mImageView.setBackgroundResource(R.drawable.iet_flexi_pic);
                tv_paragraph.setText("The Institution of Engineering and Technology (IET) is the largest multidisciplinary professional engineering institution in the world. The IET was formed in 2006 when two separate institutions: the Institution of Electrical Engineers (IEE), established 1871, and the Institution of Incorporated Engineers (IIE) established 1884.  The IET is now the second largest engineering society in the world. The IET has the authority to grant Chartered Engineer, Incorporated Engineer, Engineering Technician, and ICT Technician professional designations on behalf of the Engineering Council UK. \n" +
                        "What IET do\n" +
                        "\n" +
                        "•\tThe IET provides expert advice to the UK’s Parliament, Government and other agencies.  Each year it makes around 30 submissions to the UK Government and the EU on engineering related policy issues.\n" +
                        "•\tThe IET produces fact files and briefings available to the public.\n" +
                        "•\tThe IET is regularly in the mainstream and specialist media explaining the impacts of engineering and technology on society.\n" +
                        "•\tThe IET publishes more than 100 new titles every year; a rich mix of books, journals and magazines with a back catalogue of more than 500 publications.\n" +
                        "•\t22 Technical and Professional Networks generate activities covering the full spectrum of reliable information, industry leading events and access to expertise across the IET’s engineering and technology areas.\n" +
                        "•\tThe IET organises over 1,500 events annually, offering over 106,000 delegates the opportunity for networking and knowledge sharing.\n" +
                        "\n" +
                        "The IET has an educational role, seeking to support its members through their careers by offering a professional home for life, producing advice and guidance at all levels to secure the future of engineering. IET provides various resources to its members such as\n" +
                        "\n" +
                        "1 Virtual Library\n" +
                        "2 Books\n" +
                        "3 Magazines\n" +
                        "The IET publishes a range of member magazines that are produced to the highest editorial standards by a team of specialist editors who are leading experts in their fields. The magazines include:\n" +
                        "•\tEngineering and Technology (E&T) magazine: A regularly published IET flagship member magazine packed with news, features and industry developments. \n" +
                        "•\tJournals\n" +
                        "\n" +
                        "4 IET Digital Library\n" +
                        "5 IET Library and Archives\n" +
                        "6 E&T Reference \n" +
                        "\n" +
                        "\n" +
                        "7 Inspec\n" +
                        "Inspec is one of the world's largest and most wide ranging bibliographic databases for scientific and technical research containing over 13 million scientific and technical papers. Members of the IET can access this online research tool at highly discounted fees.\n" +
                        "\n" +
                        "\n" +
                        "8 EVENTS\n" +
                        "Apart from the various resources offered by the IET offline and online it also organises various events. IET events deliver insight and debate into the hot topics affecting engineers and technicians across the globe.Featuring first class speakers, hand-picked for their expertise and industry knowledge, IET organises over 1200 seminars, conferences, technical visits, courses, lectures and webcasts are guaranteed to both challenge and inspire.\n" +
                        "\n" +
                        "IET India\n" +
                        "IET was established in 2006. The first office was setup in Bangalore. IET India has eight Local Networks across India. IET Bangalore Local Network, IET Chennai Local Network, IET Delhi Local Network, IET Kanyakumari Local Network, IET Kolkata Local Network, IET Mumbai Local Network, IET Nashik Local Network, IET Pune Local Network\n" +
                        "The prestigious IET Pinkerton Lecture is presented annually in Bangalore.\n" +
                        "\n" +
                        "\n" +
                        "For over 140 years the IET has been inspiring, informing and influencing the global engineering community, supporting technology innovation to meet the needs of society. We treat everyone with integrity and respect, continually striving for excellence in all our activities and use the power of teamwork to deliver value.\n" +
                        "We’ll keep working to engineer a better world.\n");


                break;
            case 2:
                mImageView.setBackgroundResource(R.drawable.ietdtu_flexi_pic);
                tv_paragraph.setText("The IET-DTU student chapter is a leading technical society of our college which lays great emphasis on empowering all its members with both technical and managerial skills. Regular Special Interest Groups (SIGs) are held on important and industry specific topics such as ROBOTICS, CODING (C/C++/JAVA), WEB DESIGNING etc. IET helps to boost student’s managerial skills by giving them the freedom to organize the annual techweek ARMAGEDDON and techfest RENAISSANCE on their own. Students are involved in making these events a success right from the scratch, without any assistance from any teacher whatsoever. These events truly follow the motto “By the students, for the students”.\n" +
                        "The previous editions of IET’s events say it all. Renaissance ’15 was a huge success, in terms of the number of participations registered and the creativity displayed in its themes. In addition to this, IET-DTU is constantly involved in holding workshops (like the one held in August on Raspberry Pi microcontroller and another one to boost memory skills by MadeEasy) and guest lectures. Our guest lecture given by esteemed professor from Sheffield University on Nuclear Sciences was widely appreciated. All these seminars attract a packed crowd (which sometimes even makes accommodation difficult). Last year, IET hosted its first ever industrial visit, which is just a testament to the ever-growing ways of this society to find means to benefit its students. \n" +
                        "In addition to these, IET-DTU regularly holds its SIG classes, which is one of the primary reasons why students join IET. These classes, held by our experienced senior members, focus on promoting hands-down approach to practical skills such as Robotics and Coding, which are largely application based. Also, many students feel at ease asking their doubts to a friendly senior and an interactive learning process is ensued.\n" +
                        "The IET-DTU chapter understands the need to spread its wings in NCR and invites many other engineering colleges, from Delhi and outside, to attend its events and fests. This requires a great deal of promotion, and students are more than happy to visit other colleges and generate excitement over our events. Our members are hence handed a great opportunity to explore other colleges, make new contacts and improve their confidence in public speaking through PR Drives and promotional campaigns.\n" +
                        "IET-DTU suitably rewards its members with esteemed positions, as we believe that students are the flag bearers of our society and deserve a title they can proudly call their own, for all the work they put in for the society. \n" +
                        "In short, joining IET-DTU is not just being a member of a technical society, but being part of a journey which will truly enhance your personality from all spheres, and coming out as a better individual in the end.\n");


                break;
            case 5:
                mImageView.setBackgroundResource(R.drawable.benifitsfinal);


                tv_paragraph.setText("Welcome to the IET - where you belong!\n" +
                        " \n" +
                        "By joining a world leading professional engineering institution you will be part of a professional community of nearly 160,000 members in 127 countries sharing a common vision of 'working to engineer a better world'.\n" +
                        "Our mission is to inspire, inform and influence by providing a rich portfolio of products and services designed to meet the need of our members at every life:career stage.\n" +
                        " \n" +
                        "1.Reasons to join IET\n" +
                        " \n" +
                        "1 Get membership to a global professional organisation.\n" +
                        "2 Get free access to study resources - international journals, market reports,    research papers   and much more through our global knowledge repository.\n" +
                        "3 Network, meet and learn from subject matter experts from the industry.\n" +
                        "4 Attend IET events for free.\n" +
                        "5 Stand out from the crowd – showcase your achievements to a national and global engineering audience.\n" +
                        "6 Receive mentoring and guidance from IET members working in the industry and academia.\n" +
                        "7 Receive monthly, a free hard copy of the award-winning E&T Magazine on latest engineering trends.\n" +
                        "8 Pick from a wide range of volunteering opportunities within your geographic region that matches your interest.\n" +
                        "9 Job search support and internship opportunities through the IET Advantage Job Fair.\n" +
                        "10 Career head start with the IET Graduate Advantage Programme for final year students.\n" +
                        " ADVANTAGES OF MEMBERSHIP\n" +
                        "1)Knowledge resources\n" +
                        "\n" +
                        "Our members rely on the IET to provide books, research papers, factual data and historical information that may be hard to find elsewhere. Our responsibility to you is to provide you with the products and tools to filter an ever increasing volume of information from a bewildering variety of sources and help you pin-point the information which is relevant, faster and more efficient\n" +
                        "Engineering and Technology magazine\n" +
                        "\n" +
                        "Engineering and Technology magazine (E&T) is frequently cited by IET members as one of their top valued membership benefits. The award winning magazine is packed with inspiring articles, lively debate, interesting facts and authoritative coverage; making it an exceptional read covering a wide spectrum of global engineering and technology subjects.Available in print, online and on the iPad [new window], members can access E&T at any time, in a format that suits them. \n" +
                        " \n" +
                        "2) Career development\n" +
                        "\n" +
                        "The IET supports the professional development (PD) of people working in the fields of engineering and technology - to raise the standards and recognition of those professions. It centres around competences: the recognised knowledge, skills and attributes needed to deliver results in your chosen field. It keeps you fresh and at the leading edge of your profession.\n" +
                        "Structuring your professional development will help you maintain these high levels of professional competences by continually developing your knowledge and skills. The IET provides the tools to help you get started with your own PD programme, build a plan using competence frameworks, plan your journey towards professional registration, and point you towards the resources that will help you on your way. \n" +
                        " \n" +
                        "\n" +
                        "3)Getting involved\n" +
                        "\n" +
                        "IET Sectors champion the professional interests of the international engineering community to industry, government and the wider public, working together with members to address the global challenges of the 21st Century. Providing you with a technical home for life and promoting Essential Engineering Intelligence®, each Sector pursues key topics and industry challenges, assembling expert teams to develop partnerships and thought leadership. \n" +
                        "The five Sectors are: \n" +
                        "·         Built Environment - smart innovation for tomorrow's urban landscape.\n" +
                        "·         Design and Production - designing, developing, delivering; creating tomorrow.\n" +
                        "·         Energy - powering tomorrow; from smart homes to megagrids.\n" +
                        "·         Information and Communications - connecting tomorrow, digitally.\n" +
                        "·         Transport - engineering excellence for future transport systems.\n" +
                        " \n" +
                        "\n" +
                        "4) Shaping the profession\n" +
                        "\n" +
                        "IET members are role models for the next generation of scientists, engineers and technicians. The IET plays a key role in engineering education in the UK and internationally. We accredit over 1,000 undergraduate and postgraduate courses and we support teachers and lecturers in engaging students with STEM subjects by providing free teaching resources and supporting engineering-themed educational enhancement and enrichment activities. We provide members in the UK with opportunities to volunteer in schools through STEMNET’s Ambassador programme, and to deliver activities with support from the IET Education Fund\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Scholarships and Awards \n" +
                        "The IET rewards engineering aspirations, enterprise and excellence with a range of annual Scholarships and Awards.\n" +
                        "IET Scholarships recognise, support and encourage students entering or currently studying within the engineering and technology sector through a range of generous undergraduate and postgraduate scholarships, competitions and travel awards.\n" +
                        "·         Achievement Awards recognise and reward outstanding individuals who excel within the engineering and technology fields.\n" +
                        "·         The Young Woman Engineer of the Year Award recognises a dynamic young female engineer who represents the very best of our profession. This award seeks to highlight the achievements of women in engineering and technology and to encourage others to enter the profession.\n" +
                        "Innovation Awards celebrate the products, technologies and processes that lead the way in engineering innovation. The awards promote and recognise innovation in industry and best practice across engineering disciplines");



                break;
            case 6:
                mImageView.setBackgroundResource(R.drawable.ren1final);


                tv_paragraph.setText("STUDENT MEMBERSHIP\n" +
                        "\n" +
                        "For individuals studying in any semesters or years of engineering in India \n" +
                        "Student Membership Fee: \n" +
                        "First year & second year undergraduates engineering students – Rs. 2,675/- \n" +
                        "Third year undergraduate and first year postgraduate engineering students – Rs. 1,600/- \n" +
                        "Fourth year undergraduate and second year postgraduate engineering students – Rs. 1,000/- \n" +
                        "Please note that the above fee is for the entire duration of course.\n");





                break;
        }

//        ImageView image = (ImageView) findViewById(R.id.ivactionbar);
//        (R.drawable.ic_arrow_back_black_24dp);

//       TextView textv = (TextView)findViewById(R.id.overlay); // just like single layout
        //  textv.setText("something");

        mFlexibleSpaceImageHeight =  300;
        //getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mFlexibleSpaceShowFabOffset =getResources().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);
        mActionBarSize = 30;

        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            mActionBarSize= TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        //ab=getSupportActionBar();

       // ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        // ab.setTitle("hwllooo");
        //  ab.setIcon(R.drawable.mes);
   //     ab.setHomeButtonEnabled(true);
        //   ab.setIcon((R.drawable.ic_launcher));
   //    // ab.setDisplayShowCustomEnabled(true);
   //     //ab.setDisplayShowTitleEnabled(true);
        // ab.hide();

        // CUSTOM ACTION BAR
       // LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //  v = inflator.inflate(R.layout.actionbar, null);

   //     ab.setCustomView(v);


   //     ab.setElevation(0.9f);
        // v.setBackgroundColor(Color.argb(25,0,0,0));



        mOverlayView =findViewById(R.id.overlay);
        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        mTitleView = (TextView) findViewById(R.id.title);

        // TO add the title on the pic (bottom left)
        // mTitleView.setText("Topic");
        // getTitle();
        //setTitle(null);
        // mFab = findViewById(R.id.fab);

        // mOverlayView.setBackgroundColor(R.color.abc_primary_text_material_dark);


//        mFab.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "FAB is clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        mFabMargin = getResources().getDimensionPixelSize(R.dimen.margin_standard);
        //ViewHelper.setScaleX(mFab, 0);
        // View.setScaleY(mFab, 0);

        ScrollUtils.addOnGlobalLayoutListener(mScrollView, new Runnable() {
            @Override
            public void run() {
                //mScrollView.scrollTo(30, mFlexibleSpaceImageHeight - mActionBarSize);
                mScrollView.scrollTo(0,1);
                // If you'd like to start from scrollY == 0, don't write like this:
                //mScrollView.scrollTo(0, 0);
                // The initial scrollY is 0, so it won't invoke onScrollChanged().
                // To do this, use the following:
                //onScrollChanged(0, false, false);

                // You can also achieve it with the following codes.
                // This causes scroll change from 1 to 0.
                //mScrollView.scrollTo(0, 1);
                //mScrollView.scrollTo(0, 0);
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_ietdtu1_flexi_space, menu);
        // return true;

     //  MenuInflater mif=getMenuInflater();
      //  mif.inflate(R.menu.menu_ietdtu1_flexi_space, menu);
     //   return super.onCreateOptionsMenu(menu);



        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int a = scrollY;

        String scroll = String.valueOf(a);
        Log.i("scroll Y", scroll);

        if(scrollY<300) {

            //  v.setBackgroundColor(Color.argb(25,0,0,0));

            float flexibleRange = mFlexibleSpaceImageHeight - mActionBarSize;
            int minOverlayTransitionY = mActionBarSize - mOverlayView.getHeight();


            ViewHelper.setTranslationY(mImageView, ScrollUtils.getFloat(-scrollY / 2, minOverlayTransitionY, 0));
            ViewHelper.setTranslationY(mOverlayView, ScrollUtils.getFloat(-scrollY, minOverlayTransitionY, 0));






            // Change alpha of overlay
            ViewHelper.setAlpha(mOverlayView, ScrollUtils.getFloat(((float) scrollY - 150) / flexibleRange, 0, 0.5f));

            // Scale title text
            float scale = 1 + ScrollUtils.getFloat((flexibleRange - scrollY) / flexibleRange, 0, MAX_TEXT_SCALE_DELTA);
            ViewHelper.setPivotX(mTitleView, 0);
            ViewHelper.setPivotY(mTitleView, 0);
            ViewHelper.setScaleX(mTitleView, scale);
            ViewHelper.setScaleY(mTitleView, scale);

            // Translate title text
            int maxTitleTranslationY = (int) (mFlexibleSpaceImageHeight - mTitleView.getHeight() * scale+90);
            int titleTranslationY = maxTitleTranslationY - scrollY;
            ViewHelper.setTranslationY(mTitleView, titleTranslationY);

            // Translate FAB
//            int maxFabTranslationY = mFlexibleSpaceImageHeight - mFab.getHeight() / 2;
//            float fabTranslationY = ScrollUtils.getFloat(
//                    -scrollY + mFlexibleSpaceImageHeight - mFab.getHeight() / 2,
//                    mActionBarSize - mFab.getHeight() / 2,
//                    maxFabTranslationY);
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
//                // On pre-honeycomb, ViewHelper.setTranslationX/Y does not set margin,
//                // which causes FAB's OnClickListener not working.
//                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFab.getLayoutParams();
//                lp.leftMargin = mOverlayView.getWidth() - mFabMargin - mFab.getWidth();
//                lp.topMargin = (int) fabTranslationY;
//                mFab.requestLayout();
//            } else {
//                ViewHelper.setTranslationX(mFab, mOverlayView.getWidth() - mFabMargin - mFab.getWidth());
//                ViewHelper.setTranslationY(mFab, fabTranslationY);
//            }

            //  ab.hide();

            // Show/hide FAB
//            if (fabTranslationY < mFlexibleSpaceShowFabOffset) {
//                // hideFab();
//
//            } else {
//                //showFab();
//            }

        }else
        {
            //  v.setBackgroundColor(Color.GREEN);
            // ab.show();
        }

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.tvaction:
//                Intent i=new Intent();
//                i.setClass(this, FlexibleSpaceWithImageWithViewPagerTabActivity.class);
//                startActivity(i);
                //Toast.makeText(MainActivity.this, "TextView is Clicked", Toast.LENGTH_SHORT).show();



                break;
            case R.id.ivactionbar:
                // Toast.makeText(MainActivity.this, "ImageView is Clicked", Toast.LENGTH_SHORT).show();



                break;

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

//        Intent i=new Intent();
//        i.setClass(Ietdtu1FlexiSpace.this, MainActivity.class);
//        startActivity(i);

       // overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
