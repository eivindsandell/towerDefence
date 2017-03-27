package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestMob extends Mob {

    public TestMob() {
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