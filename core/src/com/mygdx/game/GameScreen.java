package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameScreen implements Screen {

    SpaceShooter game;
    Stage stage;
    Table table;
    GameButton gameButton;
    MenuButton backButton;
    Label counter;
    public GameScreen(final SpaceShooter game)
    {
        this.game=game;
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);

        stage.setViewport(new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),stage.getCamera()));
        stage.getViewport().update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        gameButton = new GameButton("Press");
        backButton = new MenuButton("Back");
        Label.LabelStyle style= new Label.LabelStyle();
        BitmapFont font= new BitmapFont();
        font.getData().setScale(4);
        style.font=font;
        counter = new Label("0",style);

        gameButton.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int foo = Integer.parseInt(counter.getText().toString());
                foo++;
                counter.setText(Integer.toString(foo));
            }
        });
        backButton.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                stage.clear();
                stage.dispose();
                game.setScreen(new MenuScreen(game));
            }
        });
        table.add(counter).spaceBottom(30).spaceTop(30);
        table.row();
        table.add(gameButton.getButton()).spaceTop(30).spaceBottom(30);
        table.row();
        table.add(backButton.getButton()).spaceTop(30).spaceBottom(30);

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
            game.setScreen(new MenuScreen(game));
            stage.clear();
            stage.dispose();
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

    }
}
