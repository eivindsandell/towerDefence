package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.models.mobs.BasicMob;
import com.mygdx.game.models.mobs.Mob;
import com.mygdx.game.models.towers.StandardTower;
import com.mygdx.game.models.towers.Tower;

import java.util.ArrayList;
import java.util.HashMap;

public final class Globals {
    private static final int BASICMOB = 0;
    private static final int STANDARDTOWER = 1;
    private final Label.LabelStyle labelStyle;
    private Integer screenWidth;
    private Integer screenHeight;
    private boolean soundEnabled;
    private Preferences preferences;
    private ArrayList<Texture> mobTextures;
    private ArrayList<Texture> towerTextures;
    private Texture questionMarkMex;
    private Texture questionMarkUs;
    private String actorName;
    private BitmapFont font;
    private HashMap<Texture, Integer> towerMap;
    private HashMap<Texture, Integer> mobMap;
    private Skin skin;
    private TextButton.TextButtonStyle textButtonStyle;

    public Globals(){

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();

        font = new BitmapFont();
        font.getData().setScale(4);

        skin = new Skin();
        TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.atlas"));
        skin.addRegions(buttonAtlas);

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("Button");
        textButtonStyle.down = skin.getDrawable("ButtonPressed");

        labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = new Color(1,1,1,1);

        actorName = "actor";

        mobMap = new HashMap<Texture, Integer>();
        mobTextures = new ArrayList<Texture>();
        mobTextures.add((new Texture(Gdx.files.internal("towerDefense_tile245.png"))));
        mobMap.put(mobTextures.get(0),BASICMOB);

        towerMap = new HashMap<Texture, Integer>();
        towerTextures = new ArrayList<Texture>();
        towerTextures.add((new Texture(Gdx.files.internal("towerDefense_tile249.png"))));
        towerMap.put(towerTextures.get(0),STANDARDTOWER);

        questionMarkUs = new Texture(Gdx.files.internal("Question Mark US.png"));
        questionMarkMex = new Texture(Gdx.files.internal("Question Mark Mex.png"));

        preferences = Gdx.app.getPreferences("My Preferences");
        preferences.putBoolean("musicEnabled", true);
    }

    public Skin getSkin() {
        return skin;
    }

    public String getActorName() {
        return actorName;
    }

    public Texture getQuestionMarkUs() {
        return questionMarkUs;
    }

    public Texture getQuestionMarkMex() {
        return questionMarkMex;
    }

    public ArrayList<Texture> getMobTextures() {
        return mobTextures;
    }

    public ArrayList<Texture> getTowerTextures() {
        return towerTextures;
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

    public BitmapFont getFont() {
        return font;
    }

    public TextButton.TextButtonStyle getTextButtonStyle() {
        return textButtonStyle;
    }

    public Label.LabelStyle getLabelStyle() {
        return labelStyle;
    }

    public Mob whichMob(int mobtype) {
        int m = mobMap.get(mobTextures.get(mobtype));
        switch (m){
            case BASICMOB:
                return new BasicMob();
        }
        return null;
    }

    public Tower whichTower(int towertype) {
        int t = towerMap.get(towerTextures.get(towertype));
        switch (t){
            case STANDARDTOWER:
                return new StandardTower();
        }
        return null;
    }
}


