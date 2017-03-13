package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Globals {
    Integer screenWith;
    Integer screenHeight;

    public Globals(){
        screenWith = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }

    public Integer getScreenWith() {
        return screenWith;
    }

    public Integer getScreenHeight() {
        return screenHeight;
    }

}


