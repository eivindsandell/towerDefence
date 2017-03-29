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

public class AttackView implements Screen{
    private AttackViewController attackViewController;
    private TowerDefence game;
    private Stage stage;

    public AttackView(TowerDefence game) {
        this.game = game;
        stage = new Stage();
        attackViewController = new AttackViewController();
        goNext();
        prevMenu();
        nextMenu();
        chooseMob();
        attackViewController.fillTable();
    }

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

    @Override
    public void show() {
        stage.addActor(attackViewController.getDoneButton());
        stage.addActor(attackViewController.getLeftButton());
        stage.addActor(attackViewController.getRightButton());
        stage.addActor(attackViewController.getTable());
        stage.addActor(attackViewController.getBoard());
        stage.addActor(attackViewController.getPopup());
        stage.addActor(attackViewController.getMoneyTable());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        attackViewController.drawBackground();
        attackViewController.drawSquareAroundChosenTableCell();
        attackViewController.updateMoneyTable();
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