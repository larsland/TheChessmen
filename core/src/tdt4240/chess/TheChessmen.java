package tdt4240.chess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Views.MainMenu;

public class TheChessmen extends Game {
	public SpriteBatch batch;
	public static final int UWIDTH = 8;

	@Override
	public void create () {
		batch = new SpriteBatch();
		SoundAssets.loadSounds();
		GraphicsAssets.loadFonts();
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
