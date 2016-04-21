package tdt4240.chess.Utility;

import tdt4240.chess.Models.Chessman;



public class StateContext {

    private ChessmanState myState;

    public void setState(final ChessmanState state, Chessman chessman){
        chessman.getLegalMoves().clear();
        chessman.getAttackMoves().clear();
        myState = state;
        this.setMoves(chessman);
        this.setSprite(chessman);
    }

    public ChessmanState getState() { return this.myState; }

    public void setMoves(Chessman chessman){
        chessman.setLegalMoves(myState.getLegalMoves(chessman.getChessmanColor()));
        chessman.setAttackMoves(myState.getAttackMoves(chessman.getChessmanColor()));
    }

    public void setSprite(Chessman chessman) {
        chessman.setSprite(myState.getSprite(chessman.getChessmanColor()));
    }
}
