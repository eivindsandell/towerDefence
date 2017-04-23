package com.mygdx.game.controllers;


import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.models.towers.Tower;

public class DefenceViewController extends ViewController{

    private Tower chosenTower;

    public DefenceViewController(){
        super();
        fillTable();
        chosenTower = null;
        boardGrid.debug();
        setUpMoneyTable(g.getDefence_money());
    }

    @Override
    public void create() {

    }

    public Integer getMoney(){
        return g.getDefence_money();
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
        }

        if(chosenCell!=null){
            if(chosenGridCell == prevChosenGridCell && g.getDefence_money() >= chosenTower.getPrice()){
                Tower tower = g.whichTower(listIndex+tableCells.indexOf(chosenCell,true));
                board.placeTower(boardGrid.getRow(y),(int)(x/(boardGrid.getWidth()/gridSize)),tower);
                chosenCell = null;
                prevChosenGridCell = null;
                g.setDefence_money(g.getDefence_money() - tower.getPrice());
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

