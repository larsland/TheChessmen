package tdt4240.chess.Models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.ArrayList;
import java.util.List;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.StateContext;
import tdt4240.chess.Utility.Tuple;

public class Chessman extends Actor {

    protected ChessmanColor chessmanColor;
    private TextureRegion image;
    protected List<Tuple> legalMoves = new ArrayList<Tuple>();
    protected List<Tuple> attackMoves = new ArrayList<Tuple>();
    protected StateContext context;

    public Chessman(ChessmanColor chessmanColor) {
        this.chessmanColor = chessmanColor;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 1);
        batch.draw(image, this.getX(), this.getY(), 1, 1);
    }

    public StateContext getContext() { return this.context; }

    public void setSprite(TextureRegion sprite) {
        this.image = sprite;
    }

    public TextureRegion getSprite() { return this.image; }

    public ChessmanColor getChessmanColor(){
        return this.chessmanColor;
    }


    public List<Tuple> getLegalMoves() {
        return this.legalMoves;
    }
    public List<Tuple> getAttackMoves() {
        return this.attackMoves;
    }

    public void setAttackMoves(List<Tuple> moves) {this.attackMoves = moves;}
    public void setLegalMoves(List<Tuple> moves) {
        this.legalMoves = moves;
    }

    @Override
    public String toString() {
        String color =  chessmanColor == ChessmanColor.WHITE ? "w" : "b";
        return color;
    }
}
