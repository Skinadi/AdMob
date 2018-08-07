package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.concurrent.TimeUnit;

public class MenuScreen implements Screen {


    final SpaceShooter game;

    Texture img;

    Table table;
    Stage stage;
    MenuButton startButton;
    MenuButton exitButton;
    MenuButton settingsButton;
    GameButton gameButton;
    public MenuScreen(final SpaceShooter game) {
        this.game = game;
        //System.out.println(Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight());

        img = new Texture("badlogic.jpg");

        stage = new Stage();
        stage.setViewport(new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),stage.getCamera()));
        stage.getViewport().update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        table = new Table();
        table.setFillParent(true);
        //table.setDebug(true);
        //Skin skin = new Skin();
        //skin.add("red_button",new Texture("red_button.png"));

        startButton = new MenuButton("Start");
        exitButton = new MenuButton("Exit");
        settingsButton = new MenuButton("Settings");
        startButton.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Start");
                stage.clear();
                stage.dispose();
                game.setScreen(new GameScreen(game));
            }

        });
        exitButton.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Exit");
                Gdx.app.exit();

            }

        });
        settingsButton.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Settings");
            }

        });
        table.add(startButton.getButton()).height(100).spaceBottom(30).spaceTop(50);
        table.row();
        table.add(settingsButton.getButton()).height(100).spaceBottom(30);
        table.row();
        table.add(exitButton.getButton()).height(100);
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        stage.getCamera().update();
        /*if(Gdx.input.isTouched())
        {
            stage.getCamera().position.set(new Vector3(stage.getCamera().position.x,stage.getCamera().position.y,
                    stage.getCamera().position.z));
        }*/
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
        img.dispose();
        stage.dispose();
    }
}
