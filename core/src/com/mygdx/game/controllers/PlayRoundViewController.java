package com.mygdx.game.controllers;


import com.mygdx.game.Globals;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.mobs.Mob;

public class PlayRoundViewController extends ViewController {
    //todo: hele denne klassen.
    private Tile startTile;
    private int counter;
    public PlayRoundViewController(){

        startTile = findStartTile();
        counter = 0;
    }
    private Tile findStartTile() {
        for(int i=0;i<g.getGridSize();i++){
            for(int j=0;j<g.getGridSize();j++){
                if(board.getTile_board().get(i).get(j).getType()==Board.START){
                    return board.getTile_board().get(i).get(j);
                }
            }
        }
        return null;
    }

    public void spawnMob() {
        counter++;
        if(timeToSpawnMob() && board.getMobsOnBoard().size() != 0){
            counter = 0;
            startTile.addMobToTile(board.getMobsOnBoard().remove());
        }
    }

    private boolean timeToSpawnMob() {
        return counter == 60;
    }

}
