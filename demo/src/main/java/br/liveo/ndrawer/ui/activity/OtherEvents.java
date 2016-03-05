package br.liveo.ndrawer.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.liveo.ndrawer.R;

public class OtherEvents extends ActionBarActivity implements View.OnClickListener{

    TextView tv1, tv2, tv3, tv4;

    android.support.v7.app.ActionBar ab;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_events);



        tv1=(TextView)findViewById(R.id.otherevents_tv1);
        tv2=(TextView)findViewById(R.id.otherevents_tv2);
        tv3=(TextView)findViewById(R.id.otherevents_tv3);
        tv4=(TextView)findViewById(R.id.otherevents_tv4);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other_events, menu);
        return true;
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
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.otherevents_tv1:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                alertDialogBuilder.setView(R.layout.sig_layout);

                //alertDialogBuilder.setTitle("SIG");
               // alertDialogBuilder.setMessage("helwodosfoasdoifasdofudasofudso");


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();




                break;
            case R.id.otherevents_tv2:
                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);

                alertDialogBuilder2.setView(R.layout.workshop_layout);

                AlertDialog alertDialog2 = alertDialogBuilder2.create();
                alertDialog2.show();

                break;
            case R.id.otherevents_tv3:
                AlertDialog.Builder alertDialogBuilder3 = new AlertDialog.Builder(this);

                alertDialogBuilder3.setView(R.layout.guestlectures_layout);

                AlertDialog alertDialog3 = alertDialogBuilder3.create();
                alertDialog3.show();

                break;
            case R.id.otherevents_tv4:
                AlertDialog.Builder alertDialogBuilder4 = new AlertDialog.Builder(this);

                alertDialogBuilder4.setView(R.layout.industrialvisits_layout);

                AlertDialog alertDialog4 = alertDialogBuilder4.create();
                alertDialog4.show();

                break;

        }


    }
}
