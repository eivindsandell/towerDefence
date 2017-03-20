package com.mygdx.game;


import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        Queue<Integer> queueX = new LinkedList<Integer>();
        Queue<Integer> queueY = new LinkedList<Integer>();
        ArrayList<ArrayList<Integer>> cost = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();

        int currentX;
        int currentY;
        int cost_count = 0;
        path.get(x).set(y, 1);
        cost.get(x).set(y, cost_count);

        while(!queueX.isEmpty()) {
            currentX = queueX.remove();
            currentY = queueY.remove();
            if(pre_board.get(x).get(y) == 3) {
                
            }
        }

        return 0;
    }

    private ArrayList<ArrayList<Tile>> build_board(ArrayList<ArrayList<Integer>> pre_board, int board_size) {
        for(int i = 0; i <= board_size; i++) {
            for(int j = 0; j <= board_size; j++) {
                if(pre_board.get(i).get(j) == 1) {
                    tile_board.get(i).set(j, new Tile(i, j, calculate_path(i, j)));
                }
            }
        }
        return tile_board;
    }

}
