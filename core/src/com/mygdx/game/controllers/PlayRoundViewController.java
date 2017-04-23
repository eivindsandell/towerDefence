package com.mygdx.game.controllers;



import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.mobs.Mob;

public class PlayRoundViewController extends ViewController {
    private Tile goalTile;
    //todo: hele denne klassen.
    private Tile startTile;
    private int counter;
    public PlayRoundViewController(){

        startTile = findStartTile();
        goalTile = findGoalTile();
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
    private Tile findGoalTile() {
        for(int i=0;i<g.getGridSize();i++){
            for(int j=0;j<g.getGridSize();j++){
                if(board.getTile_board().get(i).get(j).getType()==Board.GOAL){
                    return board.getTile_board().get(i).get(j);
                }
            }
        }
        return null;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public boolean spawnMob() {
        counter++;
        if(timeToSpawnMob() && board.getMobsOnBoard().size() != 0){
            counter = 0;
            System.out.println("spawn");
            startTile.addMobToTile(board.getMobsOnBoard().remove());
            return true;
        }
        return false;
    }

    public void checkIfMobReachedGoal(){
        if (goalTile.getMobsOnTile().size()!=0){
            System.out.println("a mob has reached the goal");
        }
    }

    private boolean timeToSpawnMob() {
        return counter == 60;
    }

}
