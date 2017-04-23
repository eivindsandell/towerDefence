package com.mygdx.game.models.towers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;

import java.util.ArrayList;
import java.util.Arrays;


public class StandardTower extends Tower {

    public StandardTower() {
        super();
        damage = 100;
        speed = 100;
        range = new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 1, 0)),
                new ArrayList<Integer>(Arrays.asList(1, 0, 1)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 0))));
        sprite = new Sprite(new Texture(Gdx.files.internal("canon_green.png")));
        price = 100;
        type = Tower.NORMAL;
        fireRate = 30;
    }
}
