package com.mygdx.game.models.mobs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.models.Tile;

public abstract class Mob extends Actor {
    protected double maxHealth;
    protected double currentHealth;
    protected double speed;
    protected Sprite sprite;
    protected SpriteBatch spriteBatch;
    protected Integer price;
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

    public Integer getPrice() {
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

    public double getXPos() {
        return x;
    }

    public double getYPos(){ return y;}

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        if (getTile() != tile) {
            this.tile.removeMobFromTile(this);
            this.tile = tile;
        }
    }

    public void update() {
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //todo:
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        //todo:
    }
}