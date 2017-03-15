package com.mygdx.game;


public class Board {

    private Tile[][] tile_board;
    private int[][] pre_board; //0: Ground, 1: Road, 2: Start, 3: Goal
    private int board_size;

    public Board(int board_size, int[][] pre_board) {
        this.pre_board = pre_board;
        this.board_size = board_size;
        tile_board = build_board(pre_board, board_size);
    }

    private int calculate_path(int x, int y) {
        int[][] s;
        int[][] q;
        s = new int[board_size][board_size];
        q = new int[board_size][board_size];
        s[x][y] = 1;
        return 0;
    }

    private Tile[][] build_board(int[][] pre_board, int board_size) {
        for(int i = 0; i <= board_size; i++) {
            for(int j = 0; j <= board_size; j++) {
                tile_board[i][j] = new Tile(i, j, calculate_path(i, j));
            }
        }
        return tile_board;
    }

}
