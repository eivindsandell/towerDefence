package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class AttackView extends View{
    BetweenRoundView betweenRoundView;

    public AttackView(Game game) {
        super(game);
        betweenRoundView = new BetweenRoundView(getGame());
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

            }
        });
    }

    public void nextMenu(){
        rightButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");

            }
        });
    }



}