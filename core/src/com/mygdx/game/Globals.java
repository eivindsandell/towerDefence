package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Globals {
    Integer screenWidth;
    Integer screenHeight;
    boolean soundEnabled;
    private Preferences preferences;

    public Globals(){
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        preferences = Gdx.app.getPreferences("My Preferences");
        preferences.putBoolean("musicEnabled", true);
    }

    public Integer getScreenWidth() {
        return screenWidth;
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


