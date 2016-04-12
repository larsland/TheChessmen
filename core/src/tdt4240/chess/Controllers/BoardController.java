package tdt4240.chess.Controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import java.util.ArrayList;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Tile;

public class BoardController extends ClickListener {

    private final Board board;
    private ArrayList<Tile> selectedTiles;
    private ArrayList<Tile> highlightedTiles;

    public BoardController(Board board) {
        this.board = board;
        selectedTiles = new ArrayList<Tile>();
        highlightedTiles = new ArrayList<Tile>();
    }

    public void clicked(InputEvent event, float x, float y) {
        Actor target = event.getTarget();
        Tile selectedTile = board.getTileAt((int) target.getX(), (int) target.getY());

        if (!highlightedTiles.isEmpty()) {
            removeHighlightedLegalMoves();
        }

        if (selectedTiles.isEmpty()) {
            selectedTiles.add(selectedTile);
        } else {
            selectedTiles.get(0).selected = false;
            selectedTiles.remove(0);
            selectedTiles.add(selectedTile);
        }
        selectedTiles.get(0).selected = true;

        if (target.getClass().getSuperclass().equals(Chessman.class)) {
            System.out.println(((Chessman) target).getChessmanColor());

            if (highlightedTiles.isEmpty()) {
                highlightLegalMoves((Chessman) target);
            }
            else {
                removeHighlightedLegalMoves();
                highlightLegalMoves((Chessman) target);
            }
        }
    }

    public void highlightLegalMoves(Chessman chessman) {
        for (int i = 0; i < chessman.getLegalMoves().size(); i++) {
            Tile tile = board.getTileAt(chessman.getLegalMoves().get(i).getX(), chessman.getLegalMoves().get(i).getY());
            tile.highlighted = true;
            highlightedTiles.add(tile);
        }
    }
    public void removeHighlightedLegalMoves() {
        for (int i = 0; i < highlightedTiles.size(); i++) {
            highlightedTiles.get(i).highlighted = false;
        }
        highlightedTiles.clear();
    }
    public void moveChessman(Chessman chessman, Tile tile) {


    }

    public void reverseLegalMoves(Chessman chessman) {
        for (int i = 0; i < chessman.getLegalMoves().size(); i++) {
            chessman.getLegalMoves().get(i).setY(-1 * chessman.getLegalMoves().get(i).getY());
            for (int j = 0; j < chessman.getLegalMoves().size(); j++) {
                System.out.println(chessman.getLegalMoves().get(j).getY());
            }
        }
    }






} //Class
