package com.mygdx.game.models.mobs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
    protected Texture texture;
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
            if (board.getTile_board().get(x - 1).get(y).getType() == Board.ROAD || board.getTile_board().get(x-1).get(y).getType() == Board.GOAL) {
                roadTiles.add(board.getTile_board().get(x - 1).get(y));
            }
        }
        catch (IndexOutOfBoundsException e){

        }
        try {
            if (board.getTile_board().get(x+1).get(y).getType() == Board.ROAD || board.getTile_board().get(x+1).get(y).getType() == Board.GOAL){
                roadTiles.add(board.getTile_board().get(x+1).get(y));
            }
        }
        catch (IndexOutOfBoundsException e){

        }
        try {
            if (board.getTile_board().get(x).get(y-1).getType() == Board.ROAD || board.getTile_board().get(x).get(y-1).getType() == Board.GOAL){
                roadTiles.add(board.getTile_board().get(x).get(y-1));
            }
        }
        catch (IndexOutOfBoundsException e){

        }
        try {
            if (board.getTile_board().get(x).get(y+1).getType() == Board.ROAD || board.getTile_board().get(x).get(y+1).getType() == Board.GOAL){
                roadTiles.add(board.getTile_board().get(x).get(y+1));
            }
        }
        catch (IndexOutOfBoundsException e){

        }


        for (int i = 0; i<roadTiles.size; i++){
            if (roadTiles.get(i).getTiles_to_portal()<nextMin){
                nextMin = roadTiles.get(i).getTiles_to_portal();
                nextX = roadTiles.get(i).getXpos();
                nextY = roadTiles.get(i).getYpos();
            }
        }
        System.out.print("row :");
        System.out.println(nextX);
        System.out.print("col :");
        System.out.println(nextY);
        nextTile = board.getTile_board().get(nextX).get(nextY);
    }

    public void updatePos() {
        if (distanceWalked == 0){
            findNextTile(tile.getXpos(), tile.getYpos());
            if (nextTile.getXpos() < tile.getXpos()){
                speedX = 0;
                speedY = 1;
            }
            else if (nextTile.getXpos() > tile.getXpos()){
                speedX = 0;
                speedY = -1;
            }
            else if (nextTile.getYpos() < tile.getYpos()){
                speedX = -1;
                speedY = 0;
            }
            else if (nextTile.getYpos() > tile.getYpos()){
                speedX = 1;
                speedY = 0;
            }
        }
        distanceWalked += speed;
        setX((float) (this.getX() + speed*(globals.getScreenWidth()/globals.getGridSize())*speedX));
        setY((float) (this.getY() + speed*(globals.getScreenWidth()/globals.getGridSize())*speedY));
        if (distanceWalked >= 1){
            distanceWalked = 0;
            tile.removeMobFromTile(this);
            nextTile.addMobToTile(this);
            tile = nextTile;
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
        batch.draw(texture,getX(),getY(),globals.getSize(), globals.getSize());

    }

    public void setStartPos() {

        this.setX(tile.getXpos()*globals.getSize());
        this.setY(globals.getScreenHeight()-tile.getYpos()*globals.getSize()+globals.getSize());
    }

    public void dealDamage(int damage) {
        currentHealth -= damage;
        System.out.println(currentHealth);
        if(currentHealth<= 0){
            tile.removeMobFromTile(this);
            this.remove();
            board.updateKilledMobsThisRound();
        }
    }
}