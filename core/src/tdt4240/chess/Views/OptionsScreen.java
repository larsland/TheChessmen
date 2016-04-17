package tdt4240.chess.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Main;
import tdt4240.chess.Models.Options;

public class OptionsScreen implements Screen {

    private Main game;
    private final Stage stage = new Stage(new FitViewport(8, 12));
    VerticalGroup btnGroup;
    TextButton muteSfx;
    TextButton muteMusic;
    TextButton backBtn;

    public OptionsScreen(Main game) {
        this.game = game;
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
        btnGroup = new VerticalGroup();
        muteSfx = new TextButton("Mute SFX", GraphicsAssets.btnStyle);
        muteMusic = new TextButton("Mute Music", GraphicsAssets.btnStyle);
        backBtn = new TextButton("Back", GraphicsAssets.btnStyle);

        muteSfx.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (Options.SFX_ENABLED) {
                    Options.SFX_ENABLED = false;
                }
                else if(!Options.SFX_ENABLED) {
                    Options.SFX_ENABLED = true;
                }
            }
        });
        muteMusic.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (Options.MUSIC_ENABLED) {
                    Options.MUSIC_ENABLED = false;
                }
                else if(!Options.MUSIC_ENABLED) {
                    Options.MUSIC_ENABLED = true;
                }
            }
        });
        backBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenu(game));
            }
        });


        btnGroup.addActor(muteSfx);
        btnGroup.addActor(muteMusic);
        btnGroup.addActor(backBtn);
        btnGroup.space(5);
        btnGroup.setTransform(true);
        btnGroup.setScale(1 / muteSfx.getHeight());
        btnGroup.setPosition(4, 7);
        stage.addActor(btnGroup);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.3f, .3f, .4f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
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
