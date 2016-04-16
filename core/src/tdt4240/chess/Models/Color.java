package tdt4240.chess.Models;

public enum Color {
    BLACK, WHITE;

    public Color opposite() {
        switch(this) {
            case BLACK: return Color.WHITE;
            case WHITE: return Color.BLACK;
            default: throw new IllegalStateException("This should never happen: " + this + " has no opposite.");
        }
    }

}
