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

    public static final int UPPERLEFT = 1;
    public static final int UPPERCENTER = 3;
    public static final int UPPERRIGHT = 5;
    public static final int LOWERLEFT = 2;
    public static final int LOWERCENTER = 4;
    public static final int LOWERRIGHT = 6;


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

    protected Table boardGrid;
    protected int gridSize;
    protected Table table;
    protected Cell c1;
    protected Cell c2;
    protected Cell c3;
    protected Cell c4;
    protected Cell c5;
    protected Cell c6;
    protected float cellwidth;
    protected float cellheight;

    protected Texture attcker1;
    protected Texture tower1;

    private Cell chosenCell;

    @Override
    public void create() {
        attcker1 = new Texture(Gdx.files.internal("towerDefense_tile245.png"));
        tower1 = new Texture(Gdx.files.internal("towerDefense_tile245.png"));

        skin = new Skin();
        font = new BitmapFont();
        chosenCell = null;
        gridSize = 8;
        setUpButtons();
        setUpTable();
        createBoardGrid();
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
    }

    protected void setUpTable(){
        table = new Table();
        table.setTouchable(Touchable.enabled);
        table.setDebug(true);
        table.setPosition((int)(g.getScreenWidth()*0.1),(int)((g.getScreenHeight()-g.getScreenWidth())*0.25));
        table.setHeight((int)((g.getScreenHeight()-g.getScreenWidth())*0.75));
        table.setWidth((int)(g.getScreenWidth()*0.8));

        cellwidth = table.getWidth()/3;
        cellheight = table.getHeight()/2;
        c1 = table.add();
        c3 = table.add();
        c5 = table.add();
        table.row();
        c2 = table.add();
        c4 = table.add();
        c6 = table.add();
        c1.top().left();
        c1.width(cellwidth).height(cellheight);
        c2.width(cellwidth).height(cellheight);
        c3.width(cellwidth).height(cellheight);
        c4.width(cellwidth).height(cellheight);
        c5.width(cellwidth).height(cellheight);
        c6.width(cellwidth).height(cellheight);

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

    public void drawBackground(){
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0,0,0,1);
        sr.rect(0,0,g.getScreenWidth(),g.getScreenHeight()-g.getScreenWidth());
        sr.end();
    }

    public void findPressedCell(float x, float y){
        System.out.print("Touched x = ");
        System.out.print(x);
        System.out.print(" | y = ");
        System.out.println(y);
        System.out.println(cellwidth);
        boolean rightCell = x > (2*cellwidth);
        boolean centerCell = x > (cellwidth);
        //if in first row
        if (y > cellheight){
            if (centerCell) {chosenCell = c3;}
            else{chosenCell = c1;}
            if (rightCell){chosenCell = c5;}
        }else{
            if (centerCell){chosenCell = c4;}
            else{chosenCell = c2;}
            if (rightCell){chosenCell = c6;}
        }
        System.out.println(getCellInt(chosenCell));
    }
    private int getCellInt(Cell c){
        if(c==c1){return UPPERLEFT;}
        if(c==c3){return UPPERCENTER;}
        if(c==c5){return UPPERRIGHT;}
        if(c==c2){return LOWERLEFT;}
        if(c==c4){return LOWERCENTER;}
        else{return LOWERRIGHT;}
    }
    public void drawSquareAroundChosenTableCell(Cell cell) {
        if(cell!=null){
            float x = table.getX()+cell.getActorX();
            float y = table.getY()+cell.getActorY();
            sr.begin(ShapeRenderer.ShapeType.Filled);
            sr.setColor(0, 1, 0, 1);
            sr.rect(x, y, cellwidth, cellheight);
            sr.end();
        }
    }

    public void increaseListIndex(ArrayList<Image> list){
        listIndex += 2;
        if(listIndex>8){listIndex = 0;}
        chosenCell = null;
        addStuffToTable(list);
    }

    public void decreaseListIndex(ArrayList<Image> list){
        listIndex -= 2;
        if(listIndex<0){listIndex = 8;}
        chosenCell = null;
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

    public Table getTable(){
        return table;
    }

    public TextButton getLeftButton(){return leftButton; }

    public TextButton getRightButton(){return rightButton; }

    public TextButton getDoneButton(){return doneButton; }

    public TextField getMoney(){return money;}

    public Table getBoard(){return boardGrid;}

    public Cell getChosenCell() {
        return chosenCell;
    }
}