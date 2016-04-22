package tdt4240.chess.Models.Utility;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.List;

public interface ChessmanState {

    List<Tuple> getLegalMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor);
    List<Tuple> getAttackMoves(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor);
    TextureRegion getSprite(tdt4240.chess.Models.Utility.ChessmanColor chessmanColor);
}
