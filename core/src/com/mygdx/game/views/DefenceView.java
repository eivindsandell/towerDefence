package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class DefenceView extends View{
    PlayRoundView playRoundView;

    public DefenceView(Game game) {
        super(game);
        playRoundView = new PlayRoundView(getGame());
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
                game.setScreen(playRoundView);

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