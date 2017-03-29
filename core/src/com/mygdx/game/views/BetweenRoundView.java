package com.mygdx.game.views;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Globals;
import com.mygdx.game.TowerDefence;

public class BetweenRoundView implements Screen {
    TowerDefence game;
    Globals globals = new Globals();
    private Stage stage;
    private int screenHeight;
    private int screenWidth;
    public TextButton nextButton;
    private TextButton.TextButtonStyle textButtonStyle;
    private Label.LabelStyle labelStyle;
    private Label infoText;



    public BetweenRoundView(TowerDefence game){
        globals = new Globals();
        this.game = game;
        screenHeight = globals.getScreenHeight();
        screenWidth = globals.getScreenWidth();
        stage = new Stage();
        createAllButtons();
        createText();

    }

    @Override
    public void show() {
        stage.addActor(infoText);
        stage.addActor(nextButton);
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
        stage.clear();
    }

    private void createAllButtons(){
        nextButton = new TextButton("Defence player \n ready", globals.getTextButtonStyle());
        nextButton.setWidth((int)(screenWidth*0.7));
        float ratio = nextButton.getHeight() / nextButton.getWidth();
        nextButton.setHeight((int)(ratio*nextButton.getWidth()));
        int widthPlacement = (int)(screenWidth/2-nextButton.getWidth()/2);
        nextButton.setPosition(widthPlacement, 100);
        goNext();
    }

    private void createText(){
        labelStyle = new Label.LabelStyle();
        labelStyle.font = globals.getFont();
        labelStyle.font.setColor(0,0,0,1);
        infoText = new Label("Pass the phone to the defending player", labelStyle);
        infoText.setPosition(screenWidth,screenHeight/2);
    }

    private void goNext(){
        nextButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                game.setScreen(game.getDefenceView());

            }
        });
    }

}
