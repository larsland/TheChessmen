package tdt4240.chess.Utility;

public enum ChessmanColor {
    BLACK, WHITE;

    public ChessmanColor opposite() {
        switch(this) {
            case BLACK: return ChessmanColor.WHITE;
            case WHITE: return ChessmanColor.BLACK;
            default: return null;
        }
    }

}
