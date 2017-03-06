package com.mygdx.game;

import com.badlogic.gdx.Game;

public class TowerDefence extends Game {


	@Override
	public void create() {
		this.setScreen(new MenuView(this));
	}
}
