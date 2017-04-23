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
import com.mygdx.game.controllers.AttackViewController;
import com.mygdx.game.models.towers.Tower;

import java.util.ArrayList;

public class AttackView implements Screen{
    private AttackViewController attackViewController;
    private TowerDefence game;
    private Stage stage;
    private ArrayList<Tower> towers;

    public AttackView(TowerDefence game) {
        this.game = game;
        stage = new Stage();
        attackViewController = new AttackViewController();
        goNext();
        prevMenu();
        nextMenu();
        chooseMob();
        add();
        subtract();
        buy();
        attackViewController.fillTable();
    }

    //metoder for å sette opp listeners
    private void goNext(){
        attackViewController.getDoneButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                dispose();
                game.setScreen(game.getBetweenRoundView());
            }
        });

    }
    public void prevMenu(){
        attackViewController.getLeftButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                attackViewController.left();
            }
        });
    }
    public void nextMenu(){
        attackViewController.getRightButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                attackViewController.right();
            }
        });
    }
    public void chooseMob(){
        attackViewController.getTable().addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("I got clicked!");
                attackViewController.findPressedCell(x,y);
            }
        });
    }
    public void add(){
        attackViewController.getAdd().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                attackViewController.add();
            }
        });
    }
    public void subtract(){
        attackViewController.getSubtract().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                attackViewController.subtract();
            }
        });
    }
    public void buy(){
        attackViewController.getPurchase().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                attackViewController.buy();
            }
        });
    }

    @Override
    public void show() {
        stage.addActor(attackViewController.getDoneButton());
        stage.addActor(attackViewController.getLeftButton());
        stage.addActor(attackViewController.getRightButton());
        stage.addActor(attackViewController.getTable());
        stage.addActor(attackViewController.getBoard());
        stage.addActor(attackViewController.getPopup());
        stage.addActor(attackViewController.getMoneyTable());
        towers = attackViewController.getPlacedTowers();
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
        attackViewController.drawBackground();
        attackViewController.drawSquareAroundChosenTableCell();
        attackViewController.updateMoneyTable(attackViewController.getMoney());
        attackViewController.updatePopupTable();
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