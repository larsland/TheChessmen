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
import tdt4240.chess.Controllers.TheChessmen;

public class HelpScreen implements Screen{
    TheChessmen game;
    TextButton backBtn;
    VerticalGroup btnContainer;
    VerticalGroup textContainer;
    Label helpText;
    private final Stage stage = new Stage(new FitViewport(8, 10));

    public HelpScreen(TheChessmen game) {
        this.game = game;
    }

    public void addButton() {
        helpText = new Label("Welcome to TheChessmen! " + '\n' + '\n' +
                "Select a prefered game mode in the" + '\n' +
                "Options menu. Here you can also mute" + '\n' +
                "music and sfx. CLick 'new game' to" + '\n' +
                "start a new game with the selected" + '\n' +
                "rules or click 'continue' to contiune" + '\n' +
                "where you left off." +'\n' + '\n' +
                "Move by clicking a chessman, and then on" + '\n' +
                "one of the tiles highlighted in blue to move" + '\n' +
                "or red to attack." + '\n' + '\n' +
                "Some of the game modes will change" + '\n' +
                "the way the pieces are allowed to move" + '\n' +
                "or how the game behaves."

        ,GraphicsAssets.mainLabelStyle);
        helpText.setWrap(true);
        helpText.setWidth(8);
        backBtn = new TextButton("Back", GraphicsAssets.btnStyle);
        backBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                SoundAssets.playAttackChessmanSound();
                game.setScreen(new MainMenu(game));
            }
        });
        textContainer = new VerticalGroup();
        btnContainer = new VerticalGroup();

        textContainer.addActor(helpText);
        textContainer.setPosition(1, 9);
        textContainer.setTransform(true);
        textContainer.setScale(1 / backBtn.getHeight());

        btnContainer.setScale(1 / backBtn.getHeight());
        btnContainer.setTransform(true);
        btnContainer.setPosition(4, 1);
        btnContainer.addActor(backBtn);

        stage.addActor(textContainer);
        stage.addActor(btnContainer);
    }

    @Override
    public void show() {
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(this.stage);
        addButton();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.3f, .3f, .4f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        this.stage.draw();
    }
    public void setSize(int width, int height) {
        this.stage.getViewport().update(width, height, false);
        Gdx.graphics.requestRendering();
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

    }
}
