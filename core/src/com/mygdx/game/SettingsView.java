package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class SettingsView implements Screen {
    Game game;
    private Globals globals;
    private Stage stage;
    private Skin skin;
    private int screenHeight;
    private int screenWidth;
    private TextureAtlas buttonAtlas;
    private BitmapFont font;
    public TextButton backButton;
    private TextButton.TextButtonStyle textButtonStyle;


    public SettingsView(Game game){
        globals = new Globals();
        this.game = game;
        screenHeight = globals.screenHeight;
        screenWidth = globals.screenWith;
        stage = new Stage();
        font = new BitmapFont();
        skin = new Skin();
        createAllButtons();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
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

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void createAllButtons(){
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.atlas"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("Button");
        textButtonStyle.down = skin.getDrawable("ButtonPressed");
        //

       backButton = new TextButton("Back to menu", textButtonStyle);
        int widthplacement = (int)(screenWidth/2-backButton.getWidth()/2);
        //

        //

        backButton.setPosition(widthplacement, 100);

        //
        font.getData().setScale(4);
        stage.addActor(backButton);

    }

}
