package com.mygdx.game.controllers;


public class DefenceViewController extends ViewController{


    public DefenceViewController(){
        super();
        fillTable();
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

}

