package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;

public class Queen extends Chessman {

    private static TextureRegion image;

    public Queen(int x, int y, ChessmanColor color) {
        super(color, 4);
        this.setBounds(x, y, 1, 1);
    }


}
