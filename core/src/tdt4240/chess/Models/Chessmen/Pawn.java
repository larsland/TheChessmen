package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;
import tdt4240.chess.Utility.Tuple;

public class Pawn extends Chessman {

    private static TextureRegion image;

    public Pawn(int x, int y, ChessmanColor color) {
        super(color, 0);
        this.setBounds(x, y, 1, 1);

        if (color == ChessmanColor.BLACK) {
            addLegalMoves(new Tuple((int) this.getX(), (int) this.getY() + 1));
            addLegalMoves(new Tuple((int) this.getX(), (int) this.getY() + 2));
        }
        else if(color == ChessmanColor.WHITE) {
            addLegalMoves(new Tuple((int) this.getX(), (int) this.getY() -1));
            addLegalMoves(new Tuple((int) this.getX(), (int) this.getY() -2));
        }

    }








}
