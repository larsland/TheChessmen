package tdt4240.chess.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tile extends Actor {

    private ChessmanColor chessmanColor;
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
            case 'b': chessmanColor = ChessmanColor.BLACK;
                texture = new Texture(Gdx.files.internal("blackTile.png")); break;
            case 'w': chessmanColor = ChessmanColor.WHITE;
                texture = new Texture(Gdx.files.internal("whiteTile.png")); break;
        }

    }

    public Texture getTexture() {
        return this.texture;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 1);

        if (this.selected) {
            batch.draw(new Texture(Gdx.files.internal("highlight.png")), this.getX(), this.getY(), 1, 1);
        }
        else if (this.highlighted) {
            batch.draw(new Texture(Gdx.files.internal("moveHighlight.png")), this.getX(), this.getY(), 1, 1);
        }
        else if (this.attackable) {
            batch.draw(new Texture(Gdx.files.internal("attackHighlight.png")), this.getX(), this.getY(), 1, 1);
        }
        else {
            batch.draw(texture, this.getX(), this.getY(), 1, 1);
        }


    }


}
