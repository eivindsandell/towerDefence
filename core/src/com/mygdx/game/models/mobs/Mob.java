package com.mygdx.game.models.mobs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.models.Tile;

public abstract class Mob {
    protected double maxHealth;
    protected double currentHealth;
    protected double speed;
    protected Sprite sprite;
    protected SpriteBatch spriteBatch;
    protected int price;
    protected int damage;
    protected double x, y;
    protected Game game;
    protected Tile tile;

    public Mob() {
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public double getSpeed() {
        return speed;
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

    public int getDamage() {
        return damage;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        if (getTile() != tile) {
            this.tile = tile;
        }
    }
}