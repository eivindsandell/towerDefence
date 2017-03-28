package com.mygdx.game.controllers;


import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public class AttackViewController extends ViewController{

    private ArrayList<Image> attackers;

    public AttackViewController(){
        super();
        attackers = new ArrayList<Image>(10);
        attackers.add(new Image(attcker1));
        attackers.add(new Image(attcker1));
        while(attackers.size()!= 10){
            attackers.add(new Image());
        }
        doneButton.setText("Done!");
    }

    @Override
    public void create() {

    }

    public void fillTable(){
        addStuffToTable(attackers);
    }

    public void left(){
        decreaseListIndex(attackers);
    }

    public void right(){
        increaseListIndex(attackers);
    }

}

