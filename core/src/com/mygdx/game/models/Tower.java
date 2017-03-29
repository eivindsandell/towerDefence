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
    private Board board;
    private ArrayList<Mob> shootableMobs;
    public static int NORMAL = 0;
    public static int SPLASH = 1;
    public static int LAZER = 2;
    private int type = 0;



    public Tower(double damage, double speed, ArrayList<ArrayList<Integer>> range, Sprite sprite, SpriteBatch spriteBatch, int price, Tile position, Board board) {
        this.damage = damage;
        this.speed = speed;
        this.position = position;
        this.range = range;
        this.sprite = sprite;
        this.spriteBatch = spriteBatch;
        this.price = price;
        this.shootable_tiles = new ArrayList<Tile>();
        calculate_shootable_tiles(board);
    }

    public Tower(ArrayList<ArrayList<Integer>> range, Tile position, Board board) {
        this.range = range;
        this.position = position;
        this.board = board;
        this.shootable_tiles = new ArrayList<Tile>();
        calculate_shootable_tiles(board);
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

    public Board getBoard() {
        return board;
    }

    public void calculate_shootable_tiles(Board board) {
        int towerX = position.getX();
        int towerY = position.getY();
        int rangeWidth = (range.size() - 1) / 2;
        for (int i = 0; i < range.size(); i++) {
            for (int j = 0; j < range.get(i).size(); j++) {
                if (range.get(i).get(j) == 1) {
                    try {
                        if (board.getTile_board().get(towerX + i - rangeWidth).get(towerY + j - rangeWidth).getType() > 0) {
                            shootable_tiles.add(board.getTile_board().get(towerX + i - rangeWidth).get(towerY + j - rangeWidth));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }
    }

    public ArrayList<Mob> getShootableMobs() {
        shootableMobs = new ArrayList<Mob>();
        for (int i = 0; i < shootable_tiles.size(); i++) {
            for (int j = 0; j < shootable_tiles.get(i).getMobsOnTile().size(); j++) {
                shootableMobs.add(shootable_tiles.get(i).getMobsOnTile().get(j));
            }
        }
        return shootableMobs;
    }

    public void Fire(){

    }

    private void fireProjectile(){

    }

    private void fireLazer(){

    }

    private void fireSplash(){

    }
}
