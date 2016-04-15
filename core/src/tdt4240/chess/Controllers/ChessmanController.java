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
            if((chessman.getY() == 7) || (chessman.getY() == 0)){
                ArrayList<Tuple> newMoves = new ArrayList<Tuple>();
                for (int i = 1; i < 9; i++){
                    newMoves.add(new Tuple(i, i));
                    newMoves.add(new Tuple(-i, -i));
                    newMoves.add(new Tuple(i, -i));
                    newMoves.add(new Tuple(-i, i));
                    newMoves.add(new Tuple(i, 0));
                    newMoves.add(new Tuple(-i, 0));
                    newMoves.add(new Tuple(0, i));
                    newMoves.add(new Tuple(0, -i));
                }
                chessman.setLegalMoves(newMoves);
                if(chessman.getChessmanColor == White){
                    chessman.setSprite(6);
                }else{
                    chessman.setSprite(1);
                }
            }


        }
    }
}
