package com.mygdx.game.testing;

import com.mygdx.game.models.Board;
import com.mygdx.game.models.mobs.Mob;
import com.mygdx.game.models.mobs.TestMob;
import com.mygdx.game.models.towers.StandardTower;
import com.mygdx.game.models.towers.Tower;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class TowerTests {
    @Test
    public void testShootableTilesInRange() {
        ArrayList<ArrayList<Integer>> range = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)),
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

        Tower tower = new StandardTower();

        assertThat(tower.getShootable_tiles(), hasItems(
                board.getTile_board().get(0).get(3),
                board.getTile_board().get(1).get(2),
                board.getTile_board().get(1).get(4)));
    }

    @Test
    public void testShootableMobsOnTilesInRange() {
        ArrayList<ArrayList<Integer>> range = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(1, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 0, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 1, 1))
        ));

        Board board = new Board(
                new ArrayList<ArrayList<Integer>>(Arrays.asList(
                        new ArrayList<Integer>(Arrays.asList(2, 0, 1, 1, 1, 1, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(1, 0, 1, 0, 0, 1, 1, 1)),
                        new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1)),
                        new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0, 1, 1, 1)),
                        new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0, 1, 0, 0)),
                        new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0, 1, 0, 3)),
                        new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 0, 1, 0, 1)),
                        new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1)))
                )
        );

        Tower tower = new StandardTower();
        Mob mobOne = new TestMob();
        Mob mobTwo = new TestMob();
        Mob mobThree = new TestMob();
        Mob mobFour = new TestMob();
        Mob mobFive = new TestMob();

        board.getTile_board().get(0).get(2).addMobToTile(mobOne);
        board.getTile_board().get(2).get(3).addMobToTile(mobTwo);
        board.getTile_board().get(2).get(3).addMobToTile(mobThree);
        board.getTile_board().get(3).get(3).addMobToTile(mobFour);
        board.getTile_board().get(3).get(5).addMobToTile(mobFive);

        assertThat(tower.getShootableMobs(), hasItems(mobTwo, mobThree, mobFour, mobFive));
    }
}
