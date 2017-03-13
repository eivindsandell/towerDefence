package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class TowerDefence extends Game {

	MenuView menuView;
	DefenceView defenceView;

	@Override
	public void create() {
		menuView = new MenuView(this);
		defenceView = new DefenceView(this);
		this.setScreen(menuView);
		launchGame();
	}

	private void launchGame(){
		menuView.button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Button pressed!");
				setScreen(defenceView);
				menuView.dispose();
			}
		});
	}
}
