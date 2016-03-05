package br.liveo.ndrawer.ui.activity;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import br.liveo.ndrawer.R;


public class DetailsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle b = getIntent().getExtras();
        int pos = b.getInt("position");

        Log.i("position", String.valueOf(pos));

        String title = getIntent().getStringExtra("title");
        Log.i("title", title);
      //  Bitmap bitmap = getIntent().getParcelableExtra("image");

        TypedArray texts = getResources().obtainTypedArray(R.array.image_details);
        String strtext = getResources().getString(texts.getResourceId(pos, 0));

        ImageView imageView = (ImageView) findViewById(R.id.image);

        switch (pos)
        {
            case 0:

                imageView.setImageResource(R.drawable.resbpie1);
                Log.i("case1", "reached here");

                break;

            case 1:

                imageView.setImageResource(R.drawable.resbpie1);
                Log.i("case2", "reached here");

                break;
        }





        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);


        TextView detailTextView = (TextView) findViewById(R.id.title1);
      //  detailTextView.setText(strtext+"");

//        imageView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                finish();
//                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        DetailsActivity.this.overridePendingTransition(R.anim.zoom_out2, R.anim.zoom_in2);

    }
}










