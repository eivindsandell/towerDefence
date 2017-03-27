package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Globals {
    Integer screenWith;
    Integer screenHeight;
    boolean soundEnabled;
    private Preferences preferences;

    public Globals(){
        screenWith = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        preferences = Gdx.app.getPreferences("My Preferences");
        preferences.putBoolean("musicEnabled", true);
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
        soundEnabled = false;
        preferences.putBoolean("musicEnabled", false);

    }

    public void unMuteSound(){
        soundEnabled = true;
        preferences.putBoolean("musicEnabled", true);

    }


}


