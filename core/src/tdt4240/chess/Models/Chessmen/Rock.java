package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;
import tdt4240.chess.Utility.Tuple;

public class Rock extends Chessman {

    private static TextureRegion image;

    public Rock(int x, int y, ChessmanColor color) {
        super(color, 1);
        this.setBounds(x, y, 1, 1);

        for (int i = 1; i < 9; i++) {
            this.legalMoves.add(new Tuple(i, 0));
            this.legalMoves.add(new Tuple(-i, 0));
            this.legalMoves.add(new Tuple(0, i));
            this.legalMoves.add(new Tuple(0, -i));
        }
    }


}
