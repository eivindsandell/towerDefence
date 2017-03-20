package com.mygdx.game;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Board {

    private ArrayList<ArrayList<Tile>> tile_board;
    private ArrayList<ArrayList<Integer>> pre_board; //0: Ground, 1: Road, 2: Start, 3: Goal
    private int board_size;

    public Board(int board_size, ArrayList<ArrayList<Integer>> pre_board) {
        this.pre_board = pre_board;
        this.board_size = board_size;
        tile_board = build_board(pre_board, board_size);
    }

    private int calculate_path(int x, int y) {
        Queue<Integer> queue_x = new LinkedList<Integer>();
        Queue<Integer> queue_y = new LinkedList<Integer>();
        Queue<Integer> queue_cost = new LinkedList<Integer>();
        ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>();

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

            if(pre_board.get(x).get(y) == 3) {
                return current_cost;
            }
            try {
                for(int i = 0; i <= adjacentX.length; i++) {
                    if(s.get(current_x + adjacentX[i]).get(current_y + adjacentY[i]) != 1) {
                        s.get(current_x + adjacentX[i]).set(current_y + adjacentY[i], 1);
                        queue_x.add(current_x + adjacentX[i]);
                        queue_y.add(current_y + adjacentY[i]);
                        queue_cost.add(current_cost + 1);
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e) {
            }
        }
        throw new java.lang.Error("Could not find a path...");
    }

    private ArrayList<ArrayList<Tile>> build_board(ArrayList<ArrayList<Integer>> pre_board, int board_size) {
        for(int i = 0; i <= board_size; i++) {
            for(int j = 0; j <= board_size; j++) {
                if(pre_board.get(i).get(j) == 1) {
                    tile_board.get(i).set(j, new Tile(i, j, pre_board.get(i).get(j), calculate_path(i, j)));
                }
            }
        }
        return tile_board;
    }

}
