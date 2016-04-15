package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Color;
import tdt4240.chess.Utility.Tuple;

public class Pawn extends Chessman {

    private static TextureRegion image;

    public Pawn(int x, int y, Color color) {
        super(color, 0);
        this.setBounds(x, y, 1, 1);

        if (color == Color.BLACK) {
            this.legalMoves.add(new Tuple(0, 1));
            this.legalMoves.add(new Tuple(0, 2));
            this.attackMoves.add(new Tuple(1, 1));
            this.attackMoves.add(new Tuple(-1, 1));

        }
        else if(color == Color.WHITE) {
            this.legalMoves.add(new Tuple(0, -1));
            this.legalMoves.add(new Tuple(0, -2));
            this.attackMoves.add(new Tuple(-1, -1));
            this.attackMoves.add(new Tuple(1, -1));
        }
    }

    @Override
    public void moved() {
        super.moved();
        if (this.legalMoves.size() == 2) {
            this.legalMoves.remove(1);
        }
    }
}
