package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.controllers.AttackViewController;

public class AttackView extends View{
    BetweenRoundView betweenRoundView;
    AttackViewController attackViewController;

    public AttackView(Game game) {
        super(game);
        betweenRoundView = new BetweenRoundView(getGame());
        attackViewController = new AttackViewController(this);
        goNext();
        prevMenu();
        nextMenu();
    }




    private void goNext(){
        doneButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                dispose();
                game.setScreen(betweenRoundView);

            }
        });
    }

    public void prevMenu(){
        leftButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                attackViewController.attackLeftMenu();


            }
        });
    }

    public void nextMenu(){
        rightButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                attackViewController.attackRightMenu();
            }
        });
    }



}