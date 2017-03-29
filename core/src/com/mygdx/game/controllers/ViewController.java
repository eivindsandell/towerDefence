package com.mygdx.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Globals;
import com.mygdx.game.models.Board;

import java.util.ArrayList;

public class ViewController extends Game {

    protected Skin skin;

    protected Globals g = new Globals();
    protected ShapeRenderer sr = new ShapeRenderer();
    protected Board board = new Board();

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

    protected float cellwidth;
    protected float cellheight;

    private Array<Cell> tableCells;
    private Cell chosenCell;

    private Array<Cell> gridCells;
    private Cell chosenGridCell;

    public ViewController(){
        listIndex = 0;
        skin = new Skin();
        font = new BitmapFont();
        chosenCell = null;
        chosenGridCell = null;
        gridSize = 8;
        setUpButtons();
        setUpTable();
        createBoardGrid();
        gridCells = boardGrid.getCells();
        tableCells = table.getCells();
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
                boardGrid.add(board.getTile_board().get(y).get(x)).size(size);
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

        table.add().width(cellwidth).height(cellheight).top().left();
        table.add().width(cellwidth).height(cellheight);
        table.add().width(cellwidth).height(cellheight);
        table.row();
        table.add().width(cellwidth).height(cellheight);
        table.add().width(cellwidth).height(cellheight);
        table.add().width(cellwidth).height(cellheight);
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

    public void findSelectedGridSquare(float x, float y){
        int row = boardGrid.getRow(y);
        chosenGridCell = gridCells.get((row*gridSize)+(int)(x/(boardGrid.getWidth()/gridSize)));
    }

    public void fillSelectedGridSquare(Cell cell){
        if(cell!=null){
            float x = boardGrid.getX()+cell.getActorX();
            float y = boardGrid.getY()+cell.getActorY();
            sr.begin(ShapeRenderer.ShapeType.Filled);
            sr.setColor(0,0,1,1);
            sr.rect(x,y,boardGrid.getWidth()/gridSize,boardGrid.getHeight()/gridSize);
            sr.end();
        }
    }

    public void findPressedCell(float x, float y){
        int row = table.getRow(y);
        chosenCell = tableCells.get((row*3)+(int)(x/(cellwidth)));
        System.out.println(chosenCell.getActor().getName());
        System.out.println(g.getMobActorName());
        System.out.println(g.getTowerActorName());
        if(chosenCell.getActor().getName() != g.getTowerActorName()&&chosenCell.getActor().getName() != g.getMobActorName()){
            chosenCell = null;
        }
    }

    public void drawSquareAroundChosenTableCell() {
        if(chosenCell!=null){
            float x = table.getX()+chosenCell.getActorX();
            float y = table.getY()+chosenCell.getActorY();
            sr.begin(ShapeRenderer.ShapeType.Filled);
            sr.setColor(0, 1, 0, 1);
            sr.rect(x, y, cellwidth, cellheight);
            sr.end();
        }
    }

    public void increaseListIndex(ArrayList<Image> list,Texture noItemYet){
        listIndex += 2;
        if(listIndex>list.size()-2){listIndex = 0;}
        chosenCell = null;
        addStuffToTable(list,noItemYet);
    }

    public void decreaseListIndex(ArrayList<Image> list,Texture noItemYet){
        listIndex -= 2;
        if(listIndex<0){listIndex = list.size()-2+(list.size()%2);}
        chosenCell = null;
        addStuffToTable(list,noItemYet);
    }

    public void addStuffToTable(ArrayList<Image> list,Texture noItemyet){

        for (Cell cell:tableCells) {
            cell.setActor(null);
        }
        for(int i=0;i<tableCells.size;i++){
            for (int j=0;j<list.size()-listIndex;j++){
                if(j == 0 || j == 5)
                    tableCells.get(j).setActor(list.get((listIndex+j)%list.size()));
                if(j == 1)
                    tableCells.get(3).setActor(list.get((listIndex+j)%list.size()));
                if(j == 2)
                    tableCells.get(1).setActor(list.get((listIndex+j)%list.size()));
                if(j == 3)
                    tableCells.get(4).setActor(list.get((listIndex+j)%list.size()));
                if(j == 4)
                    tableCells.get(2).setActor(list.get((listIndex+j)%list.size()));
            }
            if(i>=list.size()-listIndex){
                if(i == 0 || i == 5)
                    tableCells.get(i).setActor(new Image(noItemyet));
                if(i == 1)
                    tableCells.get(3).setActor(new Image(noItemyet));
                if(i == 2)
                    tableCells.get(1).setActor(new Image(noItemyet));
                if(i == 3)
                    tableCells.get(4).setActor(new Image(noItemyet));
                if(i == 4)
                    tableCells.get(2).setActor(new Image(noItemyet));
            }
        }
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
    public Cell getChosenGridCell() {
        return chosenGridCell;
    }

    @Override
    public void create() {

    }
}