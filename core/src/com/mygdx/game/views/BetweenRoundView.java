package com.mygdx.game.views;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Globals;
import com.mygdx.game.TowerDefence;

public class BetweenRoundView implements Screen {
    TowerDefence game;
    Globals globals = new Globals();
    private Stage stage;
    private Skin skin;
    private int screenHeight;
    private int screenWidth;
    private TextureAtlas buttonAtlas;
    private BitmapFont font;
    public TextButton nextButton;
    private TextButton.TextButtonStyle textButtonStyle;



    public BetweenRoundView(TowerDefence game){
        globals = new Globals();
        this.game = game;
        screenHeight = globals.getScreenHeight();
        screenWidth = globals.getScreenWith();
        stage = new Stage();
        font = new BitmapFont();
        skin = new Skin();
        createAllButtons();

    }

    @Override
    public void show() {
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

    }

    @Override
    public void dispose() {
        stage.clear();
    }

    private void createAllButtons(){
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.atlas"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("Button");
        textButtonStyle.down = skin.getDrawable("ButtonPressed");
        //

        nextButton = new TextButton("Defence player ready", textButtonStyle);
        int widthPlacement = (int)(screenWidth/2-nextButton.getWidth()/2);
        //

        //

        nextButton.setPosition(widthPlacement, 100);
        //
        font.getData().setScale(4);

        goNext();
    }

    private void goNext(){
        nextButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                dispose();
                game.setScreen(game.getDefenceView());

            }
        });
    }

}
