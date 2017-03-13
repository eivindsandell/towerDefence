package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Mob {
    private double health;
    private double speed;
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private int price;
    private int damage;
    private double x,y;


    public Mob(double health, double speed, Sprite sprite, SpriteBatch spriteBatch, int price, int damage) {
        this.health = health;
        this.speed = speed;
        this.sprite = sprite;
        this.spriteBatch = spriteBatch;
        this.price = price;
        this.damage = damage;
    }

    public double getHealth() {
        return health;
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
