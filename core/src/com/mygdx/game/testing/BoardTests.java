package com.mygdx.game.testing;

import com.mygdx.game.models.Board;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BoardTests {
    @Test
    public void simpleTest() {
        Board board = new Board(
                new ArrayList<ArrayList<Integer>>(Arrays.asList(
                    new ArrayList<Integer>(Arrays.asList(2, 1, 1, 1, 1, 1, 1, 3)))
                )
        );
        assertEquals(7, board.getTile_board().get(0).get(0).getTiles_to_portal());
    }

    @Test
    public void advancedTest() {
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
        assertEquals(2, board.getTile_board().get(7).get(2).getTiles_to_portal());
    }
}
