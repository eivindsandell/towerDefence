package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public abstract class Tower {
    private double damage;
    private double speed;
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private int price;
    private List<Tile> road;
    private Tile position;
    private List<List<Integer>> range;
    private List<Tile> shootable_tiles;

    public Tower(double damage, double speed, List<List<Integer>> range, Sprite sprite, SpriteBatch spriteBatch, int price) {
        this.damage = damage;
        this.speed = speed;
        this.range = range;
        this.sprite = sprite;
        this.spriteBatch = spriteBatch;
        this.price = price;

    }

    public double getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }

    public List<List<Integer>> getRange() {
        return range;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public int getPrice() {
        return price;
    }

    public void calculate_shootable_tiles(){
    }
}
