package tdt4240.chess.Models.Chessmen;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Utility.ChessmanColor;
import tdt4240.chess.Models.Utility.StateContext;
import tdt4240.chess.Models.Utility.States.QueenState;

public class Queen extends Chessman {

    public Queen(int x, int y, ChessmanColor chessmanColor) {
        super(chessmanColor);
        this.setBounds(x, y, 1, 1);

        context = new StateContext();
        context.setState(new QueenState(), this);
        context.setMoves(this);
    }


}
