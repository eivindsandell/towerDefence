package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;



public class StandardTower extends Tower {


    public StandardTower(double damage, double speed, List<List<Integer>> range, Sprite sprite, SpriteBatch spriteBatch, int price) {
        super(damage, speed, range, sprite, spriteBatch, price);

    }


    public StandardTower(List range, Sprite towerSprite, SpriteBatch towerSpriteBatch){
        super(1, 1, range, towerSprite, towerSpriteBatch, 100);


    }




}
