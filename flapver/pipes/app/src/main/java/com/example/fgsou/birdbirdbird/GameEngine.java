package com.example.fgsou.birdbirdbird;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    Bird bird;
    static int gameState;
    ArrayList<Tube> tubes;
    Random random;

    public GameEngine(){
        backgroundImage = new BackgroundImage();
        bird = new Bird();
        //0 = Not Started
        //1 = Playing
        //2 = GameOver
        gameState = 0;
        tubes = new ArrayList<>();
        random = new Random();
        for(int i = 0; i < AppConstants.numberOfTubes; i++){
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            // Get topTubeOffsetY
            int topTUbeOffsetY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
            // Now create Tube objects
            Tube tube = new Tube(tubeX, topTUbeOffsetY);
            tubes.add(tube);
        }
    }

    public void updateAndDrawTubes(Canvas canvas) {
        if(gameState == 1) {
            for(int i = 0; i < AppConstants.numberOfTubes; i++){
                if(tubes.get(i).getTubeX() < - AppConstants.getBitmapBank().getTubeWidth()){
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstants.numberOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
            }
        }
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
        if(gameState ==1) {
            if (bird.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight()) || bird.getVelocity() < 0) {
                bird.setVelocity(bird.getVelocity() + AppConstants.gravity);
                bird.setY(bird.getY() + bird.getVelocity());
            }
        }
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
