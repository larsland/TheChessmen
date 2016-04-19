package tdt4240.chess.Utility.States;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.ChessmanState;
import tdt4240.chess.Utility.Tuple;

/**
 * Created by berg on 19/04/16.
 */
public class RifleState implements ChessmanState {
    @Override
    public List<Tuple> getLegalMoves(ChessmanColor chessmanColor) {
        return new ArrayList<Tuple>();
    }

    @Override
    public List<Tuple> getAttackMoves(ChessmanColor chessmanColor) {
        return new ArrayList<Tuple>();
    }

    @Override
    public TextureRegion getSprite(ChessmanColor chessmanColor) {
        return GraphicsAssets.sniper;
    }
}
