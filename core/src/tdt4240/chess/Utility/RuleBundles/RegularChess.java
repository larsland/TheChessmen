package tdt4240.chess.Utility.RuleBundles;

import java.util.ArrayList;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.Bishop;
import tdt4240.chess.Models.Chessmen.King;
import tdt4240.chess.Models.Chessmen.Knight;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Models.Chessmen.Queen;
import tdt4240.chess.Models.Chessmen.Rock;
import tdt4240.chess.Utility.ChessmanColor;

/**
 * Created by Fredrik on 17/04/16.
 */
public class RegularChess implements tdt4240.chess.Utility.RuleBundle {

    public static ArrayList<Chessman> getChessmen() {
        ArrayList<Chessman> chessmen = new ArrayList<Chessman>();
        for (int i = 0; i < 8; i++) {
            chessmen.add((new Pawn(i, 1, ChessmanColor.BLACK)));
            chessmen.add((new Pawn(i, 6, ChessmanColor.WHITE)));
        }

        chessmen.add((new Rock(0, 0, ChessmanColor.BLACK)));
        chessmen.add((new Rock(7, 0, ChessmanColor.BLACK)));
        chessmen.add((new Rock(0, 7, ChessmanColor.WHITE)));
        chessmen.add((new Rock(7, 7, ChessmanColor.WHITE)));

        //* Add knights. *//*
        chessmen.add((new Knight(1, 0, ChessmanColor.BLACK)));
        chessmen.add((new Knight(6, 0, ChessmanColor.BLACK)));
        chessmen.add((new Knight(1, 7, ChessmanColor.WHITE)));
        chessmen.add((new Knight(6, 7, ChessmanColor.WHITE)));

        //* Add bishops. *//*
        chessmen.add((new Bishop(2, 0, ChessmanColor.BLACK)));
        chessmen.add((new Bishop(5, 0, ChessmanColor.BLACK)));
        chessmen.add((new Bishop(2, 7, ChessmanColor.WHITE)));
        chessmen.add((new Bishop(5, 7, ChessmanColor.WHITE)));

        //* Add queens. *//*
        chessmen.add((new Queen(3, 0, ChessmanColor.BLACK)));
        chessmen.add((new Queen(3, 7, ChessmanColor.WHITE)));

        //* Set and add kings. *//*
        chessmen.add((new King(4, 7, ChessmanColor.WHITE)));
        chessmen.add((new King(4, 0, ChessmanColor.BLACK)));
        return chessmen;
    }




}
