package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import tdt4240.chess.Main;
import tdt4240.chess.Models.Board;


public class GameScreen implements Screen {

    private final Stage stage = new Stage(new FitViewport(8, 10));
    Table ui;
    BitmapFont font;
    Skin skin;
    TextureAtlas btnAtlas;
    TextButton.TextButtonStyle btnStyle;
    TextButton btn;
    TextButton menuBtn;
    Main game;

    public GameScreen(Main game) {
        this.game = game;
    }

    public void createUi() {
        ui = new Table();
        skin = new Skin();
        font = new BitmapFont();
        btnAtlas = new TextureAtlas(Gdx.files.internal("button.pack"));
        skin.addRegions(btnAtlas);
        btnStyle = new TextButton.TextButtonStyle();
        btnStyle.up = skin.getDrawable("btnUp");
        btnStyle.down = skin.getDrawable("btnDown");
        btnStyle.font = font;
        btn = new TextButton("Reset Game", btnStyle);
        menuBtn = new TextButton("Main Menu", btnStyle);
        menuBtn.addListener(new ClickListener() {
           public void clicked(InputEvent event, float x, float y) {
               game.setScreen(new MainMenu(game));
           }
        });
        btn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });
        ui.add(btn);
        ui.add(menuBtn);
        ui.setTransform(true);
        ui.setScale(1 /this.btn.getHeight());
        ui.setPosition(4, 9);
        this.stage.addActor(ui);
    }

    @Override
    public void show() {
        Board board;
        board = new Board();
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(this.stage);
        this.stage.addActor(board);
        createUi();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(.3f, .3f, .4f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        this.stage.draw();
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

    }
}
