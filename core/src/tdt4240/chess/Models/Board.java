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

public class Board extends Table {

    private Tile[][] tiles;
    private Chessman[][] chessmen;
    private Color turn = Color.BLACK;

    private int size = 8;

    public Board() {
        this.setBounds(0, 0, Main.UWIDTH, Main.UWIDTH);
        this.setClip(true);
        this.addListener(new BoardController(this));

        tiles = new Tile[8][8];
        chessmen = new Chessman[8][8];
        addTiles();
        addChessmen();
    }

    public Tile getTileAt(int x, int y) {
        return this.tiles[x][y];
    }
    public Chessman getChessmanAt(int x, int y) { return this.chessmen[x][y]; }

    public void addTiles() {
        char lastTile = 'w';

        for (int i = 0; i < size; i++) {
            if (lastTile == 'w') {
                lastTile = 'b';
            }
            else if (lastTile == 'b') {
                lastTile = 'w';
            }
            for (int j = 0; j < size; j++) {

                if (lastTile == 'w') {
                    tiles[i][j] = new Tile('b', i, j);
                    lastTile = 'b';
                }
                else if (lastTile == 'b') {
                    tiles[i][j] = new Tile('w', i, j);
                    lastTile = 'w';
                }

                this.addActor(this.tiles[i][j]);

            }
        }
    }

    public void addChessmen() {
        for (int i = 0; i < size; i++) {
            this.addChessman(new Pawn(i, 1, Color.BLACK));
            this.addChessman(new Pawn(i, 6, Color.WHITE));
        }

        this.addChessman(new Rock(0, 0, Color.BLACK));
        this.addChessman(new Rock(7, 0, Color.BLACK));
        this.addChessman(new Rock(0, 7, Color.WHITE));
        this.addChessman(new Rock(7, 7, Color.WHITE));

        /* Add knights. */
        this.addChessman(new Knight(1, 0, Color.BLACK));
        this.addChessman(new Knight(6, 0, Color.BLACK));
        this.addChessman(new Knight(1, 7, Color.WHITE));
        this.addChessman(new Knight(6, 7, Color.WHITE));

        /* Add bishops. */
        this.addChessman(new Bishop(2, 0, Color.BLACK));
        this.addChessman(new Bishop(5, 0, Color.BLACK));
        this.addChessman(new Bishop(2, 7, Color.WHITE));
        this.addChessman(new Bishop(5, 7, Color.WHITE));

        /* Add queens. */
        this.addChessman(new Queen(3, 0, Color.BLACK));
        this.addChessman(new Queen(3, 7, Color.WHITE));

        /* Set and add kings. */
        this.addChessman(new King(4, 7, Color.WHITE));
        this.addChessman(new King(4, 0, Color.BLACK));
    }

    public void updateChessmenPossitions(int oldX, int oldY, int x, int y) {
        Chessman chessman = this.chessmen[oldX][oldY];
        this.chessmen[x][y] = chessman;
        this.chessmen[oldX][oldY] = null;
        chessman.setX(x);
        chessman.setY(y);
    }

    public void removeChessmanAt(int x, int y) {
        this.chessmen[x][y] = null;
    }

    public void addChessman(Chessman man) {
        this.addActor(man);
        this.chessmen[(int) man.getX()][(int) man.getY()] = man;
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public Color getTurn() {
        return this.turn;
    }
    public void nextTurn() {
        if (turn.equals(Color.BLACK)) {
            turn = Color.WHITE;
        }
        else if (turn.equals(Color.WHITE)) {
            turn = Color.BLACK;
        }
    }




}
