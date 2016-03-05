package br.liveo.ndrawer.ui.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import br.liveo.ndrawer.R;

public class DetailsActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activity2);

        Bundle b = getIntent().getExtras();
        int pos = b.getInt("position");

        Log.i("position", String.valueOf(pos));

        String title = getIntent().getStringExtra("title");
       // Bitmap bitmap = getIntent().getParcelableExtra("image");

        Log.i("title", title);

        TypedArray texts = getResources().obtainTypedArray(R.array.image_details);
        String strtext = getResources().getString(texts.getResourceId(pos, 0));

        ImageView imageView = (ImageView) findViewById(R.id.image);
      //  imageView.setImageBitmap(bitmap);

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        TextView detailTextView = (TextView) findViewById(R.id.title1);




        switch (pos)
        {
            case 0:
                imageView.setImageResource(R.drawable.resbpie1);
                detailTextView.setText("This was a popular highlight of Armageddon'14 and had the largest footfall. Students learnt about how Raspberry Pie ,as small as a credit card could function as a CPU!");
               // imageView.setBackgroundResource(R.drawable.resbpie1);
                break;
            case 1:
                imageView.setImageResource(R.drawable.androidapp1);
                detailTextView.setText(" With the rise of app development  in all fields incorporating this in the techweek becomes essential. ");
                break;
            case 2:
                imageView.setImageResource(R.drawable.animation1);
                detailTextView.setText("This workshop is conducted in collaboration with the leaders in animation, during Armageddon ’14 ARENA ANIMATION conducted the workshop.");
                break;
            case 3:
                imageView.setImageResource(R.drawable.aerodeaero1);
                detailTextView.setText(" Teachs how to make a glider using balsa wood, hence, rendering the paper plane passé!");
                break;
            case 4:
                imageView.setImageResource(R.drawable.autocad1);
                detailTextView.setText("Imparting simple tricks making it easier to work with Autocad. A software which is must for engineers and architects.");
                break;
            case 5:
                imageView.setImageResource(R.drawable.quizmoz1);
                detailTextView.setText("This event includesprizes for the winners and a platform to showcase and test  knowledge.");
                break;
            case 6:
                imageView.setImageResource(R.drawable.groupdis1);
                detailTextView.setText("Another essential and useful event which helps students to face their greatest fears- GDs.");
                break;


        }

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

        DetailsActivity2.this.overridePendingTransition(R.anim.zoom_out2, R.anim.zoom_in2);

    }
}










