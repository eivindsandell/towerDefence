package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Globals;

import java.util.ArrayList;


public class EndgameView implements Screen {
    Game game;
    private Globals globals;
    private Stage stage;
    private int screenHeight;
    private int screenWidth;
    private TextureAtlas checkBoxAtlas;
    public TextButton backButton;
    private CheckBox.CheckBoxStyle checkBoxStyle;
    private Preferences preferences;


    public EndgameView(Game game){
        globals = new Globals();
        this.game = game;
        preferences = Gdx.app.getPreferences("My Preferences");
        preferences.flush();
        screenHeight = globals.getScreenHeight();
        screenWidth = globals.getScreenWidth();
        stage = new Stage();
        createAllButtons();
    }

    @Override
    public void show() {
        stage.addActor(backButton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.clear();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }



    private void createAllButtons() {
        backButton = new TextButton("Back to menu", globals.getTextButtonStyle());
        int widthPlacement = (int) (screenWidth / 2 - backButton.getWidth() / 2);
        backButton.setPosition(widthPlacement, 100);
    }

}
