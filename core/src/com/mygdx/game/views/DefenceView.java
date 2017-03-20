package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Globals;

public class DefenceView implements Screen {
    Game game;
    Globals g = new Globals();
    ShapeRenderer sr = new ShapeRenderer();
    Table table;
    DragAndDrop dad;
    Stage stage;
    Skin skin;
    Button rightButton;
    Button leftButton;
    TextField money;
    Button doneButton;
    TextureAtlas buttonAtlas;
    Button.ButtonStyle buttonStyle;

    public DefenceView(Game game){
        this.game = game;
        skin = new Skin();
        table = new Table(skin);
        table.defaults();
        dad = new DragAndDrop();
        table.setTouchable(Touchable.enabled);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin.add("default", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        skin.add("badlogic", new Texture(Gdx.files.internal("badlogic.jpg")));

        setUpButtons();

        table.setPosition((int)(g.getScreenWith()*0.1),(int)((g.getScreenHeight()-g.getScreenWith())*0.25));
        table.setHeight((int)((g.getScreenHeight()-g.getScreenWith())*0.75));
        table.setWidth((int)(g.getScreenWith()*0.8));
        table.setColor(1,0,0,1);
        table.add("hei");
        table.add("hei2");
        table.add("hei3").row();
        table.add("hei4");
        table.add("hei5");
        table.add("hei6");
        table.setBackground("badlogic");

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
        displayUnitMenu();
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
    private void displayUnitMenu(){
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0,0,0,1);
        sr.rect(0,0,g.getScreenWith(),g.getScreenHeight()-g.getScreenWith());
        sr.end();
    }

    private void setUpButtons(){
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.atlas"));
        skin.addRegions(buttonAtlas);
        buttonStyle = new Button.ButtonStyle();
        buttonStyle.up = skin.getDrawable("Button");
        buttonStyle.down = skin.getDrawable("ButtonPressed");

        leftButton = new Button(buttonStyle);
        rightButton = new Button(buttonStyle);
        doneButton = new Button(buttonStyle);

        leftButton.setPosition(0,0);
        rightButton.setPosition((int)(g.getScreenWith()*0.9),0);
        doneButton.setPosition((int)(g.getScreenWith()*0.6),0);

        leftButton.setWidth((int)(g.getScreenWith()*0.1));
        leftButton.setHeight((int)(g.getScreenHeight()-g.getScreenWith()));

        rightButton.setWidth(leftButton.getWidth());
        rightButton.setHeight(leftButton.getHeight());

        doneButton.setHeight((int)((g.getScreenHeight()-g.getScreenWith())*0.25));
        doneButton.setWidth((int)(g.getScreenWith()*0.3));
    }
}

