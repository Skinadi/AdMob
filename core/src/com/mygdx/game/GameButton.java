package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameButton
{
    private TextButton button;
    GameButton(String title)
    {
        TextureRegion region = new TextureRegion(new Texture("red_button.png"));
        TextureRegion region1 = new TextureRegion(new Texture("green_button.png"));
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(region);
        style.down = new TextureRegionDrawable(region1);
        BitmapFont font = new BitmapFont();
        font.getData().setScale(4);
        style.font = font;
        button = new TextButton(title,style);
    }
    TextButton getButton()
    {
        return button;
    }
}
