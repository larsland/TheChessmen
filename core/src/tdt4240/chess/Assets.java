package tdt4240.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

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
