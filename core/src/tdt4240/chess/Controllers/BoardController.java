package tdt4240.chess.Controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


import java.util.ArrayList;

import tdt4240.chess.Models.Board;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Models.Tile;
import tdt4240.chess.Utility.Tuple;

public class BoardController extends ClickListener {

    private final Board board;
    private ArrayList<Tile> selectedTiles;

    public BoardController(Board board) {
        this.board = board;
        selectedTiles = new ArrayList<Tile>();
    }

    public void clicked(InputEvent event, float x, float y) {
        Actor target = event.getTarget();
        Tile selectedTile = board.getTileAt((int) target.getX(), (int) target.getY());

        if (selectedTiles.isEmpty()) {
            selectedTiles.add(selectedTile);
        }
        else {
            selectedTiles.get(0).selected = false;
            selectedTiles.remove(0);
            selectedTiles.add(selectedTile);
        }
        selectedTiles.get(0).selected = true;

        if (target.getClass().getSuperclass().equals(Chessman.class)) {
            for (int i = 0; i < ((Chessman) target).getLegalMoves().size(); i++) {
                Tile tile = board.getTileAt(((Chessman) target).getLegalMoves().get(i).getX(), ((Chessman) target).getLegalMoves().get(i).getY());
                tile.highlighted = true;
            }

        }



    }





}
