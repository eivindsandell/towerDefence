package com.mygdx.game.models;


import com.mygdx.game.models.mobs.Mob;
import com.mygdx.game.models.towers.Tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public final class Board {

    private ArrayList<ArrayList<Tile>> tile_board;
    private ArrayList<ArrayList<Integer>> pre_board; //0: Ground, 1: Road, 2: Start, 3: Goal
    private int size;
    private ArrayList<Tower> towersOnBoard;
    private Queue<Mob> mobsOnBoard;
    private int attackerMoney;
    private int defenderMoney;
    private double towerHealth;

    public Board(ArrayList<ArrayList<Integer>> pre_board) {
        this.pre_board = pre_board;
        tile_board = build_board(pre_board);
        size = pre_board.size();
        towersOnBoard = new ArrayList<com.mygdx.game.models.towers.Tower>();
        mobsOnBoard = new LinkedList<com.mygdx.game.models.mobs.Mob>();
    }

    public Board() {
        pre_board = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(2, 0, 1, 1, 1, 1, 0, 0)),
                new ArrayList<Integer>(Arrays.asList(1, 0, 1, 0, 0, 1, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0, 1, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0, 1, 0, 0)),
                new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0, 1, 0, 3)),
                new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 0, 1, 0, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1)))
        );
        tile_board = build_board(pre_board);
        size = pre_board.size();
        towersOnBoard = new ArrayList<com.mygdx.game.models.towers.Tower>();
        mobsOnBoard = new LinkedList<com.mygdx.game.models.mobs.Mob>();
    }

    public int calculate_path(int x, int y) {
        Queue<Integer> queue_x = new LinkedList<Integer>();
        Queue<Integer> queue_y = new LinkedList<Integer>();
        Queue<Integer> queue_cost = new LinkedList<Integer>();
        ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < pre_board.size(); i++){
            s.add(new ArrayList<Integer>());
            for(int j = 0; j < pre_board.get(i).size(); j++) {
                s.get(i).add(0);
            }
        }
        int current_x;
        int current_y;
        int current_cost;
        s.get(x).set(y, 1);
        queue_x.add(x);
        queue_y.add(y);
        queue_cost.add(0);

        int[] adjacentX = {0, 1, 0, -1};
        int[] adjacentY = {-1, 0, 1, 0};

        while(!queue_x.isEmpty()) {
            current_x = queue_x.remove();
            current_y = queue_y.remove();
            current_cost = queue_cost.remove();
            if(pre_board.get(current_x).get(current_y) == 3) {
                return current_cost;
            } else if(pre_board.get(current_x).get(current_y) > 0) {
                for (int i = 0; i < adjacentX.length; i++) {
                    try {
                        if (s.get(current_x + adjacentX[i]).get(current_y + adjacentY[i]) != 1 && pre_board.get(current_x + adjacentX[i]).get(current_y + adjacentY[i]) > 0) {
                            s.get(current_x + adjacentX[i]).set(current_y + adjacentY[i], 1);
                            queue_x.add(current_x + adjacentX[i]);
                            queue_y.add(current_y + adjacentY[i]);
                            queue_cost.add(current_cost + 1);
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
        }
        throw new java.lang.Error("Could not find a path...");
    }

    public ArrayList<ArrayList<Tile>> build_board(ArrayList<ArrayList<Integer>> pre_board) {
        tile_board = new ArrayList<ArrayList<Tile>>();
        for(int i = 0; i < pre_board.size(); i++) {
            tile_board.add(new ArrayList<Tile>());
            for(int j = 0; j < pre_board.get(i).size(); j++) {
                if(pre_board.get(i).get(j) > 0) {
                    tile_board.get(i).add(new Tile(i, j, pre_board.get(i).get(j), calculate_path(i, j)));
                } else {
                    tile_board.get(i).add(new Tile(i, j, pre_board.get(i).get(j), Integer.MAX_VALUE));
                }
            }
        }
        return tile_board;
    }

    public void addMobToQueue(com.mygdx.game.models.mobs.Mob mob) {
        mobsOnBoard.add(mob);
    }

    public com.mygdx.game.models.mobs.Mob nextMob() {
        return mobsOnBoard.remove();
    }

    public ArrayList<ArrayList<Tile>> getTile_board() {
        return tile_board;
    }

    public ArrayList<ArrayList<Integer>> getPre_board() {
        return pre_board;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<com.mygdx.game.models.towers.Tower> getTowersOnBoard() {
        return towersOnBoard;
    }

    public Queue<com.mygdx.game.models.mobs.Mob> getMobsOnBoard() {
        return mobsOnBoard;
    }

    public int getAttackerMoney() {
        return attackerMoney;
    }

    public void setAttackerMoney(int attackerMoney) {
        this.attackerMoney = attackerMoney;
    }

    public int getDefenderMoney() {
        return defenderMoney;
    }

    public void setDefenderMoney(int defenderMoney) {
        this.defenderMoney = defenderMoney;
    }

    public double getTowerHealth() {
        return towerHealth;
    }

    public void setTowerHealth(double towerHealth) {
        this.towerHealth = towerHealth;
    }

    public boolean tileHasNoTowerAndIsPlacableTile(float x,float y) {
        //Todo: sjekk om det går å plassere tårn i cellen.
        return false;
    }

    public void placeTower(float x, float y, Tower tower) {
        //Todo: plasser tårn i riktig tile
    }
}
