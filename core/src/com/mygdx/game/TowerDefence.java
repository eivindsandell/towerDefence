package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.models.Board;
import com.mygdx.game.views.*;

public final class TowerDefence extends Game {

	private MenuView menuView;
	private DefenceView defenceView;
	private SettingsView settingsView;
	private AttackView attackView;
	private BetweenRoundView betweenRoundView;
	private PlayRoundView playRoundView;
	private Music music;
	private Preferences preferences;
	private Globals globals;
	private Board board;
	private Screen gameOverView;
	private EndgameView endgameView;

	@Override
	public void create() {
		globals = new Globals();
		board = Board.getInstance();
		menuView = new MenuView();
		preferences = Gdx.app.getPreferences("My Preferences");
		defenceView = new DefenceView(this);
		attackView = new AttackView(this);
		betweenRoundView = new BetweenRoundView(this);
		playRoundView = new PlayRoundView(this);
		music = Gdx.audio.newMusic(Gdx.files.internal("music/game_sound.mp3"));
		settingsView = new SettingsView(this, music, null);
		gameOverView = new GameOverView(this);
		//TEST: endgame
		endgameView = new EndgameView(this);
		this.setScreen(menuView);
		handleMusic();
		launchGame();
		settingsGame();
		backToMenuGame();
		quitGame();
		endGame();
	}

	private void launchGame(){
		menuView.localMpButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Button pressed!");
				setScreen(attackView);
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

	private void endGame(){
		menuView.helpButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Button pressed!");
				setScreen(endgameView);

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
		// Backbutton for endgame
		endgameView.backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Button pressed!");
				setScreen(menuView);
			}
		});
	}
	public DefenceView getDefenceView(){return defenceView;}
	public AttackView getAttackView(){return attackView;}
	public BetweenRoundView getBetweenRoundView(){return betweenRoundView;}
	public PlayRoundView getPlayRoundView(){return playRoundView;}

	public Screen getGameOverView() {
		return gameOverView;
	}
}
