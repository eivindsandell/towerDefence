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
        addStuffToTable(g.getTowers(),g.getQuestionMarkUs());
    }

    public void left(){
        decreaseListIndex(g.getTowers(),g.getQuestionMarkUs());
    }
    public void right(){
        increaseListIndex(g.getTowers(),g.getQuestionMarkUs());
    }

}

