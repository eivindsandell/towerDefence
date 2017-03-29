package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public final class Globals {
    private Integer screenWidth;
    private Integer screenHeight;
    private boolean soundEnabled;
    private Preferences preferences;
    private ArrayList<Image> attackers;
    private ArrayList<Image> towers;
    private Texture questionMarkMex;
    private Texture questionMarkUs;

    public Texture getQuestionMarkUs() {
        return questionMarkUs;
    }

    public Texture getQuestionMarkMex() {
        return questionMarkMex;
    }

    private Image getQuestionmarkMex;

    public ArrayList<Image> getAttackers() {
        return attackers;
    }

    public ArrayList<Image> getTowers() {
        return towers;
    }

    public Globals(){
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();

        attackers = new ArrayList<Image>();
        attackers.add(new Image(new Texture(Gdx.files.internal("towerDefense_tile245.png"))));

        towers = new ArrayList<Image>();
        towers.add(new Image(new Texture(Gdx.files.internal("towerDefense_tile249.png"))));

        questionMarkUs = new Texture(Gdx.files.internal("Question Mark US.png"));
        questionMarkMex = new Texture(Gdx.files.internal("Question Mark Mex.png"));

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


