package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.Tuple;

public class Pawn extends Chessman {

    private static TextureRegion image;

    public Pawn(int x, int y, ChessmanColor chessmanColor) {
        super(chessmanColor, 0);
        this.setBounds(x, y, 1, 1);

        if (chessmanColor == ChessmanColor.BLACK) {
            this.legalMoves.add(new Tuple(0, 1));
            this.legalMoves.add(new Tuple(0, 2));
            this.attackMoves.add(new Tuple(1, 1));
            this.attackMoves.add(new Tuple(-1, 1));

        }
        else if(chessmanColor == ChessmanColor.WHITE) {
            this.legalMoves.add(new Tuple(0, -1));
            this.legalMoves.add(new Tuple(0, -2));
            this.attackMoves.add(new Tuple(-1, -1));
            this.attackMoves.add(new Tuple(1, -1));
        }
    }
}
