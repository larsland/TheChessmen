package tdt4240.chess.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Views.GameRenderer;

public class GameScreen implements Screen {

    private GameRenderer renderer;

    @Override
    public void show() {
        Board board;
        board = new Board();
        this.renderer = new GameRenderer(board);
        this.renderer.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
       this.renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        this.renderer.setSize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        this.renderer.dispose();
    }

    @Override
    public void dispose() {

    }
}
