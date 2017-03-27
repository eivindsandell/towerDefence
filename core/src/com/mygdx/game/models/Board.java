package com.mygdx.game.models;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Board {

    private ArrayList<ArrayList<Tile>> tile_board;
    private ArrayList<ArrayList<Integer>> pre_board; //0: Ground, 1: Road, 2: Start, 3: Goal
    private int size;

    public Board(ArrayList<ArrayList<Integer>> pre_board) {
        this.pre_board = pre_board;
        tile_board = build_board(pre_board);
        size = pre_board.size();
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

    public ArrayList<ArrayList<Tile>> getTile_board() {
        return tile_board;
    }

    public ArrayList<ArrayList<Integer>> getPre_board() {
        return pre_board;
    }

    public int getSize() {
        return size;
    }
}
