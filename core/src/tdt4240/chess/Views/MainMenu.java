package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

public class MainMenu implements Screen {

    Main game;
    private final Stage stage = new Stage(new FitViewport(8, 10));
    Table menu;
    TextButton startBtn;
    BitmapFont font;
    Skin skin;
    TextureAtlas btnAtlas;
    TextButton.TextButtonStyle btnStyle;

    public MainMenu(Main game) {
        this.game = game;
    }

    public void createMenu() {
        menu = new Table();
        skin = new Skin();
        font = new BitmapFont();
        btnAtlas = new TextureAtlas(Gdx.files.internal("button.pack"));
        skin.addRegions(btnAtlas);
        btnStyle = new TextButton.TextButtonStyle();
        btnStyle.up = skin.getDrawable("btnUp");
        btnStyle.up = skin.getDrawable("btnDown");
        btnStyle.font = font;
        startBtn = new TextButton("Start Game", btnStyle);
        startBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });
        menu.add(startBtn);
        menu.setTransform(true);
        menu.setScale(1 / startBtn.getHeight());
        menu.setPosition(4, 9);
        stage.addActor(menu);





    }


    @Override
    public void show() {
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(this.stage);
        createMenu();
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    public void setSize(int width, int height) {
        this.stage.getViewport().update(width, height, false);
        Gdx.graphics.requestRendering();
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
}
