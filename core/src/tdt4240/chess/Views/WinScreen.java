package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Main;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Utility.ChessmanColor;

public class WinScreen implements Screen {

    private final Stage stage = new Stage(new FitViewport(8, 10));
    private Main game;
    private ChessmanColor color;
    Label winnerLabel;
    VerticalGroup btnGroup;
    TextButton menuBtn, replayBtn;

    public WinScreen(Main game, ChessmanColor color) {
        this.game = game;
        this.color = color;
    }

    public void createScreen() {
        btnGroup = new VerticalGroup();
        winnerLabel = new Label(color.name() + " is victorious!", GraphicsAssets.secondaryLabelStyle);

        menuBtn = new TextButton("Main Menu", GraphicsAssets.btnStyle);
        replayBtn = new TextButton("Play Again", GraphicsAssets.btnStyle);

        menuBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenu(game));
            }
        });
        replayBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Board.getInstance().reset();
                game.setScreen(new GameScreen(game, "new"));
            }
        });

        btnGroup.addActor(winnerLabel);
        btnGroup.addActor(replayBtn);
        btnGroup.addActor(menuBtn);
        btnGroup.setTransform(true);
        btnGroup.setScale(1 / menuBtn.getHeight());
        btnGroup.setPosition(4, 7);
        btnGroup.space(5);
        this.stage.addActor(btnGroup);
    }

    @Override
    public void show() {
        SoundAssets.stopAllMusic();
        SoundAssets.playVictorySound();
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(this.stage);
        createScreen();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.3f, .3f, .4f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        this.stage.draw();
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
        this.stage.dispose();
    }

    public void setSize(int width, int height) {
        this.stage.getViewport().update(width, height, false);
        Gdx.graphics.requestRendering();
    }
}
