package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;

public class Knight extends Chessman {

    private static TextureRegion image;

    public Knight(int x, int y, ChessmanColor color) {
        super(color, 2);
        this.setBounds(x, y, 1, 1);
    }


}
