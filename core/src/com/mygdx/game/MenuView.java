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

public class MenuView implements Screen {

    private Game game;
    private Globals globals;
    private Stage stage;
    private Skin skin;
    private int screenHeight;
    private int screenWidth;
    private TextureAtlas buttonAtlas;
    private BitmapFont font;
    private TextButton.TextButtonStyle textButtonStyle;
    public TextButton localMpButton;
    private TextButton MpButton;
    public TextButton settingsButton;
    public TextButton helpButton;
    public TextButton quitButton;

    public MenuView(Game game){
        this.game = game;
        globals = new Globals();
        screenHeight = globals.screenHeight;
        screenWidth = globals.screenWith;
        stage = new Stage();
        font = new BitmapFont();
        skin = new Skin();
        createAllButtons();
    }

    @Override
    public void show() {
        System.out.println("testing print");
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
        textButtonStyle.checked = skin.getDrawable("ButtonPressed");
        //
        localMpButton = new TextButton("Local Multiplayer", textButtonStyle);
        MpButton = new TextButton("Online Multiplayer", textButtonStyle);
        settingsButton = new TextButton("Settings", textButtonStyle);
        helpButton = new TextButton("Help", textButtonStyle);
        quitButton = new TextButton("Quit", textButtonStyle);
        //
        int widthplacement = (int)(screenWidth/2-localMpButton.getWidth()/2);
        int buttonheight = (int)localMpButton.getHeight();
        int buffer = (int)buttonheight/2;
        //
        settingsButton.setPosition(widthplacement,screenHeight/2-buttonheight/2);
        localMpButton.setPosition(widthplacement,settingsButton.getY()+ 2*buttonheight + 2*buffer);
        MpButton.setPosition(widthplacement,settingsButton.getY()+buttonheight + buffer);
        helpButton.setPosition(widthplacement,settingsButton.getY() - buttonheight- buffer);
        quitButton.setPosition(widthplacement,settingsButton.getY() - 2*buttonheight - 2*buffer);
        MpButton.setDisabled(true);
        //
        font.getData().setScale(4);
        stage.addActor(localMpButton);
        stage.addActor(MpButton);
        stage.addActor(settingsButton);
        stage.addActor(helpButton);
        stage.addActor(quitButton);
    }
}

