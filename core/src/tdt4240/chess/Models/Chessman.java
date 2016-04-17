package tdt4240.chess.Models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.Utility.*;

public class Chessman extends Actor {

    protected ChessmanColor chessmanColor;
    private int imageOffset;
    private TextureRegion image;
    protected ArrayList<Tuple> legalMoves = new ArrayList<Tuple>();
    protected ArrayList<Tuple> attackMoves = new ArrayList<Tuple>();

    public Chessman(ChessmanColor chessmanColor, int type) {
        this.chessmanColor = chessmanColor;
        imageOffset = type;
        if (this.chessmanColor.equals(ChessmanColor.WHITE)) imageOffset +=6;
        image = GraphicsAssets.chessmenCollection[imageOffset];
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, 1);
        batch.draw(image, this.getX(), this.getY(), 1, 1);
    }

    public void setSprite(int offset, int type){
        this.image = GraphicsAssets.chessmenCollection[offset + type];
    }

    public ChessmanColor getChessmanColor(){
        return this.chessmanColor;
    }


    public ArrayList<Tuple> getLegalMoves() {
        return this.legalMoves;
    }
    public ArrayList<Tuple> getAttackMoves() {
        return this.attackMoves;
    }

    public void setAttackMoves(ArrayList<Tuple> moves) {this.attackMoves = moves;}
    public void setLegalMoves(ArrayList<Tuple> moves) {
        this.legalMoves = moves;
    }

    public void attackMoves() {
    }
}
