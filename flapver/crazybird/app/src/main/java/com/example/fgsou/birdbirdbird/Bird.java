package com.example.fgsou.birdbirdbird;

public class Bird {

    private int birdX, birdY, curretFrame;
    public static int maxFrame;

    public Bird(){
        birdX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getBirdWidth()/2;
        birdY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getBirdHeight()/2;
        curretFrame = 0;
        maxFrame = 3;
    }

    // Getter method for current frame
    public int getCurretFrame() {
        return curretFrame;
    }

    // Setter method for current frame
    public void setCurretFrame(int curretFrame) {
        this.curretFrame = curretFrame;
    }

    // Getter method for getting X-coordinate of the Bird
    public int getX(){
        return birdX;
    }

    // Getter method for getting the Y-coordinate of the Bird
    public int getY(){
        return birdY;
    }

    // Setter method for setting the X-coordinate
    public void setX(int birdX) {
        this.birdX = birdX;
    }

    // Setter method for setting the Y-coordinate
    public void setY(int birdY){
        this.birdY = birdY;
    }
}
