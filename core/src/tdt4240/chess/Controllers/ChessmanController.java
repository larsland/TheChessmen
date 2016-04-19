package tdt4240.chess.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tdt4240.chess.Models.Board;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Models.Chessmen.Rifle;
import tdt4240.chess.Models.Tile;
import tdt4240.chess.Utility.Options;
import tdt4240.chess.Utility.States.QueenState;
import tdt4240.chess.Utility.Tuple;

public class ChessmanController {

    public void moved(Chessman chessman, Tile tile) {

        switch(Options.GAME_MODE) {
            case(0):
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
                break;
            case(2):
                Chessman chessmanAtTile = Board.getInstance().getChessmanAt((int) tile.getX(), (int) tile.getY());
                Random random = new Random();
                if (chessmanAtTile != null) {
                    if (chessmanAtTile.getColor() == null) {
                        ArrayList<Chessman> allChessmen = Board.getInstance().getAllChessmen();
                        int index = random.nextInt(allChessmen.size());
                        Board.getInstance().removeChessmanAt((int) allChessmen.get(index).getX(), (int) allChessmen.get(index).getY());
                        return;
                    }
                }
                int n = random.nextInt(100) + 1;
                if (n >= 95) {
                    Board.getInstance().addChessman(new Rifle());
                break;
            }
        }
    }
}
