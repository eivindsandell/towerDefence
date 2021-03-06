package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MenuView implements Screen {

    private Globals g;
    private int screenHeight;
    private int screenWidth;
    public TextButton localMpButton;
    private TextButton MpButton;
    public TextButton settingsButton;
    public TextButton helpButton;
    public TextButton quitButton;
    private Stage stage;

    public MenuView(){
        g = new Globals();
        stage = new Stage();
        screenHeight = g.getScreenHeight();
        screenWidth = g.getScreenWidth();
        createAllButtons();
    }

    @Override
    public void show() {
        System.out.println("testing print");
        stage.addActor(localMpButton);
        stage.addActor(MpButton);
        stage.addActor(settingsButton);
        stage.addActor(helpButton);
        stage.addActor(quitButton);
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

    private void createAllButtons(){
        localMpButton = new TextButton("Local Multiplayer", g.getTextButtonStyle());
        MpButton = new TextButton("Online Multiplayer", g.getTextButtonStyle());
        settingsButton = new TextButton("Settings", g.getTextButtonStyle());
        helpButton = new TextButton("Help", g.getTextButtonStyle());
        quitButton = new TextButton("Quit", g.getTextButtonStyle());
        //
        float ratio = localMpButton.getHeight() / localMpButton.getWidth();
        //
        localMpButton.setWidth((int)(screenWidth*0.7));
        localMpButton.setHeight((int)(ratio*localMpButton.getWidth()));
        MpButton.setWidth((int)(screenWidth*0.7));
        MpButton.setHeight((int)(ratio*MpButton.getWidth()));
        settingsButton.setWidth((int)(screenWidth*0.7));
        settingsButton.setHeight((int)(ratio*settingsButton.getWidth()));
        helpButton.setWidth((int)(screenWidth*0.7));
        helpButton.setHeight((int)(ratio*helpButton.getWidth()));
        quitButton.setWidth((int)(screenWidth*0.7));
        quitButton.setHeight((int)(ratio*quitButton.getWidth()));
        //
        int buttonheight = (int)localMpButton.getHeight();
        int widthplacement = (int)(screenWidth/2-localMpButton.getWidth()/2);
        int buffer = (int)localMpButton.getHeight()/2;
        settingsButton.setPosition(widthplacement,screenHeight/2-buttonheight/2);
        localMpButton.setPosition(widthplacement,settingsButton.getY()+ 2*buttonheight + 2*buffer);
        MpButton.setPosition(widthplacement,settingsButton.getY()+buttonheight + buffer);
        helpButton.setPosition(widthplacement,settingsButton.getY() - buttonheight- buffer);
        quitButton.setPosition(widthplacement,settingsButton.getY() - 2*buttonheight - 2*buffer);
        MpButton.setDisabled(true);
    }
}

