package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.TowerDefence;
import com.mygdx.game.controllers.AttackViewController;

import java.util.ArrayList;

public class AttackView implements Screen{
    private AttackViewController attackViewController;
    private TowerDefence game;
    private Stage stage;

    public AttackView(TowerDefence game) {
        this.game = game;
        stage = new Stage();
        attackViewController = new AttackViewController(this);
        goNext();
        prevMenu();
        nextMenu();
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
                attackViewController.attackLeftMenu();
                attackViewController.left();
            }
        });
    }

    public void nextMenu(){
        attackViewController.getRightButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                attackViewController.attackRightMenu();
                attackViewController.right();
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
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        attackViewController.drawBackground();
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

    }

    @Override
    public void dispose() {
        stage.clear();
    }
}