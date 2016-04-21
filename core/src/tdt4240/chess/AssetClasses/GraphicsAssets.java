package tdt4240.chess.AssetClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GraphicsAssets {

    // Defining fonts
    public static BitmapFont gameFont = new BitmapFont();
    public static BitmapFont btnFont = new BitmapFont();

    // Defining the main button skin
    private static TextureAtlas checkBtnAtlas = new TextureAtlas(Gdx.files.internal("graphic/checkButton.pack"));
    private static Skin checkButtonSkin = new Skin(checkBtnAtlas);
    public static TextButton.TextButtonStyle btnStyle = new TextButton.TextButtonStyle(
            checkButtonSkin.getDrawable("btnUp"), checkButtonSkin.getDrawable("btnDown"), checkButtonSkin.getDrawable("btnUp"), btnFont
    );

    // Defining label styles
    public static Label.LabelStyle mainLabelStyle = new Label.LabelStyle(gameFont, Color.BLACK);
    public static Label.LabelStyle secondaryLabelStyle = new Label.LabelStyle(gameFont, Color.ORANGE);

    // Loading the texture region containing all chessmen images
    public static TextureRegion[] chessmenCollection = loadChessmenImages();
    public static TextureRegion sniper = new TextureRegion(new Texture(Gdx.files.internal("graphic/sniper.png")));

    // All tile images
    public static Texture whiteTile = new Texture(Gdx.files.internal("graphic/whiteTile.png"));
    public static Texture blackTile = new Texture(Gdx.files.internal("graphic/blackTile.png"));
    public static Texture attackTile = new Texture(Gdx.files.internal("graphic/attackHighlight.png"));
    public static Texture highlightTile = new Texture(Gdx.files.internal("graphic/moveHighlight.png"));

    // All backgrounds
    public static Texture optionsBackground = new Texture(Gdx.files.internal("graphic/optionsScreen.png"));
    public static Texture mainMenuBackground = new Texture(Gdx.files.internal("graphic/menuScreen.png"));

    // Function to scale the fonts before they are loaded
    public static void loadFonts() {
        gameFont.getData().setScale((float) 1.7, (float) 1.7);
        btnFont.getData().setScale((float) 1.3, (float) 1.3);
    }

    private static TextureRegion[] loadChessmenImages() {
        int FRAME_COLS = 6;
        int FRAME_ROWS = 2;

        Texture chessMenImage = new Texture(Gdx.files.internal("graphic/pieces.png"));
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
