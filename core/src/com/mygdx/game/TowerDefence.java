package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.views.DefenceView;
import com.mygdx.game.views.SettingsView;

public class TowerDefence extends Game {

	MenuView menuView;
	DefenceView defenceView;
	SettingsView settingsView;
	Music music;
	Preferences preferences;
	Globals globals;

	@Override
	public void create() {
		menuView = new MenuView(this);
		defenceView = new com.mygdx.game.views.DefenceView(this);
		globals = new Globals();
		preferences = Gdx.app.getPreferences("My Preferences");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/game_sound.mp3"));
		settingsView = new SettingsView(this, music, null);
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
				setScreen(defenceView);
				menuView.hide();
			}
		});
	}

	private void handleMusic(){
		music.play();
		music.setLooping(true);
		music.setVolume(0.5f);
		if (!preferences.getBoolean("musicEnabled")){
			music.pause();
		}
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
