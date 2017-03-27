package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.Globals;

import java.util.ArrayList;

public abstract class View implements Screen {
    public Game game;
    protected Globals g = new Globals();
    protected ShapeRenderer sr = new ShapeRenderer();
    protected Table table;
    protected Table boardGrid;
    protected Stage stage;
    protected Skin skin;
    protected BitmapFont font;
    public TextButton rightButton;
    public TextButton leftButton;
    protected TextField money;
    public TextButton doneButton;
    protected TextureAtlas buttonAtlas;
    protected TextButton.TextButtonStyle buttonStyle;
    protected TextField.TextFieldStyle textFieldStyle;
    protected Texture tower1;
    protected ArrayList<Image> attackers;
    protected Cell c1;
    protected Cell c2;
    protected Cell c3;
    protected Cell c4;
    protected Cell c5;
    protected Cell c6;
    protected int gridSize = 8;

    public View(Game game){
        this.game = game;
        skin = new Skin();
        stage = new Stage();
        font = new BitmapFont();
        tower1 = new Texture(Gdx.files.internal("towerDefense_tile245.png"));
        attackers = new ArrayList<Image>(10);
        attackers.add(new Image(tower1));
        attackers.add(new Image(tower1));
        while(attackers.size()!= 10){
            attackers.add(new Image());
        }
        setUpButtons();
        setUpTable();
        createBoardGrid();
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
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
        Gdx.input.setInputProcessor(stage);
        //stage.act(Gdx.graphics.getDeltaTime());
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
        sr.rect(0,0,g.getScreenWidth(),g.getScreenHeight()-g.getScreenWidth());
        sr.end();
    }
    private void setUpTable(){
        table = new Table();
        table.setTouchable(Touchable.enabled);
        table.setDebug(true);
        table.setPosition((int)(g.getScreenWidth()*0.1),(int)((g.getScreenHeight()-g.getScreenWidth())*0.25));
        table.setHeight((int)((g.getScreenHeight()-g.getScreenWidth())*0.75));
        table.setWidth((int)(g.getScreenWidth()*0.8));

        c1 = table.add();
        c3 = table.add();
        c5 = table.add();
        table.row();
        c2 = table.add();
        c4 = table.add();
        c6 = table.add();
        float width = table.getWidth();
        float height = table.getHeight();
        c1.top().left();
        c1.width(width/3).height(height/2);
        c2.width(width/3).height(height/2);
        c3.width(width/3).height(height/2);
        c4.width(width/3).height(height/2);
        c5.width(width/3).height(height/2);
        c6.width(width/3).height(height/2);

        /*
        c1.setActorBounds(x,y+height/2,width/3,height/2);
        c2.setActorBounds(x,y,width/3,height/2);
        c3.setActorBounds(x+width/3,y+height/2,width/3,height/2);
        c4.setActorBounds(x+width/3,y,width/3,height/2);
        c5.setActorBounds(x+2*width/3,y+height/2,width/3,height/2);
        c6.setActorBounds(x+2*width/3,y,width/3,height/2);


        c1.top().left();
        c2.bottom().left();
        c3.top().center();
        c4.bottom().center();
        c5.top().right();
        c6.bottom().right();
        */

    }

    private void createBoardGrid(){
        boardGrid = new Table();
        boardGrid.setTouchable(Touchable.enabled);
        boardGrid.setDebug(true);
        boardGrid.setPosition(0,(int)(g.getScreenHeight()-g.getScreenWidth()));
        boardGrid.setHeight(g.getScreenWidth());
        boardGrid.setWidth(g.getScreenWidth());
        int size = g.getScreenWidth()/gridSize;
        for (int y = 0; y < gridSize; y++) {
            boardGrid.row();
            for (int x = 0; x < gridSize; x++) {
                boardGrid.add().size(size);
            }
        }
        stage.addActor(boardGrid);

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
        rightButton.setPosition((int)(g.getScreenWidth()*0.9),0);
        doneButton.setPosition((int)(g.getScreenWidth()*0.6),0);
        money.setPosition((int)(g.getScreenWidth()*0.1),0);

        leftButton.setWidth((int)(g.getScreenWidth()*0.1));
        leftButton.setHeight((int)(g.getScreenHeight()-g.getScreenWidth()));

        rightButton.setWidth(leftButton.getWidth());
        rightButton.setHeight(leftButton.getHeight());

        doneButton.setHeight((int)((g.getScreenHeight()-g.getScreenWidth())*0.25));
        doneButton.setWidth((int)(g.getScreenWidth()*0.3));
    }

    Game getGame(){
        return game;
    }

    Table getTable(){return table;}
}

