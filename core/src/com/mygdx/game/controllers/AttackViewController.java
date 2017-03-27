package com.mygdx.game.controllers;


import com.badlogic.gdx.Game;
import com.mygdx.game.models.BasicMob;
import com.mygdx.game.views.AttackView;
import com.mygdx.game.views.BetweenRoundView;

public class AttackViewController extends Game{
    AttackView attackView;
    BetweenRoundView betweenRoundView;

    public AttackViewController(AttackView attackView){
    }


    @Override
    public void create() {
        betweenRoundView = new BetweenRoundView(this);
        attackView = new AttackView(this);
    }


    public void attackLeftMenu(){
        System.out.println("Left menu");
    }

    public void attackRightMenu(){
        System.out.println("Right menu");
    }

}

