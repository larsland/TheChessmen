package tdt4240.chess.Models.Utility;

public class Tuple {
    private int x;
    private int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Tuple other) {
        return (other.getX() == this.x && other.getY() == this.y);
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) { this.x = x; }
}
