package com.mygdx.game.models.Projectile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Projectile extends Actor {
    Sprite projectileSprite;

    public Projectile (Sprite projectileSprite){
        this.projectileSprite = projectileSprite;
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

    public float getXPos(){
        return projectileSprite.getX();
    }

    public float getYPos(){
        return projectileSprite.getY();
    }

}
