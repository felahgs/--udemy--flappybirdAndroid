package com.example.fgsou.birdbirdbird;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class GameActivity extends Activity {

    GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
    }
}
