package tdt4240.chess.Utility;

public class Tuple {
    private int x;
    private int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Tuple other) {
        System.out.println("Triggered");
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
}
