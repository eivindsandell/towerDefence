package com.mygdx.game;

import java.util.HashMap;
import java.util.Map;


public class Tile {

    private int x,y;
    private int type; //0: Ground, 1: Road, 2: Start, 3: Goal
    private int tiles_to_portal;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Tile(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
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
}

