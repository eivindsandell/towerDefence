package com.mygdx.game.models.towers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Globals;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.Projectile.Projectile;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.mobs.Mob;

import java.util.ArrayList;

public abstract class Tower extends Actor {
    protected double damage;
    protected double speed;
    protected Sprite sprite;
    protected int price;
    protected Tile position;
    protected ArrayList<ArrayList<Integer>> range;
    protected ArrayList<Tile> shootable_tiles;
    protected Board board;
    protected Texture texture;
    protected ArrayList<Mob> shootableMobs;
    protected ArrayList<Projectile> projectiles;
    public static final int NORMAL = 0;
    public static final int SPLASH = 1;
    public static final int LAZER = 2;
    protected int type = 0;
    protected int timeSinceLastShot;
    protected int fireRate;
    protected Globals globals;

    public Tower() {
        board = Board.getInstance();
        shootable_tiles = new ArrayList<Tile>();
        shootableMobs = new ArrayList<Mob>();
        timeSinceLastShot = 0;
        globals = new Globals();
    }

    public double getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }

    public ArrayList<ArrayList<Integer>> getRange() {
        return range;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Tile> getShootable_tiles() {
        return shootable_tiles;
    }

    public Tile getPosition() {
        return position;
    }

    public Board getBoard() {
        return board;
    }

    public void calculate_shootable_tiles(Board board) {
        int towerX = position.getXpos();
        int towerY = position.getYpos();
        int rangeWidth = (range.size() - 1) / 2;
        for (int i = 0; i < range.size(); i++) {
            for (int j = 0; j < range.get(i).size(); j++) {
                if (range.get(i).get(j) == 1) {
                    try {
                        if (board.getTile_board().get(towerX + i - rangeWidth).get(towerY + j - rangeWidth).getType() > 0) {
                            shootable_tiles.add(board.getTile_board().get(towerX + i - rangeWidth).get(towerY + j - rangeWidth));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }
    }

    public ArrayList<Mob> getShootableMobs() {
        for (int i = 0; i < shootable_tiles.size(); i++) {
            for (int j = 0; j < shootable_tiles.get(i).getMobsOnTile().size(); j++) {
                shootableMobs.add(shootable_tiles.get(i).getMobsOnTile().get(j));
            }
        }
        return shootableMobs;
    }

    public void fire(Mob mob) {
        if (type == NORMAL) {
            fireProjectile(mob);
        }
    }

    private void fireProjectile(Mob mob) {

        projectiles.add(new Projectile(mob,type,position.getXpos(),position.getYpos()));

    }

    private void fireSplash() {

    }

    private void fireLazer(){

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        timeSinceLastShot ++;
        if(shootableMobs.size()>0 && timeTooShoot()){
            fire(shootableMobs.get(0));
        }
        for(Projectile p:projectiles){
            p.act(delta);
            if(p.hasHit()){
                projectiles.remove(p);
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture,getX(),getY(), globals.getSize(), globals.getSize());
    }

    private boolean timeTooShoot() {
        if(timeSinceLastShot >= fireRate){
            timeSinceLastShot =0;
            return true;
        }
        return false;
    }

    public void setTile(Tile tile) {
        position = tile;
        calculate_shootable_tiles(board);
    }
}
