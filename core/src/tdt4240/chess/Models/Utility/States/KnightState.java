package tdt4240.chess.Models.Utility.States;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tdt4240.chess.AssetClasses.GraphicsAssets;


public class KnightState implements tdt4240.chess.Models.Utility.ChessmanState {
    @Override
    public List<tdt4240.chess.Models.Utility.Tuple> getLegalMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        List<tdt4240.chess.Models.Utility.Tuple> legalMoves = new ArrayList<tdt4240.chess.Models.Utility.Tuple>();
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(1, 2));
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(2, 1));
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(1, -2));
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(2, -1));
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(-1, -2));
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(-2, -1));
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(-1, 2));
        legalMoves.add(new tdt4240.chess.Models.Utility.Tuple(-2, 1));
        return legalMoves;
    }

    @Override
    public List<tdt4240.chess.Models.Utility.Tuple> getAttackMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        return Collections.emptyList();
    }

    @Override
    public TextureRegion getSprite(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        int imageOffset = 2;
        if (chessmanColor == tdt4240.chess.Models.Utility.ChessmanColor.WHITE) imageOffset += 6;
        return GraphicsAssets.chessmenCollection[imageOffset];
    }

}
