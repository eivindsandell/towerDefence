package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;



public class StandardTower extends Tower {


    public StandardTower(double damage, double speed, ArrayList<ArrayList<Integer>> range, Sprite sprite, SpriteBatch spriteBatch, int price, Tile position) {
        super(damage, speed, range, sprite, spriteBatch, price, position);

    }


    public StandardTower(ArrayList<ArrayList<Integer>> range, Sprite towerSprite, SpriteBatch towerSpriteBatch, Tile position) {
        super(1, 1, range, towerSprite, towerSpriteBatch, 100, position);


    }
}
