package tdt4240.chess.Models;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import tdt4240.chess.Controllers.BoardController;
import tdt4240.chess.Main;
import tdt4240.chess.Models.Chessmen.Bishop;
import tdt4240.chess.Models.Chessmen.King;
import tdt4240.chess.Models.Chessmen.Knight;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Models.Chessmen.Queen;
import tdt4240.chess.Models.Chessmen.Rock;
import tdt4240.chess.Utility.ChessmanColor;

public class Board extends Table {

    private Tile[][] tiles;
    private Chessman[][] chessmen;

    private ChessmanColor turn = ChessmanColor.BLACK;
    private ChessmanColor win = null;
    BoardController boardController;

    private static Board instance = null;

    private Board() { }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
            instance.setBounds(0, 0, Main.UWIDTH, Main.UWIDTH);
            instance.setClip(true);
            instance.tiles = new Tile[8][8];
            instance.chessmen = new Chessman[8][8];
            instance.boardController = new BoardController();
            instance.addListener(instance.boardController);
        }
        return instance;
    }
    public static void destroy() {
        instance = null;
    }
    public void setWin(ChessmanColor chessmanColor) {
        win = chessmanColor;
    }
    public ChessmanColor getWin() {
        return win;
    }
    public Tile getTileAt(int x, int y) {
        return this.tiles[x][y];
    }
    public Chessman getChessmanAt(int x, int y) { return this.chessmen[x][y]; }
    public BoardController getController() { return this.boardController; }

    public void updateChessmenPositions(int oldX, int oldY, int x, int y) {
        Chessman chessman = this.chessmen[oldX][oldY];
        this.chessmen[x][y] = chessman;
        this.chessmen[oldX][oldY] = null;
        chessman.setX(x);
        chessman.setY(y);
    }

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

    @Override
    public String toString() {
        String map = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChessmanAt(j, i) == null) map += " + ";
                else map += getChessmanAt(j, i) + " ";
            }
            map += "\n";
        }
        return map;
    }

}
