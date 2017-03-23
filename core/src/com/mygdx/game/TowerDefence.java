package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.controllers.AttackViewController;
import com.mygdx.game.controllers.DefenceViewController;
import com.mygdx.game.controllers.PlayRoundViewController;
import com.mygdx.game.views.*;

public class TowerDefence extends Game {

	MenuView menuView;
	DefenceView defenceView;
	SettingsView settingsView;
	AttackView attackView;
	BetweenRoundView betweenRoundView;
	PlayRoundView playRoundView;
	Music music;
	DefenceViewController defenceViewController;
	AttackViewController attackViewController;
	PlayRoundViewController playRoundViewController;


	@Override
	public void create() {
		menuView = new MenuView(this);
		defenceView = new DefenceView(this);
		defenceViewController = new DefenceViewController(defenceView);
		attackView = new AttackView(this);
		attackViewController = new AttackViewController(attackView);
		betweenRoundView = new BetweenRoundView(this);
		music = Gdx.audio.newMusic(Gdx.files.internal("music/game_sound.mp3"));
		settingsView = new SettingsView(this, music);
		this.setScreen(menuView);
		handleMusic();
		launchGame();
		settingsGame();
		backToMenuGame();
		quitGame();
	}

	private void launchGame(){
		menuView.localMpButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Button pressed!");
				setScreen(betweenRoundView);
				menuView.hide();
			}
		});
	}

	private void handleMusic(){
		music.play();
		music.setLooping(true);
		music.setVolume(0.5f);
	}

	private void quitGame(){
		menuView.quitButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
	}

	private void settingsGame(){
		menuView.settingsButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Button pressed!");
				setScreen(settingsView);

			}
		});
	}

	private void backToMenuGame(){
		settingsView.backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Button pressed!");
				setScreen(menuView);
			}
		});
	}
}
