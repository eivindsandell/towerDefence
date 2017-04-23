package com.mygdx.game.controllers;



import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.mobs.Mob;
import com.mygdx.game.models.towers.Tower;

import java.util.ArrayList;

public class PlayRoundViewController extends ViewController {
    private Tile goalTile;
    //todo: hele denne klassen.
    private Tile startTile;
    private int counter;
    public PlayRoundViewController(){

        startTile = findStartTile();
        goalTile = findGoalTile();
        counter = 0;
        board.setSpawnedMobs(board.getMobsOnBoard().size());

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

    public boolean checkIfMobReachedGoal(){
        if (goalTile.getMobsOnTile().size()!=0){
            int damage = goalTile.getMobsOnTile().get(0).getDamage();
            goalTile.getMobsOnTile().get(0).dealDamage(90000);
            g.giveDamageToDefender(damage);
            System.out.println("a mob has reached the goal");
            if(g.getDefendersHP()<= 0){
                board.reset();
                return true;
            }
        }
        return false;
    }

    private boolean timeToSpawnMob() {
        return counter == 60;
    }

    public boolean checkIfAllMobsKilled() {
        if(board.getKilledMobs() == board.getSpawnedMobs()){
            return true;
        }
        return false;
    }

    public ArrayList<Tower> getPlacedTowers() {
        ArrayList<Tower> towers = new ArrayList<Tower>();
        for(ArrayList<Tile> tiles:board.getTile_board()){
            for(Tile tile:tiles){
                if(tile.getType()==Board.GROUND){
                    towers.add(tile.getTower());
                }
            }
        }
        return towers;
    }
}
