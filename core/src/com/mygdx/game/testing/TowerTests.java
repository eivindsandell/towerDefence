package com.mygdx.game.testing;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.StandardTower;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.Tower;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TowerTests {
    @Test
    public void simpleTest() {
        ArrayList<ArrayList<Integer>> range = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)))
        );

        Board board = new Board(
                new ArrayList<ArrayList<Integer>>(Arrays.asList(
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 2, 1, 0, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 0, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 3, 0, 0, 0)))
                )
        );

        Tower tower = new StandardTower(1.0, 1.0, range, new Sprite(), new SpriteBatch(), 1, new Tile(3, 3, 0, 10));
        ArrayList<Tile> tiles = tower.getShootable_tiles();
        int posX = tower.getPosition().getX();
        int posY = tower.getPosition().getY();
        assertEquals(tower.getPosition(), board.getTile_board().get(posX).get(posY));
    }
}
