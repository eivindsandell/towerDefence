package com.mygdx.game.controllers;


import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.models.towers.Tower;

public class DefenceViewController extends ViewController{

    private Tower chosenTower;

    public DefenceViewController(){
        super();
        fillTable();
        chosenTower = null;
        money = 200;
        boardGrid.debug();
        setUpMoneyTable();
    }

    @Override
    public void create() {

    }

    public void fillTable(){
        addStuffToTable(g.getTowerTextures(),g.getQuestionMarkUs());
    }

    public void left(){
        decreaseListIndex(g.getTowerTextures(),g.getQuestionMarkUs());
    }
    public void right(){
        increaseListIndex(g.getTowerTextures(),g.getQuestionMarkUs());
    }

    @Override
    public void findSelectedGridSquare(float x, float y) {
        super.findSelectedGridSquare(x, y);
        if(chosenGridCell!= null){
            showTowerRange(x,y);
            //gridCells.get(boardGrid.getRow(y)*gridSize + (int)(x/(boardGrid.getWidth()/gridSize))).setActor(new Image(g.getSelected_tile()));
        }

        if(chosenCell!=null){
            if(chosenGridCell == prevChosenGridCell && money >= chosenTower.getPrice()){
                Tower tower = g.whichTower(listIndex+tableCells.indexOf(chosenCell,true));
                board.placeTower(boardGrid.getRow(y),(int)(x/(boardGrid.getWidth()/gridSize)),tower);
                chosenCell = null;
                money -= tower.getPrice();
            }
        }
    }

    @Override
    public void findPressedCell(float x, float y) {
        super.findPressedCell(x, y);
        if(chosenCell!=null){
            chosenTower = g.whichTower(listIndex+tableCells.indexOf(chosenCell,true));
        }
    }

    public void showTowerRange(float x, float y){
        //todo: les fra rangematrisen i tower og tegn tilsvarende ruter i boardgrid.
    }
}

