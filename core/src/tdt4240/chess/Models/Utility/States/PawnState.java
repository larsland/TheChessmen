package tdt4240.chess.Models.Utility.States;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

import tdt4240.chess.AssetClasses.GraphicsAssets;

public class PawnState implements tdt4240.chess.Models.Utility.ChessmanState {
    @Override
    public List<tdt4240.chess.Models.Utility.Tuple> getLegalMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        List<tdt4240.chess.Models.Utility.Tuple> legalMoves = new ArrayList<tdt4240.chess.Models.Utility.Tuple>();
        if (chessmanColor == tdt4240.chess.Models.Utility.ChessmanColor.BLACK) {
            legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(0, -1));
            legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(0, -2));

        }
        else if(chessmanColor == tdt4240.chess.Models.Utility.ChessmanColor.WHITE) {
            legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(0, 1));
            legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(0, 2));
        }
        return legalMoves;
    }

    @Override
    public List<tdt4240.chess.Models.Utility.Tuple> getAttackMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        List<tdt4240.chess.Models.Utility.Tuple> attackMoves = new ArrayList<tdt4240.chess.Models.Utility.Tuple>();
        if (chessmanColor == tdt4240.chess.Models.Utility.ChessmanColor.BLACK) {
            attackMoves.add(new tdt4240.chess.Models.Utility.Tuple(-1, -1));
            attackMoves.add(new tdt4240.chess.Models.Utility.Tuple(1, -1));

        }
        else if(chessmanColor == tdt4240.chess.Models.Utility.ChessmanColor.WHITE) {
            attackMoves.add(new tdt4240.chess.Models.Utility.Tuple(1, 1));
            attackMoves.add(new tdt4240.chess.Models.Utility.Tuple(-1, 1));
        }
        return attackMoves;
    }

    @Override
    public TextureRegion getSprite(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        int imageOffset = 0;
        if (chessmanColor == tdt4240.chess.Models.Utility.ChessmanColor.WHITE) imageOffset += 6;
        return GraphicsAssets.chessmenCollection[imageOffset];
    }
}
