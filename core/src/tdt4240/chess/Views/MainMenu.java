package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Main;

public class MainMenu implements Screen {

    Main game;
    private final Stage stage = new Stage(new FitViewport(8, 12));

    VerticalGroup menu;
    TextButton startBtn, optionsBtn, continueBtn;
    Texture backgroundImage;
    Sprite sprite;

    public MainMenu(Main game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("menuScreen.png"));
        sprite = new Sprite(backgroundImage);
        sprite.setSize(1.0f, 1.0f* sprite.getHeight() / sprite.getWidth());
    }

    public void createMenu() {
        menu = new VerticalGroup();
        startBtn = new TextButton("New Game", GraphicsAssets.btnStyle);
        startBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                SoundAssets.playAttackChessmanSound();
                game.setScreen(new GameScreen(game, "new"));
            }
        });
        optionsBtn = new TextButton("Options", GraphicsAssets.btnStyle);
        optionsBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                SoundAssets.playAttackChessmanSound();
                game.setScreen(new OptionsScreen(game));
            }
        });
        continueBtn = new TextButton("Continue", GraphicsAssets.btnStyle);
        continueBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                SoundAssets.playAttackChessmanSound();
                game.setScreen(new GameScreen(game, "continue"));
            }
        });
        menu.addActor(startBtn);
        menu.addActor(continueBtn);
        menu.addActor(optionsBtn);
        menu.setTransform(true);
        menu.setScale(1 / startBtn.getHeight());
        menu.setPosition(4, 7);
        menu.space(10);
        stage.addActor(menu);
    }


    @Override
    public void show() {
        SoundAssets.stopAllMusic();
        SoundAssets.playMenuMusic();
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(this.stage);
        createMenu();
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();
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
