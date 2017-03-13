package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * For global variables
 * Created by eivin on 13.03.2017.
 */

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

    public void setScreenWith(Integer screenWith) {
        this.screenWith = screenWith;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
    }
}


