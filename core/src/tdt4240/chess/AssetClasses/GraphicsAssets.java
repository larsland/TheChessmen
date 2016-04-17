package tdt4240.chess.AssetClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import tdt4240.chess.Main;

public class GraphicsAssets {

    // Defining fonts
    public static BitmapFont gameFont = new BitmapFont();
    public static BitmapFont btnFont = new BitmapFont();

    // Defining the main button skin
    private static TextureAtlas btnAtlas = new TextureAtlas(Gdx.files.internal("button.pack"));
    private static Skin buttonSkin = new Skin(btnAtlas);
    public static TextButton.TextButtonStyle btnStyle = new TextButton.TextButtonStyle(
        buttonSkin.getDrawable("btnUp"), buttonSkin.getDrawable("btnDown"), buttonSkin.getDrawable("btnDown"), btnFont
    );

    // Defining label styles
    public static Label.LabelStyle mainLabelStyle = new Label.LabelStyle(gameFont, Color.BLACK);
    public static Label.LabelStyle secondaryLabelStyle = new Label.LabelStyle(gameFont, Color.ORANGE);

    // Loading the texture region containing all chessmen images
    public static TextureRegion[] chessmenCollection = loadChessmenImages();




    public static void loadFonts() {
        gameFont.getData().setScale((float) 1.7, (float) 1.7);
        btnFont.getData().setScale((float) 1.3, (float) 1.3);
    }

    private static TextureRegion[] loadChessmenImages() {
        int FRAME_COLS = 6;
        int FRAME_ROWS = 2;

        Texture chessMenImage = new Texture(Gdx.files.internal("pieces.png"));
        TextureRegion[] list = new TextureRegion[FRAME_COLS * FRAME_ROWS];

        TextureRegion[][] tmp = TextureRegion.split(chessMenImage, chessMenImage.getWidth()/FRAME_COLS, chessMenImage.getHeight()/FRAME_ROWS);
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                list[index++] = tmp[i][j];
            }
        }
        return list;
    }






}
