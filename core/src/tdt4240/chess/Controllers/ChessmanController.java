package tdt4240.chess.Controllers;

import java.util.List;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Utility.States.QueenState;
import tdt4240.chess.Utility.Tuple;

public class ChessmanController {

    public void moved(Chessman chessman) {
        if (chessman.getClass().equals(Pawn.class)) {
            if (chessman.getLegalMoves().size() == 2) {
                List<Tuple> newMoves = chessman.getLegalMoves();
                newMoves.remove(1);
                chessman.setLegalMoves(newMoves);
            }
            if ((chessman.getY() == 7) || (chessman.getY() == 0)) {
                chessman.getContext().setState(new QueenState(), chessman);

            }
        }
    }
}
