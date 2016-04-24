package tdt4240.chess.Models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import tdt4240.chess.AssetClasses.GraphicsAssets;

public class Tile extends Actor {

    private Texture texture;
    public boolean highlighted;
    public boolean attackable;

    public Tile(char c, int x, int y) {

        this.setBounds(x, y, 1, 1);

        switch(c) {
            case 'b': texture = GraphicsAssets.blackTile; break;
            case 'w': texture = GraphicsAssets.whiteTile; break;
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
