package com.mygdx.game.controllers;


import com.badlogic.gdx.Game;
import com.mygdx.game.models.BasicMob;
import com.mygdx.game.views.AttackView;
import com.mygdx.game.views.BetweenRoundView;

public class AttackViewController extends Game{
    private AttackView attackView;
    private BetweenRoundView betweenRoundView;

    public AttackViewController(AttackView attackView){
        this.attackView = attackView;
    }


    @Override
    public void create() {
        betweenRoundView = new BetweenRoundView(this);
    }

    public void left(){ attackView.decreaseListIndex();}
    public void right(){ attackView.increaseListIndex();}

    public void attackLeftMenu(){
        System.out.println("Left menu");
    }

    public void attackRightMenu(){
        System.out.println("Right menu");
    }

}

