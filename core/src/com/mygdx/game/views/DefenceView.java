package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.TowerDefence;
import com.mygdx.game.controllers.DefenceViewController;
import com.mygdx.game.models.Tile;
import com.mygdx.game.models.towers.Tower;

import java.util.ArrayList;

public class DefenceView implements Screen{
    private DefenceViewController defenceViewController;
    private TowerDefence game;
    private Stage stage;
    private ArrayList<Tower> towers;

    public DefenceView(TowerDefence game) {
        this.game = game;
        stage = new Stage();
        defenceViewController = new DefenceViewController();
        goNext();
        prevMenu();
        nextMenu();
        chooseTower();
        chooseGridCell();
        defenceViewController.fillTable();
    }

    private void goNext(){
        defenceViewController.getDoneButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                game.setScreen(game.getPlayRoundView());
            }
        });

    }

    public void prevMenu(){
        defenceViewController.getLeftButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                defenceViewController.left();
            }
        });
    }

    public void nextMenu(){
        defenceViewController.getRightButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                defenceViewController.right();
            }
        });
    }

    public void chooseTower(){
        defenceViewController.getTable().addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("I got clicked!");
                defenceViewController.findPressedCell(x,y);
            }
        });
    }

    public void chooseGridCell(){
        defenceViewController.getBoard().addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("I got clicked!");
                defenceViewController.findSelectedGridSquare(x,y);
                towers = defenceViewController.getPlacedTowers();
                if(towers != null){
                    for(Tower tower:towers){
                        if(tower != null){
                            stage.addActor(tower);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void show() {
        stage.addActor(defenceViewController.getDoneButton());
        stage.addActor(defenceViewController.getLeftButton());
        stage.addActor(defenceViewController.getRightButton());
        stage.addActor(defenceViewController.getTable());
        stage.addActor(defenceViewController.getBoard());
        stage.addActor(defenceViewController.getMoneyTable());
        towers = defenceViewController.getPlacedTowers();
        if(towers != null){
            for(Tower tower:towers){
                if(tower != null){
                    stage.addActor(tower);
                }
            }
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        defenceViewController.drawBackground();
        defenceViewController.drawSquareAroundChosenTableCell();
        defenceViewController.fillSelectedGridSquare();
        defenceViewController.updateMoneyTable(defenceViewController.getMoney());
        defenceViewController.getPlacedTowers();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.clear();
    }

    @Override
    public void dispose() {
        stage.clear();
    }
}