package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Globals {
    Integer screenWith;
    Integer screenHeight;
    boolean soundEnabled;

    public Globals(){
        screenWith = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        soundEnabled = true;
    }

    public Integer getScreenWith() {
        return screenWith;
    }

    public Integer getScreenHeight() {
        return screenHeight;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    // Enables or disables sound
    public void muteSound(){
        if (soundEnabled){
            soundEnabled = false;
        }
        else{
            soundEnabled = true;
        }
    }


}


