package com.mygdx.game.controllers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.views.AttackView;
import com.mygdx.game.views.BetweenRoundView;

public class AttackViewController extends Game{
    AttackView attackView;
    BetweenRoundView betweenRoundView;
    public AttackViewController(AttackView attackView){
        this.attackView = attackView;

    }


    @Override
    public void create() {
        betweenRoundView = new BetweenRoundView(this);
        attackView.leftButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");

            }
        });
        attackView.rightButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");

            }
        });
        attackView.doneButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                attackView.dispose();
                setScreen(betweenRoundView);

            }
        });
    }
}

