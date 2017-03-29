package com.mygdx.game.models;

import java.util.ArrayList;

public class Tile {

    private int x,y;
    private int type;
    private int tiles_to_portal;
    private ArrayList<com.mygdx.game.models.mobs.Mob> mobsOnTile;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Tile(int x, int y, int type, int tiles_to_portal) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.tiles_to_portal = tiles_to_portal;
        mobsOnTile = new ArrayList<com.mygdx.game.models.mobs.Mob>();
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTiles_to_portal() {
        return tiles_to_portal;
    }

    public ArrayList<com.mygdx.game.models.mobs.Mob> getMobsOnTile() {
        return mobsOnTile;
    }

    public void addMobToTile(com.mygdx.game.models.mobs.Mob mob) {
        mobsOnTile.add(mob);
    }
}

