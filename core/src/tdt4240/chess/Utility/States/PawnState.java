package tdt4240.chess.Utility.States;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.ChessmanState;
import tdt4240.chess.Utility.Tuple;

public class PawnState implements ChessmanState {
    @Override
    public List<Tuple> getLegalMoves(ChessmanColor chessmanColor) {
        List<Tuple> legalMoves = new ArrayList<Tuple>();
        if (chessmanColor == ChessmanColor.BLACK) {
            legalMoves.add(new Tuple(0, -1));
            legalMoves.add(new Tuple(0, -2));

        }
        else if(chessmanColor == ChessmanColor.WHITE) {
            legalMoves.add(new Tuple(0, 1));
            legalMoves.add(new Tuple(0, 2));
        }
        return legalMoves;
    }

    @Override
    public List<Tuple> getAttackMoves(ChessmanColor chessmanColor) {
        List<Tuple> attackMoves = new ArrayList<Tuple>();
        if (chessmanColor == ChessmanColor.BLACK) {
            attackMoves.add(new Tuple(-1, -1));
            attackMoves.add(new Tuple(1, -1));

        }
        else if(chessmanColor == ChessmanColor.WHITE) {
            attackMoves.add(new Tuple(1, 1));
            attackMoves.add(new Tuple(-1, 1));
        }
        return attackMoves;
    }

    @Override
    public TextureRegion getSprite(ChessmanColor chessmanColor) {
        int imageOffset = 0;
        if (chessmanColor == ChessmanColor.WHITE) imageOffset += 6;
        return GraphicsAssets.chessmenCollection[imageOffset];
    }
}
