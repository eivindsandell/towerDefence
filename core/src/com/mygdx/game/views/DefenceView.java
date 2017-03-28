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

public class DefenceView implements Screen{
    private DefenceViewController defenceViewController;
    private TowerDefence game;
    private Stage stage;

    public DefenceView(TowerDefence game) {
        this.game = game;
        stage = new Stage();
        defenceViewController = new DefenceViewController(this);
        goNext();
        prevMenu();
        nextMenu();
        chooseTower();
        defenceViewController.fillTable();
    }

    private void goNext(){
        defenceViewController.getDoneButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed!");
                dispose();
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


    @Override
    public void show() {
        stage.addActor(defenceViewController.getDoneButton());
        stage.addActor(defenceViewController.getLeftButton());
        stage.addActor(defenceViewController.getRightButton());
        stage.addActor(defenceViewController.getTable());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        defenceViewController.drawBackground();
        defenceViewController.drawSquareAroundChosenTableCell(defenceViewController.getChosenCell());
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