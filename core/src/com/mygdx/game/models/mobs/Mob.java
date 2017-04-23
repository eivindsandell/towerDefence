package com.mygdx.game.models.mobs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Globals;
import com.mygdx.game.models.Board;
import com.mygdx.game.models.Tile;

public abstract class Mob extends Actor {
    protected double maxHealth;
    protected double currentHealth;
    protected double speed;
    protected Sprite sprite;
    protected Integer price;
    protected int damage;
    protected Game game;
    protected Tile tile;
    protected Board board;
    protected Tile nextTile;
    protected float distanceWalked;
    protected int speedX;
    protected int speedY;
    protected Globals globals;


    public Mob() {
        distanceWalked = 0;
        board = Board.getInstance();
        globals = new Globals();
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


    public Integer getPrice() {
        return price;
    }

    public int getDamage() {
        return damage;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    private void findNextTile(int x, int y){
        int nextX = 0;
        int nextY = 0;
        int nextMin = board.getTile_board().get(x).get(y).getTiles_to_portal();
        Array<Tile> roadTiles = new Array<Tile>();
        try {
            if (board.getTile_board().get(x - 1).get(y).getType() == 1) {
                roadTiles.add(board.getTile_board().get(x - 1).get(y));
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
        try {
            if (board.getTile_board().get(x+1).get(y).getType() == 1){
                roadTiles.add(board.getTile_board().get(x+1).get(y));
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
        try {
            if (board.getTile_board().get(x).get(y-1).getType() == 1){
                roadTiles.add(board.getTile_board().get(x).get(y-1));
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
        try {
            if (board.getTile_board().get(x).get(y+1).getType() == 1){
                roadTiles.add(board.getTile_board().get(x).get(y+1));
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }


        for (int i = 0; i<roadTiles.size; i++){
            if (tile.getTiles_to_portal()<nextMin){
                nextMin = tile.getTiles_to_portal();
                nextX = tile.getXpos();
                nextY = tile.getYpos();
            }
        }
        System.out.println(nextX);
        System.out.println(nextY);
        nextTile = board.getTile_board().get(nextX).get(nextY);
    }

    public void updatePos() {
        if (distanceWalked == 0){
            findNextTile(tile.getXpos(), tile.getYpos());
            if (nextTile.getXpos() < tile.getXpos()){
                speedX = -1;
                speedY = 0;
            }
            else if (nextTile.getXpos() > tile.getXpos()){
                speedX = 1;
                speedY = 0;
            }
            else if (nextTile.getYpos() < tile.getYpos()){
                speedX = 0;
                speedY = 1;
            }
            else if (nextTile.getYpos() > tile.getYpos()){
                speedX = 0;
                speedY = -1;
            }
        }
        distanceWalked += speed;
        setX((float) (this.getX() + speed*(globals.getScreenWidth()/globals.getGridSize())*speedX));
        setY((float) (this.getY() + speed*(globals.getScreenWidth()/globals.getGridSize())*speedY));
        if (distanceWalked == 1){
            distanceWalked = 0;
            tile.removeMobFromTile(this);
            nextTile.addMobToTile(this);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        updatePos();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        //todo:

    }

    public void setStartPos() {
        float cellsize = globals.getScreenWidth()/globals.getGridSize();
        this.setX(tile.getXpos()*cellsize + cellsize/2);
        this.setY(tile.getYpos()*cellsize + cellsize/2);
    }
}