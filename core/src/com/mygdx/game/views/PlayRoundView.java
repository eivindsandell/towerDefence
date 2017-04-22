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
    private Board board;
    private int counter;
    private Tile startTile;
    private Globals globals;

    public PlayRoundView(TowerDefence game){

        this.game = game;
        globals = new Globals();
        stage = new Stage();
        playRoundViewController = new PlayRoundViewController();
        board = new Board();
        counter = 0;
        startTile = findStartTile();

    }

    private Tile findStartTile() {
        for(int i=0;i<globals.getGridSize();i++){
            for(int j=0;j<globals.getGridSize();j++){
                if(board.getTile_board().get(i).get(j).getType()==Board.START){
                    return board.getTile_board().get(i).get(j);
                }
            }
        }
        return null;
    }

    @Override
    public void show() {
        stage.addActor(playRoundViewController.getBoard());
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getTile_board().get(i).get(j).getType()==Board.GROUND && board.getTile_board().get(i).get(j).getTower()!=null){
                    stage.addActor(board.getTile_board().get(i).get(j).getTower());
                }else{
                    for(Mob mob:board.getTile_board().get(i).get(j).getMobsOnTile()){
                        stage.addActor(mob);
                    }
                }
            }
        }
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        counter ++;
        spawnMob();
        stage.act(delta);
        stage.draw();
    }

    private void spawnMob() {
        if(timeToSpawnMob() && board.getMobsOnBoard().size() != 0){
            counter = 0;
            startTile.addMobToTile(board.getMobsOnBoard().remove());
        }
    }

    private boolean timeToSpawnMob() {
        return counter == 60;
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