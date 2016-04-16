package tdt4240.chess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Views.MainMenu;

public class Main extends Game {
	public SpriteBatch batch;
	public static BitmapFont font;
	public static final int UWIDTH = 8;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		SoundAssets.loadSounds();
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
