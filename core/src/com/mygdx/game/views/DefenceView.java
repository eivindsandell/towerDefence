package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.Globals;

public class DefenceView implements Screen {
    private Game game;
    private Globals g = new Globals();
    private ShapeRenderer sr = new ShapeRenderer();
    private Table table;
    private Stage stage;
    private Skin skin;
    private BitmapFont font;
    public TextButton rightButton;
    public TextButton leftButton;
    private TextField money;
    public TextButton doneButton;
    private TextureAtlas buttonAtlas;
    private TextButton.TextButtonStyle buttonStyle;
    private TextField.TextFieldStyle textFieldStyle;

    public DefenceView(Game game){
        this.game = game;
        skin = new Skin();
        stage = new Stage();
        font = new BitmapFont();
        Gdx.input.setInputProcessor(stage);
        setUpButtons();
        setUpTable();
    }

    @Override
    public void show() {
        stage.addActor(table);
        stage.addActor(leftButton);
        stage.addActor(rightButton);
        stage.addActor(doneButton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(201/255f, 163/255f, 14/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
        stage.act(Gdx.graphics.getDeltaTime());
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
    private void drawBackground(){
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0,0,0,1);
        sr.rect(0,0,g.getScreenWith(),g.getScreenHeight()-g.getScreenWith());
        sr.end();
    }
    private void setUpTable(){
        table = new Table();
        table.setTouchable(Touchable.enabled);
        table.setDebug(true);
        table.setPosition((int)(g.getScreenWith()*0.1),(int)((g.getScreenHeight()-g.getScreenWith())*0.25));
        table.setHeight((int)((g.getScreenHeight()-g.getScreenWith())*0.75));
        table.setWidth((int)(g.getScreenWith()*0.8));
    }

    private void setUpButtons(){
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.atlas"));
        skin.addRegions(buttonAtlas);
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.up = skin.getDrawable("Button");
        buttonStyle.down = skin.getDrawable("ButtonPressed");
        buttonStyle.font = font;

        textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;

        leftButton = new TextButton("<",buttonStyle);
        rightButton = new TextButton(">",buttonStyle);
        doneButton = new TextButton("Play!",buttonStyle);
        money = new TextField("0",textFieldStyle);

        leftButton.setPosition(0,0);
        rightButton.setPosition((int)(g.getScreenWith()*0.9),0);
        doneButton.setPosition((int)(g.getScreenWith()*0.6),0);
        money.setPosition((int)(g.getScreenWith()*0.1),0);

        leftButton.setWidth((int)(g.getScreenWith()*0.1));
        leftButton.setHeight((int)(g.getScreenHeight()-g.getScreenWith()));

        rightButton.setWidth(leftButton.getWidth());
        rightButton.setHeight(leftButton.getHeight());

        doneButton.setHeight((int)((g.getScreenHeight()-g.getScreenWith())*0.25));
        doneButton.setWidth((int)(g.getScreenWith()*0.3));
    }
}

