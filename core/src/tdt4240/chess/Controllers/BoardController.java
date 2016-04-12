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
    private ArrayList<Chessman> selectedChessman;
    private ArrayList<Tile> highlightAttackMoves;
    private String turn = "black";

    public BoardController(Board board) {
        this.board = board;
        selectedTiles = new ArrayList<Tile>();
        highlightedTiles = new ArrayList<Tile>();
        selectedChessman = new ArrayList<Chessman>();
        highlightAttackMoves = new ArrayList<Tile>();
    }

    public void clicked(InputEvent event, float x, float y) {
        Actor target = event.getTarget();
        Tile selectedTile = board.getTileAt((int) target.getX(), (int) target.getY());


        if (!highlightAttackMoves.isEmpty()) {
            removeHighlightedTiles(highlightAttackMoves);
        }
        if (selectedTile.highlighted) {
            moveChessman(selectedChessman.get(0), selectedTile, false);
        }
        if (selectedTile.attackable) {
            moveChessman(selectedChessman.get(0), selectedTile, true);
        }
        if (!highlightedTiles.isEmpty()) {
            removeHighlightedTiles(highlightedTiles);
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
            if(highlightAttackMoves.isEmpty()) {
                highlightAttackMoves((Chessman) target);
            }
            if (selectedChessman.isEmpty()) {
                selectedChessman.add((Chessman) target);
            }
            else {
                selectedChessman.clear();
                selectedChessman.add((Chessman) target);
            }

            if (highlightedTiles.isEmpty()) {
                highlightLegalMoves((Chessman) target);
            }
            else {
                removeHighlightedTiles(highlightedTiles);
                highlightLegalMoves((Chessman) target);
            }
        }
    }

    public void highlightLegalMoves(Chessman chessman) {
        for (int i = 0; i < chessman.getLegalMoves().size(); i++) {
            Tile tile = board.getTileAt((int) chessman.getX() + chessman.getLegalMoves().get(i).getX(), (int) chessman.getY() + chessman.getLegalMoves().get(i).getY());

            if (checkValidMoves(tile)) {
                tile.highlighted = true;
                highlightedTiles.add(tile);
            }
            else {
                break;
            }
        }
    }

    public void highlightAttackMoves(Chessman chessman) {
        for (int i = 0; i < chessman.getAttackMoves().size(); i++) {
            Tile tile = board.getTileAt((int) chessman.getX() + chessman.getAttackMoves().get(i).getX(), (int) chessman.getY() + chessman.getAttackMoves().get(i).getY());

            if (!checkValidMoves(tile)) {
                tile.attackable = true;
                highlightAttackMoves.add(tile);
            }
        }
    }

    public void removeHighlightedTiles(ArrayList<Tile> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).highlighted = false;
            list.get(i).attackable = false;
        }
        list.clear();
    }
    public void moveChessman(Chessman chessman, Tile tile, boolean attack) {
        int oldX = (int) chessman.getX();
        int oldY = (int) chessman.getY();

        chessman.setX(tile.getX());
        chessman.setY(tile.getY());
        chessman.moved();

        if (attack) {
            board.removeChessmanAt((int) chessman.getX(), (int) chessman.getY());
        }
        board.updateChessmenPossitions(oldX, oldY, (int) chessman.getX(), (int) chessman.getY());

    }

    public boolean checkValidMoves(Tile tile) {
        int x = (int) tile.getX();
        int y = (int) tile.getY();
        return board.getChessmanAt(x, y) == null;
    }

} //Class
