package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import javafx.scene.Scene;
import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Main;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.Options;

public class GameScreen implements Screen {

    private final Stage stage = new Stage(new FitViewport(8, 10));
    Table ui;
    TextButton resetGameBtn, menuBtn;
    Main game;
    Label turnLabel;
    String turn;
    HorizontalGroup btnGroup;
    VerticalGroup hudGroup;
    String newOrContinue;

    public GameScreen(Main game, String newOrContinue) {
        this.game = game;
        this.newOrContinue = newOrContinue;
    }

    public void createUi() {
        ui = new Table();
        btnGroup = new HorizontalGroup();
        btnGroup.space(5);
        hudGroup = new VerticalGroup();
        hudGroup.space(15);
        turnLabel = new Label(turn, GraphicsAssets.secondaryLabelStyle);
        resetGameBtn = new TextButton("Reset Game", GraphicsAssets.btnStyle);
        menuBtn = new TextButton("Main Menu", GraphicsAssets.btnStyle);
        menuBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenu(game));
            }
        });
        resetGameBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Board.getInstance().reset();
                game.setScreen(new GameScreen(game, "new"));
            }
        });

        btnGroup.addActor(resetGameBtn);
        btnGroup.addActor(menuBtn);

        hudGroup.addActor(turnLabel);
        hudGroup.addActor(btnGroup);

        ui.add(hudGroup);
        ui.setTransform(true);
        ui.setScale(1 /this.resetGameBtn.getHeight());
        ui.setPosition(4, 1);
        this.stage.addActor(ui);
    }

    @Override
    public void show() {
        if (this.newOrContinue.equals("new")) {
            Board.getInstance().reset();
        }
        SoundAssets.stopAllMusic();
        SoundAssets.playBackgroundMusic();
        Board.getInstance().setPosition(0, 2);
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(this.stage);
        this.stage.addActor(Board.getInstance());
        createUi();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(.3f, .3f, .4f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        this.turnLabel.setText(Board.getInstance().getTurn().name() + "'s Turn");
        this.stage.draw();

        if (Board.getInstance().getWin() == ChessmanColor.BLACK || Board.getInstance().getWin() == ChessmanColor.WHITE) {
            game.setScreen(new WinScreen(this.game, Board.getInstance().getWin()));
        }
    }

    @Override
    public void resize(int width, int height) {
        setSize(width, height);
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

    public void setSize(int width, int height) {
        this.stage.getViewport().update(width, height, false);
        Gdx.graphics.requestRendering();
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

}
