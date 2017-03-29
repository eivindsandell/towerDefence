package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.models.mobs.BasicMob;
import com.mygdx.game.models.mobs.Mob;
import com.mygdx.game.models.towers.Tower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Globals {
    private static final int BASICMOB = 0;
    private static final int STANDARDTOWER = 1;
    private final TextField.TextFieldStyle textFieldStyle;
    private Integer screenWidth;
    private Integer screenHeight;
    private boolean soundEnabled;
    private Preferences preferences;
    private ArrayList<Image> attackers;
    private ArrayList<Image> towers;
    private Texture questionMarkMex;
    private Texture questionMarkUs;
    private String mobActorName;
    private String towerActorName;
    private BitmapFont font;
    private HashMap<Image,Integer> towerMap;
    private HashMap<Image,Integer> mobMap;
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

        textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;

        towerActorName = "tower";
        mobActorName = "mob";

        mobMap = new HashMap<Image, Integer>();
        attackers = new ArrayList<Image>();
        attackers.add(new Image(new Texture(Gdx.files.internal("towerDefense_tile245.png"))));
        mobMap.put(attackers.get(0),BASICMOB);

        towerMap = new HashMap<Image, Integer>();
        towers = new ArrayList<Image>();
        towers.add(new Image(new Texture(Gdx.files.internal("towerDefense_tile249.png"))));
        towerMap.put(towers.get(0),STANDARDTOWER);

        questionMarkUs = new Texture(Gdx.files.internal("Question Mark US.png"));
        questionMarkMex = new Texture(Gdx.files.internal("Question Mark Mex.png"));

        preferences = Gdx.app.getPreferences("My Preferences");
        preferences.putBoolean("musicEnabled", true);

        setActorNames();
    }

    public Skin getSkin() {
        return skin;
    }

    public String getMobActorName() {
        return mobActorName;
    }

    public String getTowerActorName() {
        return towerActorName;
    }

    private void setActorNames(){
        for (Image mob:attackers) {
            mob.setName(mobActorName);
        }
        for (Image tower:towers){
            tower.setName(towerActorName);

        }
    }

    public Texture getQuestionMarkUs() {
        return questionMarkUs;
    }

    public Texture getQuestionMarkMex() {
        return questionMarkMex;
    }

    public ArrayList<Image> getAttackers() {
        return attackers;
    }

    public ArrayList<Image> getTowers() {
        return towers;
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

    public TextField.TextFieldStyle getTextFieldStyle() {
        return textFieldStyle;
    }
}


