package tdt4240.chess.Utility.States;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.ChessmanState;
import tdt4240.chess.Utility.Tuple;


public class KingState implements ChessmanState {
    @Override
    public List<Tuple> getLegalMoves(ChessmanColor chessmanColor) {
        List<Tuple> legalMoves = new ArrayList<Tuple>();
        legalMoves.add(new Tuple(1, 0));
        legalMoves.add(new Tuple(0, 1));
        legalMoves.add(new Tuple(1, 1));
        legalMoves.add(new Tuple(-1, -1));
        legalMoves.add(new Tuple(-1, 1));
        legalMoves.add(new Tuple(1, -1));
        legalMoves.add(new Tuple(-1, 0));
        legalMoves.add(new Tuple(0, -1));
        return legalMoves;
    }

    @Override
    public List<Tuple> getAttackMoves(ChessmanColor chessmanColor) {
        return Collections.emptyList();
    }

    @Override
    public TextureRegion getSprite(ChessmanColor chessmanColor) {
        int imageOffset = 5;
        if (chessmanColor == ChessmanColor.WHITE) imageOffset += 6;
        return GraphicsAssets.chessmenCollection[imageOffset];
    }

}
