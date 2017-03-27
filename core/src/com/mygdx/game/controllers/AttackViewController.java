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

import java.util.ArrayList;

public class AttackViewController extends ViewController{

    private AttackView attackView;
    private int listIndex;
    private ArrayList<Image> attackers;

    public AttackViewController(AttackView attackView){
        this.attackView = attackView;
        listIndex = 0;
        create();
    }

    @Override
    public void create() {
        super.create();
        attackers = new ArrayList<Image>(10);
        attackers.add(new Image(attcker1));
        attackers.add(new Image(attcker1));
        while(attackers.size()!= 10){
            attackers.add(new Image());
        }
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

    public void attackLeftMenu(){
        System.out.println("Left menu");
    }

    public void attackRightMenu(){
        System.out.println("Right menu");
    }
}

