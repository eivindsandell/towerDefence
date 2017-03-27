package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.controllers.AttackViewController;

import java.util.ArrayList;

public class AttackView extends View{
    private BetweenRoundView betweenRoundView;
    private AttackViewController attackViewController;
    private int listIndex;
    private Texture tower1;
    private ArrayList<Image> attackers;

    public AttackView(Game game) {
        super(game);
        betweenRoundView = new BetweenRoundView(getGame());
        attackViewController = new AttackViewController(this);
        listIndex = 0;
        tower1 = new Texture(Gdx.files.internal("towerDefense_tile245.png"));
        attackers = new ArrayList<Image>(10);
        attackers.add(new Image(tower1));
        attackers.add(new Image(tower1));
        while(attackers.size()!= 10){
            attackers.add(new Image());
        }
        addStuffToTable();
        goNext();
        prevMenu();
        nextMenu();
    }

    public void increaseListIndex(){
        listIndex += 2;
        if(listIndex>8){listIndex = 0;}
        addStuffToTable();
        super.render(0);
    }

    public void decreaseListIndex(){
        listIndex -= 2;
        if(listIndex<0){listIndex = 8;}
        addStuffToTable();
    }
    private void addStuffToTable(){
        System.out.println(listIndex);
        System.out.println((listIndex+2)%10);
        c1.setActor(null);
        c2.setActor(null);
        c3.setActor(null);
        c4.setActor(null);
        c5.setActor(null);
        c6.setActor(null);

        c1.setActor(attackers.get((listIndex)));
        c3.setActor(attackers.get((listIndex+2)%10));
        c5.setActor(attackers.get((listIndex+4)%10));
        c2.setActor(attackers.get((listIndex+1)%10));
        c4.setActor(attackers.get((listIndex+3)%10));
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