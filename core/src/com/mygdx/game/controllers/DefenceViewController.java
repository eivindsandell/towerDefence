package com.mygdx.game.controllers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.models.BasicMob;
import com.mygdx.game.views.AttackView;
import com.mygdx.game.views.BetweenRoundView;
import com.mygdx.game.views.DefenceView;

import java.util.ArrayList;

public class DefenceViewController extends ViewController{

    private DefenceView defenceView;
    private int listIndex;
    private Texture tower1;
    private ArrayList<Image> towers;

    public DefenceViewController(DefenceView defenceView){
        this.defenceView = defenceView;
        listIndex = 0;
        create();
    }


    @Override
    public void create() {
        super.create();
        tower1 = new Texture(Gdx.files.internal("towerDefense_tile245.png"));
        towers = new ArrayList<Image>(10);
        towers.add(new Image(tower1));
        towers.add(new Image(tower1));
        while(towers.size()!= 10){
            towers.add(new Image());
        }
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

    public void attackLeftMenu(){
        System.out.println("Left menu");
    }

    public void attackRightMenu(){
        System.out.println("Right menu");
    }
}

