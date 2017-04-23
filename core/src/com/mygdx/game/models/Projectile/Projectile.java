package com.mygdx.game.models.Projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Globals;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.mobs.Mob;
import com.mygdx.game.models.towers.Tower;


public class Projectile extends Actor {
    private Mob mob;
    private int startX;
    private int startY;
    private int speed;
    Texture projectileTexture;
    private int destX;
    private int destY;
    private double xSpeed;
    private double ySpeed;
    private Globals globals;
    private double t;
    private double deltaT;
    private int damage;


    public Projectile (Mob mob, int type, int startX, int startY){
        switch (type){
            case Tower.NORMAL:
                projectileTexture = new Texture(Gdx.files.internal("missile_small.png"));
                speed = 10;
                damage = 10;
        }
        this.mob = mob;
        this.destX = mob.getTile().getXpos();
        this.destY = mob.getTile().getYpos();
        this.startX = startX;
        this.startY = startY;
        globals = new Globals();
        deltaT = 0;
        findSpeeds();
        this.setX(startY*globals.getSize());
        this.setY(globals.getScreenHeight()-startX*globals.getSize()-globals.getSize());
        System.out.println("projectile fired");
    }

    private void findSpeeds(){
        int Lx = destX-startX;
        int Ly = destY - startY;
        double L =  Math.sqrt((Lx*Lx)+(Ly*Ly));
        t = L/speed;
        xSpeed = (Lx)/t;
        ySpeed = (Ly)/t;
    }

    private void travel(){
        this.setX((float) (this.getX()+ xSpeed*globals.getSize()));
        this.setY((float) (this.getY()+ ySpeed*globals.getSize()));
    }

    public void hasHit(){
        deltaT += (t/60);
        if(deltaT >= t){
            mob.dealDamage(damage);
            deltaT =-999999;
            this.remove();
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        travel();
        hasHit();
        //todo:
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(projectileTexture, getX(), getY(), globals.getSize(), globals.getSize());
    }

}
