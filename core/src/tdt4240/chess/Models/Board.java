package tdt4240.chess.Models;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import tdt4240.chess.Controllers.BoardController;
import tdt4240.chess.Main;

public class Board extends Table {

    private Tile[][] tiles;
    private Chessman[][] chessmen;
    private tdt4240.chess.Utility.ChessmanColor turn = tdt4240.chess.Utility.ChessmanColor.BLACK;
    private tdt4240.chess.Utility.ChessmanColor win = null;

    public Board() {
        this.setBounds(0, 0, Main.UWIDTH, Main.UWIDTH);
        this.setClip(true);

        tiles = new Tile[8][8];
        chessmen = new Chessman[8][8];
        this.addListener(new BoardController(this));
    }
    public void setWin(tdt4240.chess.Utility.ChessmanColor chessmanColor) {
        win = chessmanColor;
    }
    public tdt4240.chess.Utility.ChessmanColor getWin() {
        return win;
    }
    public Tile getTileAt(int x, int y) {
        return this.tiles[x][y];
    }
    public Chessman getChessmanAt(int x, int y) { return this.chessmen[x][y]; }

    public void removeChessmanAt(int x, int y) {
        this.removeActor(this.chessmen[x][y]);
        this.chessmen[x][y] = null;

    }
    public void addTile(Tile tile) {
        tiles[(int) tile.getX()][(int) tile.getY()] = tile;
        this.addActor(tile);
    }

    public void addChessman(Chessman man) {
        this.addActor(man);
        this.chessmen[(int) man.getX()][(int) man.getY()] = man;
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public tdt4240.chess.Utility.ChessmanColor getTurn() {
        return this.turn;
    }
    public void setTurn(tdt4240.chess.Utility.ChessmanColor turn) {
        this.turn = turn;
    }
    public void updateChessmenPositions(int oldX, int oldY, int x, int y) {
        Chessman chessman = this.chessmen[oldX][oldY];
        this.chessmen[x][y] = chessman;
        this.chessmen[oldX][oldY] = null;
        chessman.setX(x);
        chessman.setY(y);
    }
}
