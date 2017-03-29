package com.mygdx.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Globals;
import com.mygdx.game.models.Board;

import java.util.ArrayList;

public class ViewController extends Game {


    protected Globals g = new Globals();
    protected ShapeRenderer sr = new ShapeRenderer();
    protected Board board = new Board();

    protected TextButton rightButton;
    protected TextButton leftButton;
    protected Label moneyLabel;
    protected TextButton doneButton;
    protected int listIndex;

    protected Table table;
    protected Table boardGrid;
    protected Table moneyTable;

    protected int gridSize;

    protected float cellwidth;
    protected float cellheight;

    protected Array<Cell> tableCells;
    protected Cell chosenCell;

    protected Array<Cell> gridCells;
    protected Cell chosenGridCell;
    protected String money;

    public ViewController(){
        money = "0";
        listIndex = 0;
        chosenCell = null;
        chosenGridCell = null;
        gridSize = 8;
        setUpButtons();
        setUpTable();
        createBoardGrid();
        setUpMoneyTable();
        gridCells = boardGrid.getCells();
        tableCells = table.getCells();
    }

    public void drawBackground(){
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0,0,0,1);
        sr.rect(0,0,g.getScreenWidth(),g.getScreenHeight()-g.getScreenWidth());
        sr.end();
    }
    protected void setUpButtons(){
        leftButton = new TextButton("<",g.getTextButtonStyle());
        rightButton = new TextButton(">",g.getTextButtonStyle());
        doneButton = new TextButton("Play!",g.getTextButtonStyle());

        leftButton.setPosition(0,0);
        rightButton.setPosition((int)(g.getScreenWidth()*0.9),0);
        doneButton.setPosition((int)(g.getScreenWidth()*0.6),0);

        leftButton.setWidth((int)(g.getScreenWidth()*0.1));
        leftButton.setHeight((int)(g.getScreenHeight()-g.getScreenWidth()));

        rightButton.setWidth(leftButton.getWidth());
        rightButton.setHeight(leftButton.getHeight());

        doneButton.setHeight((int)((g.getScreenHeight()-g.getScreenWidth())*0.25));
        doneButton.setWidth((int)(g.getScreenWidth()*0.3));
    }
    protected void setUpMoneyTable(){
        moneyLabel = new Label(money,g.getLabelStyle());

        moneyTable = new Table();
        moneyTable.setBounds(g.getScreenWidth()/10,0,g.getScreenWidth()/2,(g.getScreenHeight()-g.getScreenWidth())/4);
        moneyTable.add(moneyLabel).left().width((float)(g.getScreenWidth()*0.3)).height((float)((g.getScreenHeight()-g.getScreenWidth())*0.25));
        moneyTable.add().expand();
        moneyTable.debug();
    }

    //functions for the hud table:
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
    public void findPressedCell(float x, float y){
        int row = table.getRow(y);
        Cell prevcell = chosenCell;
        chosenCell = tableCells.get((row*3)+(int)(x/(cellwidth)));
        if(chosenCell.getActor().getName() != g.getActorName()){
            chosenCell = null;
        }
        if(chosenCell == prevcell){
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
    public void increaseListIndex(ArrayList<Texture> list,Texture noItemYet){
        listIndex += 2;
        if(listIndex>list.size()-2){listIndex = 0;}
        chosenCell = null;
        addStuffToTable(list,noItemYet);
    }
    public void decreaseListIndex(ArrayList<Texture> list,Texture noItemYet){
        listIndex -= 2;
        if(listIndex<0){listIndex = list.size()-2+(list.size()%2);}
        chosenCell = null;
        addStuffToTable(list,noItemYet);
    }
    public void addStuffToTable(ArrayList<Texture> list,Texture noItemyet){

        for (Cell cell:tableCells) {
            cell.setActor(null);
        }
        for(int i=0;i<tableCells.size;i++){
            for (int j=0;j<list.size()-listIndex;j++){
                if(j == 0 || j == 5)
                    tableCells.get(j).setActor(new Image(list.get((listIndex+j)%list.size()))).getActor().setName(g.getActorName());
                if(j == 1)
                    tableCells.get(3).setActor(new Image(list.get((listIndex+j)%list.size()))).getActor().setName(g.getActorName());
                if(j == 2)
                    tableCells.get(1).setActor(new Image(list.get((listIndex+j)%list.size()))).getActor().setName(g.getActorName());
                if(j == 3)
                    tableCells.get(4).setActor(new Image(list.get((listIndex+j)%list.size()))).getActor().setName(g.getActorName());
                if(j == 4)
                    tableCells.get(2).setActor(new Image(list.get((listIndex+j)%list.size()))).getActor().setName(g.getActorName());
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

    //functions for the grid:
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
    public void findSelectedGridSquare(float x, float y){
        int row = boardGrid.getRow(y);
        chosenGridCell = gridCells.get((row*gridSize)+(int)(x/(boardGrid.getWidth()/gridSize)));
    }
    public void fillSelectedGridSquare(){
        if(chosenGridCell!=null){
            float x = boardGrid.getX()+chosenGridCell.getActorX();
            float y = boardGrid.getY()+chosenGridCell.getActorY();
            sr.begin(ShapeRenderer.ShapeType.Filled);
            sr.setColor(0,0,1,1);
            sr.rect(x,y,boardGrid.getWidth()/gridSize,boardGrid.getHeight()/gridSize);
            sr.end();
        }
    }

    //getters
    public Table getTable(){
        return table;
    }
    public TextButton getLeftButton(){return leftButton; }
    public TextButton getRightButton(){return rightButton; }
    public TextButton getDoneButton(){return doneButton; }
    public Table getBoard(){return boardGrid;}
    public Cell getChosenCell() {
        return chosenCell;
    }
    public Cell getChosenGridCell() {
        return chosenGridCell;
    }
    public Table getMoneyTable() {

        return moneyTable;
    }

    @Override
    public void create() {

    }

    public void updateMoneyTable() {
        moneyLabel.setText(money);
        moneyLabel.setAlignment(Align.right);
    }
}