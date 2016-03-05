package br.liveo.ndrawer.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import br.liveo.ndrawer.R;

public class Renaissance extends ActionBarActivity {

    TextView tv1, tv2, tv3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renaissance);

        tv1=(TextView)findViewById(R.id.tv_renaissance);
        tv2=(TextView)findViewById(R.id.tv_renaissance2);
        tv3=(TextView)findViewById(R.id.tv_renaissance3);




        tv1.setTypeface(EasyFonts.tangerineBold(this));

        tv2.setTypeface(EasyFonts.captureIt2(this));

        tv3.setTypeface(EasyFonts.tangerineBold(this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_renaissance, menu);
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
}
