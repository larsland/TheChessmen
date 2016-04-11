package tdt4240.chess.Models.Chessmen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import tdt4240.chess.Assets;
import tdt4240.chess.Models.Chessman;

public class Pawn extends Chessman {

    private static Texture image;


    public Pawn() {
        super(ChessmanColor.BLACK);
        image = Assets.loadChessmenImages()[0].getTexture();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 1);
        batch.draw(image, this.getX(), this.getY(), 1, 1);
    }
}
