package tdt4240.chess.Models;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import tdt4240.chess.Main;

public class Board extends Table {

    private Tile[][] tiles;
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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = new Tile('b', i, j);
                this.addActor(this.tiles[i][j]);
            }
        }
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }




}
