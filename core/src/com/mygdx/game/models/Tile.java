package com.mygdx.game.models;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.models.mobs.Mob;

import java.util.ArrayList;

public class Tile extends Actor {

    private int x,y;
    private int type;
    private int tiles_to_portal;
    private ArrayList<Mob> mobsOnTile;

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
        mobsOnTile = new ArrayList<Mob>();
    }

    public int getType() {
        return type;
    }

    public int getXpos() {
        return x;
    }

    public int getYpos() {
        return y;
    }

    public int getTiles_to_portal() {
        return tiles_to_portal;
    }

    public ArrayList<Mob> getMobsOnTile() {
        return mobsOnTile;
    }

    public void addMobToTile(Mob mob) {
        mobsOnTile.add(mob);
    }

    public void removeMobFromTile(Mob mob) {
        mobsOnTile.remove(mobsOnTile.indexOf(mob));
    }

}

