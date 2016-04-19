package tdt4240.chess.Utility;

import tdt4240.chess.Models.Chessman;



public class StateContext {

    private ChessmanState myState;

    public void setState(final ChessmanState state, Chessman chessman){
        myState = state;
        this.setMoves(chessman);
        this.setSprite(chessman);

    }

    public void setMoves(Chessman chessman){
        chessman.setLegalMoves(myState.getLegalMoves(chessman.getChessmanColor()));
        chessman.setAttackMoves(myState.getAttackMoves(chessman.getChessmanColor()));
    }

    public void setSprite(Chessman chessman) {
        chessman.setSprite(myState.getSprite(chessman.getChessmanColor()));
    }
}
