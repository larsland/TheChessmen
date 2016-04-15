package tdt4240.chess.Controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import java.util.ArrayList;

import tdt4240.chess.Assets;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Chessmen.Direction;
import tdt4240.chess.Models.Color;
import tdt4240.chess.Models.Tile;

public class BoardController extends ClickListener {

    private final Board board;
    private ArrayList<Tile> selectedTiles;
    private ArrayList<Tile> highlightedTiles;
    private ArrayList<Chessman> selectedChessman;
    private ArrayList<Tile> highlightAttackMoves;
    private Color turn = Color.BLACK;
    private ChessmanController chessmanController;

    public BoardController(Board board) {
        this.board = board;
        selectedTiles = new ArrayList<Tile>();
        highlightedTiles = new ArrayList<Tile>();
        selectedChessman = new ArrayList<Chessman>();
        highlightAttackMoves = new ArrayList<Tile>();
        chessmanController = new ChessmanController();
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

            Chessman man = (Chessman) target;

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
            Tile tile = null;
            try {
                tile = board.getTileAt((int) chessman.getX() + chessman.getLegalMoves().get(i).getX(), (int) chessman.getY() + chessman.getLegalMoves().get(i).getY());
                if (checkValidMoves(chessman, tile)) {
                    tile.highlighted = true;
                    highlightedTiles.add(tile);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
        }
    }

    public void highlightAttackMoves(Chessman chessman) {
        for (int i = 0; i < chessman.getAttackMoves().size(); i++) {
            Tile tile = null;
            try {
                tile = board.getTileAt((int) chessman.getX() + chessman.getAttackMoves().get(i).getX(), (int) chessman.getY() + chessman.getAttackMoves().get(i).getY());
                if (!checkValidMoves(chessman, tile)) {
                    tile.attackable = true;
                    highlightAttackMoves.add(tile);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

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
        Assets.moveChessman();

        int oldX = (int) chessman.getX();
        int oldY = (int) chessman.getY();

        chessman.setX(tile.getX());
        chessman.setY(tile.getY());
        chessmanController.moved(chessman);

        if (attack) {
            board.removeChessmanAt((int) chessman.getX(), (int) chessman.getY());
        }
        board.updateChessmenPossitions(oldX, oldY, (int) chessman.getX(), (int) chessman.getY());
        board.nextTurn();

    }

    public boolean checkValidMoves(Chessman chessman, Tile tile) {
        if (tile != null) {
            Direction direction = getMoveDirection(chessman, tile);

            if (board.getChessmanAt((int) tile.getX(), (int) tile.getY()) != null) {
                return false;
            }
            switch (direction) {
                case NORTH:
                    for (int x = (int) chessman.getY() + 1; x <= tile.getY(); x++) {
                        if (board.getChessmanAt((int) chessman.getX(), x) != null) {
                            return false;
                        }
                    }
                    break;
                case SOUTH:
                    for (int x = (int) chessman.getY() - 1; x >= tile.getY(); x--) {
                        if (board.getChessmanAt((int) chessman.getX(), x) != null) {
                            return false;
                        }
                    }
                    break;
                case WEST:
                    for (int x = (int) chessman.getX() - 1; x >= tile.getX(); x--) {
                        if (board.getChessmanAt(x, (int) chessman.getY()) != null) {
                            return false;
                        }
                    }
                    break;
                case EAST:
                    for (int x = (int) chessman.getX() + 1; x <= tile.getX(); x++) {
                        if (board.getChessmanAt(x, (int) chessman.getY()) != null) {
                            return false;
                        }
                    }
                    break;
                case NORTHEAST:
                    for (int x = (int) chessman.getX() + 1; x <= tile.getX(); x++) {
                        if (board.getChessmanAt(x, (int) (chessman.getY() + (x - chessman.getX()))) != null) {
                            return false;
                        }
                    }
                    break;
                case SOUTHWEST:
                    for (int x = (int) chessman.getX() - 1; x >= tile.getX(); x--) {
                        if (board.getChessmanAt(x, (int) (chessman.getY() - (chessman.getX() - x))) != null) {
                            return false;
                        }
                    }
                    break;
                case NORTHWEST:
                    for (int y = (int) chessman.getY() + 1; y <= tile.getY(); y++) {
                        if (board.getChessmanAt((int) (chessman.getY() + (chessman.getX() - y)), y) != null) {
                            return false;
                        }
                    }
                    break;
                case SOUTHEAST:
                    for (int x = (int) chessman.getX() + 1; x <= tile.getX(); x++) {
                        if (board.getChessmanAt(x, (int) (chessman.getY() + (chessman.getX() - x))) != null) {
                            return false;
                        }
                    }
                    break;
                case UNDEFINED:
                    break;
                    //
                default:
                    break;
            }
            return true;
        }
        return false;
    }

    private Direction getMoveDirection(Chessman chessman, Tile tile) {
        int xDist = (int) (tile.getX() - chessman.getX());
        int yDist = (int) (tile.getY() - chessman.getY());

        if (xDist == yDist) {
            if (xDist > 0) {
                return Direction.NORTHEAST;
            }
            else if (xDist < 0) {
                return Direction.SOUTHWEST;
            }
        }
        else if (xDist > 0 && yDist == 0) {
            return Direction.EAST;
        }
        else if (xDist < 0 && yDist == 0) {
            return Direction.WEST;
        }
        else if (yDist > 0 && xDist == 0) {
            return Direction.NORTH;
        }
        else if (yDist < 0 && xDist == 0) {
            return Direction.SOUTH;
        }

        else if (xDist < 0 && yDist > 0 && Math.abs(xDist) == Math.abs(yDist)) {
            return Direction.NORTHWEST;
        }
        else if (xDist > 0 && yDist < 0 && Math.abs(xDist) == Math.abs(yDist)) {
            return Direction.SOUTHEAST;
        }
        return Direction.UNDEFINED;
    }
} //Class
