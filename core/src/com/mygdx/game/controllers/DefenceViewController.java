package com.mygdx.game.controllers;


import com.badlogic.gdx.Game;
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
    }

}
