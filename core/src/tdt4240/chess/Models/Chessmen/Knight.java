package tdt4240.chess.Models.Chessmen;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.StateContext;
import tdt4240.chess.Utility.States.KnightState;

public class Knight extends Chessman {

    public Knight(int x, int y, ChessmanColor chessmanColor) {
        super(chessmanColor);
        this.setBounds(x, y, 1, 1);

        context = new StateContext();
        context.setState(new KnightState(), this);
        context.setMoves(this);
    }

}
