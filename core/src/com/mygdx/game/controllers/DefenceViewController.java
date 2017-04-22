package com.mygdx.game.controllers;


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

        if(chosenCell!=null){
            if(chosenGridCell == prevChosenGridCell && money >= chosenTower.getPrice() && board.tileHasNoTowerAndIsPlacableTile(x,y)){
                Tower tower = g.whichTower(listIndex+tableCells.indexOf(chosenCell,true));
                board.placeTower(x,y,tower);
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
}

