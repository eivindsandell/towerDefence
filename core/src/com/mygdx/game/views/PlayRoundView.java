package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Globals;
import com.mygdx.game.TowerDefence;
import com.mygdx.game.controllers.PlayRoundViewController;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.mobs.Mob;

public class PlayRoundView implements Screen {
    private TowerDefence game;
    private Stage stage;
    private PlayRoundViewController playRoundViewController;

    public PlayRoundView(TowerDefence game){

        this.game = game;
        stage = new Stage();
        playRoundViewController = new PlayRoundViewController();

    }

    @Override
    public void show() {
        stage.addActor(playRoundViewController.getBoard());

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(playRoundViewController.spawnMob()){
         stage.addActor(playRoundViewController.getStartTile().getMobsOnTile().get(0));
        }
        playRoundViewController.checkIfMobReachedGoal();
        stage.act(delta);
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.clear();
    }

    @Override
    public void dispose() {

    }


    public void updateAllActors(){
        //todo: kall på en tilsvarende funksjon i controlleren
    }
}