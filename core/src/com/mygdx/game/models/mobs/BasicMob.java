package com.mygdx.game.models.mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasicMob extends Mob {

    public BasicMob() {
        maxHealth = 100;
        currentHealth = maxHealth;
        speed = 0.01;
        Texture texture = new Texture(Gdx.files.internal("towerDefense_tile245.png"));
        Sprite sprite = new Sprite(texture);
        SpriteBatch spriteBatch;
        price = 10;
        damage = 1;
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