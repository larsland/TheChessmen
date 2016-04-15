package tdt4240.chess.Controllers;

import java.util.ArrayList;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Utility.Tuple;

public class ChessmanController {

    public void moved(Chessman chessman) {
        if (chessman.getClass().equals(Pawn.class)) {
            if (chessman.getLegalMoves().size() == 2) {
                ArrayList<Tuple> newMoves = chessman.getLegalMoves();
                newMoves.remove(1);
                chessman.setLegalMoves(newMoves);
            }
        }

    }

}
