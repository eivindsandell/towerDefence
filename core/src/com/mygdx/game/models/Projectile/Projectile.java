package com.mygdx.game.models.Projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.models.towers.Tower;


public class Projectile extends Actor {
    Sprite projectileSprite;
    private float destX;
    private float destY;

    public Projectile (int type,float destX, float destY){
        switch (type){
            case Tower.NORMAL:
                projectileSprite = new Sprite(new Texture(Gdx.files.internal("missile_small")));
        }
        this.destX = destX;
        this.destY = destY;
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
