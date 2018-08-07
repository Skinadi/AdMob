package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceShooter extends Game {

	AdHandler handler;
	boolean toogle;

    SpriteBatch batch;

	public SpaceShooter(AdHandler handler)
    {
        this.handler=handler;
    }
	@Override
	public void create () {
        batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));
	}

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
	public void render () {
	    super.render();
	    /*if(Gdx.input.justTouched())
        {
            handler.showAds(toogle);
            toogle=!toogle;
        }*/

	}

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
	public void dispose () {
    batch.dispose();
	}
}
