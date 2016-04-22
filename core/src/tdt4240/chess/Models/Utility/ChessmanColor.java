package tdt4240.chess.Models.Utility;

public enum ChessmanColor {
    BLACK, WHITE, ChessmanColor;

    public ChessmanColor opposite() {
        switch(this) {
            case BLACK: return ChessmanColor.WHITE;
            case WHITE: return ChessmanColor.BLACK;
            default: return null;
        }
    }
}
