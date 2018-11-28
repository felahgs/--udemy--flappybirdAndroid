package com.example.fgsou.birdbirdbird;

import android.graphics.Canvas;

public class GameEngine {

    BackgroundImage backgroundImage;
    Bird bird;

    public GameEngine(){
        backgroundImage = new BackgroundImage();
        bird = new Bird();
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth() ){
            {
                backgroundImage.setX(0);
            }
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if(backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() + AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);

        }
    }

    public void updateAndDrawBird(Canvas canvas) {
        int currentFrame = bird.getCurretFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getBird(currentFrame), bird.getX(), bird.getY(), null);
        currentFrame++;
        // If it exceeds maxframe re-initialize to 0
        if(currentFrame > bird.maxFrame) {
            currentFrame = 0;
        }
        bird.setCurretFrame(currentFrame);
    }
}
