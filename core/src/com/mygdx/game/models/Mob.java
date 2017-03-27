package com.mygdx.game.models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Mob {
    private double maxHealth;
    private double currentHealth;
    private double speed;
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private int price;
    private int damage;
    private double x,y;
    private Game game;


    public Mob(Game game) {
        this.game = game;
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
}
