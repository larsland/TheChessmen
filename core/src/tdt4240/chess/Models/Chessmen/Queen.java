package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;
import tdt4240.chess.Utility.Tuple;

public class Queen extends Chessman {

    private static TextureRegion image;

    public Queen(int x, int y, ChessmanColor chessmanColor) {
        super(chessmanColor, 4);
        this.setBounds(x, y, 1, 1);

        for (int i = 1; i < 9; i++) {
            this.legalMoves.add(new Tuple(i, i));
            this.legalMoves.add(new Tuple(-i, -i));
            this.legalMoves.add(new Tuple(i, -i));
            this.legalMoves.add(new Tuple(-i, i));
            this.legalMoves.add(new Tuple(i, 0));
            this.legalMoves.add(new Tuple(-i, 0));
            this.legalMoves.add(new Tuple(0, i));
            this.legalMoves.add(new Tuple(0, -i));
        }
    }


}
