package tdt4240.chess.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.King;
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
                applyPawnRules(chessman);
                break;
            case(2):
                applyPawnRules(chessman);
                Chessman chessmanAtTile = Board.getInstance().getChessmanAt((int) tile.getX(), (int) tile.getY());
                Random random = new Random();
                System.out.println(chessmanAtTile);
                if (chessmanAtTile != null) {
                    if (chessmanAtTile.getClass() == Rifle.class) {
                        ArrayList<Chessman> allChessmen = Board.getInstance().getAllChessmen();
                        int index = random.nextInt(allChessmen.size());
                        Chessman toCheck = Board.getInstance().getChessmanAt((int) allChessmen.get(index).getX(), (int) allChessmen.get(index).getY());
                        SoundAssets.playRifleSound();
                        if (toCheck.getClass() == King.class) {
                            Board.getInstance().setWin(toCheck.getChessmanColor().opposite());
                        }
                        Board.getInstance().removeChessmanAt((int) allChessmen.get(index).getX(), (int) allChessmen.get(index).getY());
                        return;
                    }
                }
                //Define chance of spawning rifle.
                int n = random.nextInt(100) + 1;
                if (n >= 5) {
                    ArrayList<Tile> openTiles = Board.getInstance().getAllEmptyTiles();
                    int index = random.nextInt(openTiles.size());
                    Board.getInstance().addChessman(new Rifle((int) openTiles.get(index).getX(), (int) openTiles.get(index).getY()));
                break;
            }
        }
    }

    private void applyPawnRules(Chessman chessman) {
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
