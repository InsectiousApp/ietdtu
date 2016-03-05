package br.liveo.ndrawer.ui.activity;

import android.graphics.Bitmap;

public class ImageItem {
    private Bitmap image;
    private String title;
    private String text;


    public ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public ImageItem(String text){
        super();
        this.text=text;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText1(){return text;}

    public void setText1(){this.text=text;}
}