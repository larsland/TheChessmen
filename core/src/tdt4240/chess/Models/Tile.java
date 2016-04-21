package tdt4240.chess.Models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import tdt4240.chess.AssetClasses.GraphicsAssets;

public class Tile extends Actor {

    private tdt4240.chess.Utility.ChessmanColor chessmanColor;
    private Texture texture;
    private int x, y;
    public boolean selected;
    public boolean highlighted;
    public boolean attackable;

    public Tile(char c, int x, int y) {

        this.setBounds(x, y, 1, 1);

        this.x = x;
        this.y = y;

        switch(c) {
            case 'b': chessmanColor = tdt4240.chess.Utility.ChessmanColor.BLACK;
                texture = GraphicsAssets.blackTile; break;
            case 'w': chessmanColor = tdt4240.chess.Utility.ChessmanColor.WHITE;
                texture = GraphicsAssets.whiteTile; break;
        }

    }

    public Texture getTexture() {
        return this.texture;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 1);

        if (this.highlighted) {
            batch.draw(GraphicsAssets.highlightTile, this.getX(), this.getY(), 1, 1);
        }
        else if (this.attackable) {
            batch.draw(GraphicsAssets.attackTile, this.getX(), this.getY(), 1, 1);
        }
        else {
            batch.draw(texture, this.getX(), this.getY(), 1, 1);
        }


    }


}
