package tdt4240.chess.Utility;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.List;

public interface ChessmanState {

    List<Tuple> getLegalMoves(ChessmanColor chessmanColor);
    List<Tuple> getAttackMoves(ChessmanColor chessmanColor);
    TextureRegion getSprite(ChessmanColor chessmanColor);
}
