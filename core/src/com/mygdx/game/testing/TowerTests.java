package com.mygdx.game.testing;

import com.mygdx.game.models.Board;
import com.mygdx.game.models.StandardTower;
import com.mygdx.game.models.Tower;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class TowerTests {
    @Test
    public void simple() {
        ArrayList<ArrayList<Integer>> range = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)))
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

        Tower tower = new StandardTower(range, board.getTile_board().get(1).get(3), board);
        int posX = tower.getPosition().getX();
        int posY = tower.getPosition().getY();
        assertThat(tower.getShootable_tiles(), hasItems(
                board.getTile_board().get(0).get(2),
                board.getTile_board().get(0).get(3),
                board.getTile_board().get(3).get(4),
                board.getTile_board().get(3).get(2),
                board.getTile_board().get(2).get(2)));
    }
}
