package com.mygdx.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.Globals;

import java.util.ArrayList;

public class ViewController extends Game {

    protected Skin skin;
    protected Globals g = new Globals();

    protected ShapeRenderer sr = new ShapeRenderer();

    protected BitmapFont font;
    protected TextButton rightButton;
    protected TextButton leftButton;
    protected TextField money;
    protected TextButton doneButton;
    protected TextureAtlas buttonAtlas;
    protected TextButton.TextButtonStyle buttonStyle;
    protected TextField.TextFieldStyle textFieldStyle;

    protected int listIndex;

    protected Table table;
    protected Cell c1;
    protected Cell c2;
    protected Cell c3;
    protected Cell c4;
    protected Cell c5;
    protected Cell c6;

    protected Texture attcker1;
    protected Texture tower1;
    @Override
    public void create() {
        attcker1 = new Texture(Gdx.files.internal("towerDefense_tile245.png"));
        tower1 = new Texture(Gdx.files.internal("towerDefense_tile245.png"));
        skin = new Skin();
        font = new BitmapFont();
        setUpButtons();
        setUpTable();
    }
    protected void setUpTable(){
        table = new Table();
        table.setTouchable(Touchable.enabled);
        table.setDebug(true);
        table.setPosition((int)(g.getScreenWith()*0.1),(int)((g.getScreenHeight()-g.getScreenWith())*0.25));
        table.setHeight((int)((g.getScreenHeight()-g.getScreenWith())*0.75));
        table.setWidth((int)(g.getScreenWith()*0.8));

        float width = table.getWidth();
        float height = table.getHeight();
        c1 = table.add();
        c3 = table.add();
        c5 = table.add();
        table.row();
        c2 = table.add();
        c4 = table.add();
        c6 = table.add();
        c1.top().left();

        c1.width(width/3).height(height/2);
        c2.width(width/3).height(height/2);
        c3.width(width/3).height(height/2);
        c4.width(width/3).height(height/2);
        c5.width(width/3).height(height/2);
        c6.width(width/3).height(height/2);

    }

    protected void setUpButtons(){
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

    public void drawBackground(){
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0,0,0,1);
        sr.rect(0,0,g.getScreenWith(),g.getScreenHeight()-g.getScreenWith());
        sr.end();
    }
    public void increaseListIndex(ArrayList<Image> list){
        listIndex += 2;
        if(listIndex>8){listIndex = 0;}
        addStuffToTable(list);
    }

    public void decreaseListIndex(ArrayList<Image> list){
        listIndex -= 2;
        if(listIndex<0){listIndex = 8;}
        addStuffToTable(list);
    }

    public void addStuffToTable(ArrayList<Image> list){
        c1.setActor(null);
        c2.setActor(null);
        c3.setActor(null);
        c4.setActor(null);
        c5.setActor(null);
        c6.setActor(null);

        c1.setActor(list.get((listIndex)));
        c3.setActor(list.get((listIndex+2)%10));
        c5.setActor(list.get((listIndex+4)%10));
        c2.setActor(list.get((listIndex+1)%10));
        c4.setActor(list.get((listIndex+3)%10));
        c6.setActor(list.get((listIndex+5)%10));
    }

    public Table getTable(){return table;}
    public TextButton getLeftButton(){return leftButton;}
    public TextButton getRightButton(){return rightButton;}
    public TextButton getDoneButton(){return doneButton;}
    public TextField getMoney(){return money;}
}
