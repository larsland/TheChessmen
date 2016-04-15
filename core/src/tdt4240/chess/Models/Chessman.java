package tdt4240.chess.Models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

import tdt4240.chess.Assets;
import tdt4240.chess.Controllers.ChessmanController;
import tdt4240.chess.Utility.Tuple;

public class Chessman extends Actor {

    protected Color color;
    public int imageOffset;
    private TextureRegion image;
    protected ArrayList<Tuple> legalMoves = new ArrayList<Tuple>();
    protected ArrayList<Tuple> attackMoves = new ArrayList<Tuple>();

    public Chessman(Color color, int type) {
        this.color = color;
        imageOffset = type;
        if (this.color.equals(Color.WHITE)) imageOffset +=6;
        image = Assets.loadChessmenImages()[imageOffset];
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 1);
        batch.draw(image, this.getX(), this.getY(), 1, 1);
    }


    public ArrayList<Tuple> getLegalMoves() {
        return this.legalMoves;
    }
    public ArrayList<Tuple> getAttackMoves() {
        return this.attackMoves;
    }
    public void setLegalMoves(ArrayList<Tuple> moves) {
        this.legalMoves = moves;
    }

    public Color getChessmanColor() {
        return this.color;
    }










}
