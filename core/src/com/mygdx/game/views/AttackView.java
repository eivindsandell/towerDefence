package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.controllers.AttackViewController;

public class AttackView extends View{
    private BetweenRoundView betweenRoundView;
    private AttackViewController attackViewController;
    private int listIndex;

    public AttackView(Game game) {
        super(game);
        betweenRoundView = new BetweenRoundView(getGame());
        attackViewController = new AttackViewController(this);
        listIndex = 0;
        addStuffToTable();
        goNext();
        prevMenu();
        nextMenu();
    }

    public void increaseListIndex(){
        listIndex += 2;
        if(listIndex>8){listIndex = 0;}
        addStuffToTable();
    }

    public void decreaseListIndex(){
        listIndex -= 2;
        if(listIndex<0){listIndex = 8;}
        addStuffToTable();
    }
    private void addStuffToTable(){
        System.out.println(listIndex);
        c1.setActor(attackers.get((listIndex)));
        c2.setActor(attackers.get((listIndex+1)%10));
        c3.setActor(attackers.get((listIndex+2)%10));
        c4.setActor(attackers.get((listIndex+3)%10));
        c5.setActor(attackers.get((listIndex+4)%10));
        c6.setActor(attackers.get((listIndex+5)%10));
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
                attackViewController.left();


            }
        });
    }

    public void nextMenu(){
        rightButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                attackViewController.attackRightMenu();
                attackViewController.right();
            }
        });
    }



}