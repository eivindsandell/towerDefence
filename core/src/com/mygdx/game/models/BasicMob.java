package com.mygdx.game.models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasicMob extends Mob {

    private double maxHealth = 100;
    private double currentHealth = maxHealth;
    private double speed = 0.01;
    private Sprite sprite = new Sprite(new Texture(Gdx.files.internal("basicMob.png")));
    private SpriteBatch spriteBatch;
    private int price = 10;
    private int damage = 1;

    public BasicMob(Game game) {
        super(game);
    }

    public void setMaxHealth(double health) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(double health) {
        this.currentHealth = currentHealth;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public double getMaxHealth() {
        return maxHealth;
    }

    @Override
    public double getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}