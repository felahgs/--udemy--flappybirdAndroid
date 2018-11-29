package com.example.fgsou.birdbirdbird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] bird;
    Bitmap tubeTop, tubeBottom;


    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.long_background);
        background = scaleImage(background);
        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.beat_01);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.beat_02);
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.beat_03);
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.beat_04);
        tubeTop = BitmapFactory.decodeResource(res, R.drawable.pipe_down);
        tubeBottom = BitmapFactory.decodeResource(res, R.drawable.pipe_up);
    }

    //Return Tube-Top Bitmap
    public Bitmap getTubeTop(){
        return tubeTop;
    }

    //Return Tube-Bottom Bitmap
    public Bitmap getTubeBottom(){
        return tubeBottom;
    }

    //Return Tube-width
    public int getTubeWidth(){
        return tubeTop.getWidth();
    }

    //Return Tube-Height
    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    //Return bird bitmap of frame
    public Bitmap getBird(int frame){
        return bird[frame];
    }

    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight(){
        return bird[0].getHeight();
    }

    //Return background bitmap
    public Bitmap getBackground(){
        return  background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeghtRatio = getBackgroundWidth() / getBackgroundHeight();
        /*
        We will multiply widthHeghtRatio with screeenHeight to get scaled width
        Then call createScaledBitmap() to create a new bitmap, scaled from an existing bitmap, when possible

         */
        int backgroundScaleWidth = (int) widthHeghtRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);

    }
}
