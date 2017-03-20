package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Globals;

import static com.badlogic.gdx.Input.Keys.R;


public class SettingsView implements Screen {
    Game game;
    private Globals globals;
    private Stage stage;
    private Skin skin;
    private int screenHeight;
    private int screenWidth;
    private TextureAtlas buttonAtlas;
    private TextureAtlas checkBoxAtlas;
    private BitmapFont font;
    public TextButton backButton;
    private CheckBox soundCheck;
    private CheckBox.CheckBoxStyle checkBoxStyle;
    private TextButton.TextButtonStyle textButtonStyle;


    public SettingsView(Game game){
        globals = new Globals();
        this.game = game;
        screenHeight = globals.getScreenHeight();
        screenWidth = globals.getScreenWith();
        stage = new Stage();
        font = new BitmapFont();
        skin = new Skin();
        createAllButtons();
        createCheckBox();
    }

    @Override
    public void show() {

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

    private void createCheckBox(){
        checkBoxAtlas = new TextureAtlas(Gdx.files.internal("checkBoxes/checkBoxPack.atlas"));
        checkBoxStyle = new CheckBox.CheckBoxStyle();
        checkBoxStyle.font = font;
        checkBoxStyle.fontColor = new Color(Color.BLACK);
        checkBoxStyle.checkboxOff = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("checkBoxes/checkbox_unchecked.png"))));
        checkBoxStyle.checkboxOn = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("checkBoxes/checkbox_checked.png"))));
        //checkBoxStyle.checked = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("checkBoxes/checkbox_checked.png"))));
        soundCheck = new CheckBox("Disable Sound", checkBoxStyle);
        int checkButtonWidth = (int) (soundCheck.getWidth());
        soundCheck.setPosition(screenWidth/2-checkButtonWidth/2, screenHeight/2);
        soundCheck.setChecked(false);
        stage.addActor(soundCheck);

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
        int widthPlacement = (int)(screenWidth/2-backButton.getWidth()/2);
        //

        //

        backButton.setPosition(widthPlacement, 100);
        //
        font.getData().setScale(4);
        stage.addActor(backButton);

    }

}
