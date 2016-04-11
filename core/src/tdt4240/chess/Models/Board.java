package tdt4240.chess.Models;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import tdt4240.chess.Main;
import tdt4240.chess.Models.Chessmen.Pawn;

public class Board extends Table {

    private Tile[][] tiles;
    private Chessman[][] chessmen;

    private int size = 8;

    public Board() {
        this.setBounds(0, 0, Main.UWIDTH, Main.UWIDTH);
        this.setClip(true);

        tiles = new Tile[8][8];
        addTiles();

    }

    public Tile getTileAt(int x, int y) {
        return this.tiles[x][y];
    }

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

    }

    public Tile[][] getTiles() {
        return this.tiles;
    }




}
