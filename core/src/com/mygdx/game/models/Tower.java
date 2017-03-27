package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public abstract class Tower {
    private double damage;
    private double speed;
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private int price;
    private ArrayList<Tile> road;
    private Tile position;
    private ArrayList<ArrayList<Integer>> range;
    private ArrayList<Tile> shootable_tiles;

    public Tower(double damage, double speed, ArrayList<ArrayList<Integer>> range, Sprite sprite, SpriteBatch spriteBatch, int price, Tile position) {
        this.damage = damage;
        this.speed = speed;
        this.position = position;
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

    public ArrayList<ArrayList<Integer>> getRange() {
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

    public ArrayList<Tile> getShootable_tiles() {
        return shootable_tiles;
    }

    public Tile getPosition() {
        return position;
    }

    public void calculate_shootable_tiles(Board board) {
        int towerX = position.getX();
        int towerY = position.getY();
        int rangeWidth = (range.size() - 1) / 2;
        for (int i = 0; i > range.size(); i++) {
            for (int j = 0; j > range.get(i).size(); j++) {
                if (range.get(i).get(j) == 1) {
                    try {
                        if (board.getTile_board().get(towerX + i - rangeWidth).get(towerY + j - rangeWidth).getType() > 0) {
                            shootable_tiles.add(board.getTile_board().get(towerX + i).get(towerY + j));
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
        }
    }
}
