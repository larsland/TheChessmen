package tdt4240.chess;

import com.badlogic.gdx.graphics.glutils.FileTextureData;

import org.junit.Test;
import org.junit.runner.RunWith;

import tdt4240.chess.GdxTestRunner;
import tdt4240.chess.Models.Tile;

import static org.junit.Assert.assertTrue;


/**
 * Created by iver on 17/04/16.
 */

@RunWith(GdxTestRunner.class)

public class TileTest {

    @Test
    public void tile_CorrectTilePosition() {
        Tile tile = new Tile('w', 2, 3);
        assertTrue(tile.getX() == 2);
        assertTrue(tile.getY() == 3);
    }

    @Test
    public void tile_CorrectTileColor() {
        Tile whiteTile = new Tile('w', 2, 3);
        Tile blackTile = new Tile('b', 2, 3);
        assertTrue(((FileTextureData)whiteTile.getTexture().getTextureData())
                .getFileHandle().path().equals("whiteTile.png"));
        assertTrue(((FileTextureData)blackTile.getTexture().getTextureData())
                .getFileHandle().path().equals("blackTile.png"));
    }
}
