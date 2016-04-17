package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import tdt4240.chess.Main;
import tdt4240.chess.Models.ChessmanColor;

public class WinScreen implements Screen {

    private final Stage stage = new Stage(new FitViewport(8, 10));
    private Main game;
    private ChessmanColor color;
    String winner;
    Label winnerLabel;
    Label.LabelStyle labelStyle;
    VerticalGroup btnGroup;
    TextButton menuBtn, replayBtn;
    TextButton.TextButtonStyle btnStyle;
    Skin skin;
    TextureAtlas btnAtlas;
    BitmapFont font;

    public WinScreen(Main game, ChessmanColor color) {
        this.game = game;
        this.color = color;
        this.winner = "none";
    }

    public void createScreen() {
        font = new BitmapFont();
        btnGroup = new VerticalGroup();
        skin = new Skin();
        btnAtlas = new TextureAtlas(Gdx.files.internal("button.pack"));
        skin.addRegions(btnAtlas);
        btnStyle = new TextButton.TextButtonStyle();
        btnStyle.up = skin.getDrawable("btnUp");
        btnStyle.down = skin.getDrawable("btnDown");
        btnStyle.font = Main.font;

        labelStyle = new Label.LabelStyle(Main.font, Color.ORANGE);
        winnerLabel = new Label(winner, labelStyle);

        menuBtn = new TextButton("Main Menu", btnStyle);
        replayBtn = new TextButton("Play Again", btnStyle);

        menuBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenu(game));
            }
        });
        replayBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        btnGroup.addActor(winnerLabel);
        btnGroup.addActor(replayBtn);
        btnGroup.addActor(menuBtn);
        btnGroup.setTransform(true);
        btnGroup.setScale(1 / menuBtn.getHeight());
        btnGroup.setPosition(4, 7);

        this.stage.addActor(btnGroup);
    }

    @Override
    public void show() {
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
