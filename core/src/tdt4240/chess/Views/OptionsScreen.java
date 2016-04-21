package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
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
import tdt4240.chess.Utility.Options;

public class OptionsScreen implements Screen {

    private Main game;
    private final Stage stage = new Stage(new FitViewport(8, 12));
    VerticalGroup btnGroupSound, btnGroupModes, btnGroupBack;
    TextButton muteSfx, muteMusic, backBtn, mode0Btn, mode1Btn, mode2Btn;
    Texture backgroundImage;
    Sprite sprite;

    public OptionsScreen(Main game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("optionsScreen.png"));
        sprite = new Sprite(backgroundImage);
        sprite.setSize(1.0f, 1.0f * sprite.getHeight() / sprite.getWidth());
    }

    @Override
    public void show() {
        SoundAssets.stopAllMusic();
        SoundAssets.playMenuMusic();
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(this.stage);
        createOptions();
    }

    public void createOptions() {
        btnGroupSound = new VerticalGroup();
        btnGroupModes = new VerticalGroup();
        btnGroupBack = new VerticalGroup();
        muteSfx = new TextButton("Mute SFX", GraphicsAssets.btnStyle);
        muteMusic = new TextButton("Mute Music", GraphicsAssets.btnStyle);
        backBtn = new TextButton("Back", GraphicsAssets.btnStyle);
        mode0Btn = new TextButton("Regular Chess", GraphicsAssets.btnStyle);
        mode1Btn = new TextButton("Pawn Frenzy", GraphicsAssets.btnStyle);
        mode2Btn = new TextButton("420 No Scopes", GraphicsAssets.btnStyle);

        muteSfx.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Options.SFX_ENABLED = !Options.SFX_ENABLED;
                game.setScreen(new OptionsScreen(game));
            }
        });
        muteMusic.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Options.MUSIC_ENABLED = !Options.MUSIC_ENABLED;
                game.setScreen(new OptionsScreen(game));
            }
        });
        backBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenu(game));
            }
        });
        mode0Btn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y ) {
                Options.GAME_MODE = 0;
            }
        });
        mode1Btn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y ) {
                Options.GAME_MODE = 1;
            }
        });
        mode2Btn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Options.GAME_MODE = 2;
            }
        });



        btnGroupSound.addActor(muteSfx);
        btnGroupSound.addActor(muteMusic);
        btnGroupModes.addActor(mode0Btn);
        btnGroupModes.addActor(mode1Btn);
        btnGroupModes.addActor(mode2Btn);
        btnGroupBack.addActor(backBtn);


        btnGroupSound.space(5);
        btnGroupSound.setTransform(true);
        btnGroupSound.setScale(1 / muteSfx.getHeight());
        btnGroupSound.setPosition(4, 9);
        btnGroupModes.space(5);
        btnGroupModes.setTransform(true);
        btnGroupModes.setScale(1 / muteSfx.getHeight());
        btnGroupModes.setPosition(4, 6);
        btnGroupBack.setTransform(true);
        btnGroupBack.setScale(1 / muteSfx.getHeight());
        btnGroupBack.setPosition(4, 2);

        stage.addActor(btnGroupSound);
        stage.addActor(btnGroupModes);
        stage.addActor(btnGroupBack);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.3f, .3f, .4f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();
        if (Options.MUSIC_ENABLED) {
            muteMusic.setText("Mute Music");
        }
        else if (!Options.MUSIC_ENABLED) {
            muteMusic.setText("Unmute Music");
        }
        if (Options.SFX_ENABLED) {
            muteSfx.setText("Mute SFX");
        }
        else if (!Options.SFX_ENABLED) {
            muteSfx.setText("Unmute SFX");
        }
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
