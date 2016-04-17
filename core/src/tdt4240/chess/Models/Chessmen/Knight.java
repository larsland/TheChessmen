package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;
import tdt4240.chess.Utility.Tuple;

public class Knight extends Chessman {

    private static TextureRegion image;

    public Knight(int x, int y, ChessmanColor chessmanColor) {
        super(chessmanColor, 2);
        this.setBounds(x, y, 1, 1);

        this.legalMoves.add(new Tuple(1, 2));
        this.legalMoves.add(new Tuple(2, 1));
        this.legalMoves.add(new Tuple(1, -2));
        this.legalMoves.add(new Tuple(2, -1));
        this.legalMoves.add(new Tuple(-1, -2));
        this.legalMoves.add(new Tuple(-2, -1));
        this.legalMoves.add(new Tuple(-1, 2));
        this.legalMoves.add(new Tuple(-2, 1));
    }


}
