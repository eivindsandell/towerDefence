package com.mygdx.game.controllers;


public class AttackViewController extends ViewController{


    public AttackViewController(){
        super();
        fillTable();
        doneButton.setText("Done!");
    }

    @Override
    public void create() {

    }

    public void fillTable(){
        addStuffToTable(g.getAttackers(),g.getQuestionMarkMex());
    }

    public void left(){
        decreaseListIndex(g.getAttackers(),g.getQuestionMarkMex());
    }

    public void right(){
        increaseListIndex(g.getAttackers(),g.getQuestionMarkMex());
    }

}

