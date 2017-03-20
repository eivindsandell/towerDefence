package com.mygdx.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Globals;

public class DefenceView implements Screen {
    Game game;
    Globals g = new Globals();
    ShapeRenderer sr = new ShapeRenderer();
    Table table;
    DragAndDrop dad;
    Stage stage;
    Skin skin;

    public DefenceView(Game game){
        this.game = game;
        skin = new Skin();
        table = new Table(skin);
        table.defaults();
        dad = new DragAndDrop();
        table.setTouchable(Touchable.enabled);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin.add("default", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        skin.add("badlogic", new Texture(Gdx.files.internal("badlogic.jpg")));

        table.setPosition((int)(g.getScreenWith()*0.1),(int)((g.getScreenHeight()-g.getScreenWith())*0.25));
        table.setHeight((int)((g.getScreenHeight()-g.getScreenWith())*0.75));
        table.setWidth((int)(g.getScreenWith()*0.8));
        table.setColor(1,0,0,1);
        table.add("hei");
        table.add("hei2");
        table.add("hei3").row();
        table.add("hei4");
        table.add("hei5");
        table.add("hei6");
        table.setBackground("badlogic");

        dad = new DragAndDrop();
        dad.addSource(new DragAndDrop.Source(table) {
            public DragAndDrop.Payload dragStart (InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();
                payload.setObject("Some payload!");

                payload.setDragActor(new Label("Some payload!", skin));

                Label validLabel = new Label("Some payload!", skin);
                validLabel.setColor(0, 1, 0, 1);
                payload.setValidDragActor(validLabel);

                Label invalidLabel = new Label("Some payload!", skin);
                invalidLabel.setColor(1, 0, 0, 1);
                payload.setInvalidDragActor(invalidLabel);

                return payload;
            }
        });
        dad.addTarget(new DragAndDrop.Target(table) {
            public boolean drag (DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                getActor().setColor(Color.GREEN);
                return true;
            }

            public void reset (DragAndDrop.Source source, DragAndDrop.Payload payload) {
                getActor().setColor(Color.WHITE);
            }

            public void drop (DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                System.out.println("Accepted: " + payload.getObject() + " " + x + ", " + y);
            }
        });

    }

    @Override
    public void show() {
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(201/255f, 163/255f, 14/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        displayUnitMenu();
        stage.act(Gdx.graphics.getDeltaTime());
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
        stage.dispose();
    }
    private void displayUnitMenu(){
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0,0,0,1);
        sr.rect(0,0,g.getScreenWith(),g.getScreenHeight()-g.getScreenWith());
        sr.end();
    }
    /*
    public class DragAndDropTest extends GdxTest {
        Stage stage;

        public void create () {
            stage = new Stage();
            Gdx.input.setInputProcessor(stage);

            final Skin skin = new Skin();
            skin.add("default", new LabelStyle(new BitmapFont(), Color.WHITE));
            skin.add("badlogic", new Texture("data/badlogic.jpg"));

            Image sourceImage = new Image(skin, "badlogic");
            sourceImage.setBounds(50, 125, 100, 100);
            stage.addActor(sourceImage);

            Image validTargetImage = new Image(skin, "badlogic");
            validTargetImage.setBounds(200, 50, 100, 100);
            stage.addActor(validTargetImage);

            Image invalidTargetImage = new Image(skin, "badlogic");
            invalidTargetImage.setBounds(200, 200, 100, 100);
            stage.addActor(invalidTargetImage);

            DragAndDrop dragAndDrop = new DragAndDrop();
            dragAndDrop.addSource(new Source(sourceImage) {
                public Payload dragStart (InputEvent event, float x, float y, int pointer) {
                    Payload payload = new Payload();
                    payload.setObject("Some payload!");

                    payload.setDragActor(new Label("Some payload!", skin));

                    Label validLabel = new Label("Some payload!", skin);
                    validLabel.setColor(0, 1, 0, 1);
                    payload.setValidDragActor(validLabel);

                    Label invalidLabel = new Label("Some payload!", skin);
                    invalidLabel.setColor(1, 0, 0, 1);
                    payload.setInvalidDragActor(invalidLabel);

                    return payload;
                }
            });
            dragAndDrop.addTarget(new Target(validTargetImage) {
                public boolean drag (Source source, Payload payload, float x, float y, int pointer) {
                    getActor().setColor(Color.GREEN);
                    return true;
                }

                public void reset (Source source, Payload payload) {
                    getActor().setColor(Color.WHITE);
                }

                public void drop (Source source, Payload payload, float x, float y, int pointer) {
                    System.out.println("Accepted: " + payload.getObject() + " " + x + ", " + y);
                }
            });
            dragAndDrop.addTarget(new Target(invalidTargetImage) {
                public boolean drag (Source source, Payload payload, float x, float y, int pointer) {
                    getActor().setColor(Color.RED);
                    return false;
                }

                public void reset (Source source, Payload payload) {
                    getActor().setColor(Color.WHITE);
                }

                public void drop (Source source, Payload payload, float x, float y, int pointer) {
                }
            });
        }

        public void render () {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
        }

        public void resize (int width, int height) {
            stage.getViewport().update(width, height, true);
        }

        public void dispose () {
            stage.dispose();
        }
    }*/
}

