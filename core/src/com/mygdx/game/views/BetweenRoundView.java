package com.mygdx.game.views;


import com.badlogic.gdx.Game;
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

public class BetweenRoundView implements Screen {
    Game game;
    Globals globals = new Globals();
    private Stage stage;
    private Skin skin;
    private int screenHeight;
    private int screenWidth;
    private TextureAtlas buttonAtlas;
    private BitmapFont font;
    public TextButton nextButton;
    private TextButton.TextButtonStyle textButtonStyle;
    DefenceView defenceView;
    private Label.LabelStyle labelStyle;
    private Label infoText;


    public BetweenRoundView(Game game){
        defenceView = new DefenceView(this.game);
        globals = new Globals();
        this.game = game;
        screenHeight = globals.getScreenHeight();
        screenWidth = globals.getScreenWith();
        stage = new Stage();
        font = new BitmapFont();
        skin = new Skin();
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
        nextButton = new TextButton("Defence player ready", textButtonStyle);
        nextButton.setWidth((int)(screenWidth*0.7));
        float ratio = nextButton.getHeight() / nextButton.getWidth();
        nextButton.setHeight((int)(ratio*nextButton.getWidth()));
        int widthPlacement = (int)(screenWidth/2-nextButton.getWidth()/2);
        nextButton.setPosition(widthPlacement, 100);
        font.getData().setScale(2);

        goNext();
    }

    private void createText(){
        labelStyle = new Label.LabelStyle();
        font.setColor(0,0,0,1);
        labelStyle.font = font;
        infoText = new Label("Pass the phone to the defending player", labelStyle);
        infoText.setPosition(screenWidth,screenHeight/2);
    }

    private void goNext(){
        nextButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                dispose();
                game.setScreen(defenceView);

            }
        });
    }

}
