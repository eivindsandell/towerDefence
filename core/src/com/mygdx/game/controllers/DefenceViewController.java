package com.mygdx.game.controllers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.views.DefenceView;
import com.mygdx.game.views.PlayRoundView;

public class DefenceViewController extends Game{

    DefenceView defenceView;
    PlayRoundView playRoundView;
    public DefenceViewController(DefenceView defenceView){
        this.defenceView = defenceView;

    }


    @Override
    public void create() {
        playRoundView = new PlayRoundView(this);
        prevMenu();
        nextMenu();
        nextScreen();
    }
    public void prevMenu(){
        defenceView.leftButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");

            }
        });
    }
    public void nextMenu(){
        defenceView.rightButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");

            }
        });
    }
    public void nextScreen(){
        defenceView.doneButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                defenceView.dispose();
                setScreen(playRoundView);

            }
        });
    }
}
