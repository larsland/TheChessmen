package tdt4240.chess.AssetClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import tdt4240.chess.Main;

public class GraphicsAssets {

    private static TextureAtlas btnAtlas = new TextureAtlas(Gdx.files.internal("button.pack"));
    private static Skin skin = new Skin(btnAtlas);

    public static TextButton.TextButtonStyle btnStyle = new TextButton.TextButtonStyle(
        skin.getDrawable("btnUp"), skin.getDrawable("btnDown"), skin.getDrawable("btnDown"), Main.font
    );



    public static TextureRegion[] loadChessmenImages() {
        int FRAME_COLS = 6;
        int FRAME_ROWS = 2;

        Texture chessMenImage = new Texture(Gdx.files.internal("pieces.png"));
        TextureRegion[] chessMenCollection = new TextureRegion[FRAME_COLS * FRAME_ROWS];

        TextureRegion[][] tmp = TextureRegion.split(chessMenImage, chessMenImage.getWidth()/FRAME_COLS, chessMenImage.getHeight()/FRAME_ROWS);
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                chessMenCollection[index++] = tmp[i][j];
            }
        }
        return chessMenCollection;
    }






}
