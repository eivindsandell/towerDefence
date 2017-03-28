package com.mygdx.game.controllers;


import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public class DefenceViewController extends ViewController{

    private ArrayList<Image> towers;

    public DefenceViewController(){
        super();
        towers = new ArrayList<Image>(10);
        towers.add(new Image(tower1));
        towers.add(new Image(tower1));
        while(towers.size()!= 10){
            towers.add(new Image());
        }
    }

    @Override
    public void create() {

    }

    public void fillTable(){
        addStuffToTable(towers);
    }

    public void left(){
        decreaseListIndex(towers);
    }
    public void right(){
        increaseListIndex(towers);
    }

}

