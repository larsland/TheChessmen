package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;

public class King extends Chessman {

    private static TextureRegion image;

    public King(int x, int y, ChessmanColor color) {
        super(color, 5);
        this.setBounds(x, y, 1, 1);
    }


}
