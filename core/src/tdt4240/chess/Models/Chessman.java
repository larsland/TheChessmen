package tdt4240.chess.Models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import tdt4240.chess.Assets;

public class Chessman extends Actor {

    private ChessmanColor color;
    public int imageOffset;
    private TextureRegion image;

    public Chessman(ChessmanColor color, int type) {
        this.color = color;
        imageOffset = type;
        if (this.color.equals(ChessmanColor.BLACK)) imageOffset +=6;
        image = Assets.loadChessmenImages()[imageOffset];

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 1);
        batch.draw(image, this.getX(), this.getY(), 1, 1);
    }








}
