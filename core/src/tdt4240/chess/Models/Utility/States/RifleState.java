package tdt4240.chess.Models.Utility.States;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

import tdt4240.chess.AssetClasses.GraphicsAssets;

/**
 * Created by berg on 19/04/16.
 */
public class RifleState implements tdt4240.chess.Models.Utility.ChessmanState {
    @Override
    public List<tdt4240.chess.Models.Utility.Tuple> getLegalMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        return new ArrayList<tdt4240.chess.Models.Utility.Tuple>();
    }

    @Override
    public List<tdt4240.chess.Models.Utility.Tuple> getAttackMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        return new ArrayList<tdt4240.chess.Models.Utility.Tuple>();
    }

    @Override
    public TextureRegion getSprite(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor) {
        return GraphicsAssets.sniper;
    }
}
