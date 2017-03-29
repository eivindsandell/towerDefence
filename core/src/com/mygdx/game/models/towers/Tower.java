package com.mygdx.game.models.towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.mobs.Mob;

import java.util.ArrayList;

public abstract class Tower {
    private double damage;
    private double speed;
    private Sprite sprite;
    private int price;
    private Tile position;
    private ArrayList<ArrayList<Integer>> range;
    private ArrayList<Tile> shootable_tiles;
    private Board board;
    private ArrayList<Mob> shootableMobs;
    public static int NORMAL = 0;
    public static int SPLASH = 1;
    public static int LAZER = 2;
    private int type = 0;


    public Tower(double damage, double speed, ArrayList<ArrayList<Integer>> range, Sprite sprite, int price, Tile position, Board board, int type) {
        this.damage = damage;
        this.speed = speed;
        this.position = position;
        this.range = range;
        this.sprite = sprite;
        this.price = price;
        this.shootable_tiles = new ArrayList<Tile>();
        calculate_shootable_tiles(board);
        this.type = type;
    }

    public Tower(ArrayList<ArrayList<Integer>> range, Tile position, Board board, int type) {
        this.range = range;
        this.position = position;
        this.board = board;
        this.shootable_tiles = new ArrayList<Tile>();
        calculate_shootable_tiles(board);
        this.type = type;
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