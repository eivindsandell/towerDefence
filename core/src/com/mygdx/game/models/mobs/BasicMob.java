package com.mygdx.game.models.mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasicMob extends Mob {

    public BasicMob() {
        maxHealth = 100;
        currentHealth = maxHealth;
        speed = 0.5;
        texture = new Texture(Gdx.files.internal("sombrero.png"));
        price = 10;
        damage = 1;
    }
}