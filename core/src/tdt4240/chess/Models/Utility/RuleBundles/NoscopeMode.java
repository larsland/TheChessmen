package tdt4240.chess.Models.Utility.RuleBundles;

import java.util.ArrayList;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.Bishop;
import tdt4240.chess.Models.Chessmen.King;
import tdt4240.chess.Models.Chessmen.Knight;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Models.Chessmen.Queen;
import tdt4240.chess.Models.Chessmen.Rock;
import tdt4240.chess.Models.Utility.RuleBundle;

/**
 * Created by berg on 19/04/16.
 */
public class NoscopeMode implements RuleBundle {

    ArrayList<Chessman> chessmen = new ArrayList<Chessman>();

    @Override
    public void instantiateChessmen() {
        for (int i = 0; i < 8; i++) {
            chessmen.add((new Pawn(i, 6, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
            chessmen.add((new Pawn(i, 1, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));
        }

        chessmen.add((new Rock(0, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
        chessmen.add((new Rock(7, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
        chessmen.add((new Rock(0, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));
        chessmen.add((new Rock(7, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));

        //* Add knights. *//*
        chessmen.add((new Knight(1, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
        chessmen.add((new Knight(6, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
        chessmen.add((new Knight(1, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));
        chessmen.add((new Knight(6, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));

        //* Add bishops. *//*
        chessmen.add((new Bishop(2, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
        chessmen.add((new Bishop(5, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
        chessmen.add((new Bishop(2, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));
        chessmen.add((new Bishop(5, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));

        //* Add queens. *//*
        chessmen.add((new Queen(3, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
        chessmen.add((new Queen(3, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));

        //* Set and add kings. *//*
        chessmen.add((new King(4, 0, tdt4240.chess.Models.Utility.ChessmanColor.WHITE)));
        chessmen.add((new King(4, 7, tdt4240.chess.Models.Utility.ChessmanColor.BLACK)));
    }
    @Override
    public void instantiateRules() {

    }
    @Override
    public ArrayList<Chessman> getChessmen() {
        return chessmen;
    }
}
