package com.mygdx.game.models.towers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;

import java.util.ArrayList;
import java.util.Arrays;


public class StandardTower extends Tower {

    public StandardTower(Board board, Tile position) {
        super(
                100,
                100,
                new ArrayList<ArrayList<Integer>>(Arrays.asList(
                        new ArrayList<Integer>(Arrays.asList(0, 1, 0)),
                        new ArrayList<Integer>(Arrays.asList(1, 0, 1)),
                        new ArrayList<Integer>(Arrays.asList(0, 1, 0)))),
                new Sprite(new Texture(Gdx.files.internal("towerDefense_tile249.png"))),
                100,
                position,
                board,
                0);
    }

    public StandardTower(ArrayList<ArrayList<Integer>> range, Tile position, Board board, int type) {
        super(range, position, board, type);
    }
}
