package br.liveo.ndrawer.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import br.liveo.ndrawer.R;

public class Armageddon extends Activity {

    private GridView gridView;
    private GridViewAdapter gridAdapter;
    //Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_single, getData());
        gridView.setAdapter(gridAdapter);

        //ImageButton imageView = (ImageButton)findViewById(R.id.image);
//        imageView.setOnClickListener(this);

//        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out);
//        animation.setAnimationListener(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                if(position==0)
                {
                    Log.i("zero", String.valueOf(position));

                }

                Intent intent = new Intent(Armageddon.this, DetailsActivity2.class);
                intent.putExtra("title", item.getTitle());
               // intent.putExtra("image", item.getImage());
                Bundle bundle = new Bundle();
                bundle.putInt("position" ,position);
                intent.putExtras(bundle);

                startActivity(intent);

                overridePendingTransition(R.anim.zoom_out, R.anim.zoom_in);
                //MainActivity.this.overridePendingTransition(R.an);
                Log.i("MAHIMA", "");

            }
        });



        //Create intent


//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent (MainActivity.this, DetailsActivity.class);
////                intent.putExtra("title", item.getTitle());
////                intent.putExtra("image", item.getImage());
//                MainActivity.this.startActivity(intent);
//                MainActivity.this.overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
//
//            }
//        });
    }


    /**
     * Prepare some dummy data for gridview
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        TypedArray titles = getResources().obtainTypedArray(R.array.image_titles);

        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            String strTiltle = getResources().getString(titles.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, strTiltle));
        }
        return imageItems;
    }

    @Override
    protected void onResume() {
        super.onResume();

     // setTitle("Armageddon");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

    //    @Override
//    public void onAnimationStart(Animation animation) {
//
//    }
//
//    @Override
//    public void onAnimationEnd(Animation animation) {
//
//    }
//
//    @Override
//    public void onAnimationRepeat(Animation animation) {
//
//    }
//
////    @Override
////    public void onClick(View v) {
////
////    }
}