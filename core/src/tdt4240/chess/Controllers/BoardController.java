package tdt4240.chess.Controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import java.util.ArrayList;

import tdt4240.chess.AssetClasses.SoundAssets;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.Direction;
import tdt4240.chess.Models.Chessmen.King;
import tdt4240.chess.Utility.Options;
import tdt4240.chess.Utility.RuleBundles.RegularChess;
import tdt4240.chess.Models.Tile;
import tdt4240.chess.Utility.Tuple;

public class BoardController extends ClickListener {

    private final Board board;
    private ArrayList<Tile> highlightedTiles;
    private Chessman selectedChessman;
    private ArrayList<Tile> highlightAttackMoves;
    private ChessmanColor turn = ChessmanColor.BLACK;
    private ChessmanController chessmanController;

    public BoardController(Board board) {
        this.board = board;
        highlightedTiles = new ArrayList<Tile>();
        selectedChessman = null;
        highlightAttackMoves = new ArrayList<Tile>();
        chessmanController = new ChessmanController();
        this.addTiles();
        this.populateBoard();
    }

    public void clicked(InputEvent event, float x, float y) {
        Actor target = event.getTarget();
        Tile selectedTile = Board.getInstance().getTileAt((int) target.getX(), (int) target.getY());
        if (selectedChessman == null) {
            Chessman current = Board.getInstance().getChessmanAt((int) selectedTile.getX(), (int) selectedTile.getY());
            if (current == null) {
                return;
            }
            else if (current.getChessmanColor() == Board.getInstance().getTurn()) {
                selectedChessman = current;
                highlightMoves(selectedChessman);
            }
            else {
                removeHighlightedTiles(highlightedTiles);
                removeHighlightedTiles(highlightAttackMoves);
            }
        }
        else {
            Chessman current = Board.getInstance().getChessmanAt((int) selectedTile.getX(), (int) selectedTile.getY());
            if (current == null) {
                if (highlightedTiles.contains(selectedTile)) {
                    moveChessman(selectedChessman, selectedTile, false);
                    turn = turn.opposite();
                }
                selectedChessman = null;
                removeHighlightedTiles(highlightedTiles);
                removeHighlightedTiles(highlightAttackMoves);
            }
            else {
                if (highlightAttackMoves.contains(selectedTile)) {
                    if (isKingTile(selectedTile)) {
                        Board.getInstance().setWin(Board.getInstance().getTurn());
                        System.out.println(Board.getInstance().getTurn() + " wins");
                    }
                    moveChessman(selectedChessman, selectedTile, true);
                    turn = turn.opposite();
                }
                removeHighlightedTiles(highlightedTiles);
                removeHighlightedTiles(highlightAttackMoves);
                selectedChessman = null;
            }
        }
    }

    private void highlightMoves(Chessman chessman) {
        for (int i = 0; i < chessman.getLegalMoves().size(); i++) {

            Tile tile = null;
            try {
                tile = Board.getInstance().getTileAt((int) chessman.getX() + chessman.getLegalMoves().get(i).getX(), (int) chessman.getY() + chessman.getLegalMoves().get(i).getY());
                if (chessman.getAttackMoves().size() == 0) {
                    highlightMove(chessman, tile, true);
                } else {
                    highlightMove(chessman, tile, false);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        for (int i = 0; i < chessman.getAttackMoves().size(); i++) {
            Tile tile = null;
            try {
                tile = Board.getInstance().getTileAt((int) chessman.getX() + chessman.getAttackMoves().get(i).getX(), (int) chessman.getY() + chessman.getAttackMoves().get(i).getY());
                highlightMove(chessman, tile, true);
            }
            catch (ArrayIndexOutOfBoundsException e) {

            }
        }
    }

    private void addTiles() {
        char lastTile = 'w';

        for (int i = 0; i < 8; i++) {
            if (lastTile == 'w') {
                lastTile = 'b';
            }
            else if (lastTile == 'b') {
                lastTile = 'w';
            }
            for (int j = 0; j < 8; j++) {

                if (lastTile == 'w') {
                    Board.getInstance().addTile(new Tile('b', i, j));
                    lastTile = 'b';
                }
                else if (lastTile == 'b') {
                    Board.getInstance().addTile(new Tile('w', i, j));
                    lastTile = 'w';
                }
            }
        }
    }

    private void removeHighlightedTiles(ArrayList<Tile> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).highlighted = false;
            list.get(i).attackable = false;
        }
        list.clear();
    }

    private void moveChessman(Chessman chessman, Tile tile, boolean attack) {
        int oldX = (int) chessman.getX();
        int oldY = (int) chessman.getY();

        chessman.setX(tile.getX());
        chessman.setY(tile.getY());
        chessmanController.moved(chessman);

        if (attack) {
            SoundAssets.playAttackChessmanSound();
            Board.getInstance().removeChessmanAt((int) chessman.getX(), (int) chessman.getY());
        }
        else {
            SoundAssets.playMoveChessmanSound();
        }
        Board.getInstance().updateChessmenPositions(oldX, oldY, (int) chessman.getX(), (int) chessman.getY());
        Board.getInstance().setTurn(Board.getInstance().getTurn().opposite());
    }

    private void highlightMove(Chessman chessman, Tile tile, boolean highlightAttack) {
        if (tile != null) {
            Direction direction = getMoveDirection(chessman, tile);
            switch (direction) {
                case NORTH:
                    for (int x = (int) chessman.getY() + 1; x <= tile.getY(); x++) {
                        if (Board.getInstance().getChessmanAt((int) chessman.getX(), x) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt((int) chessman.getX(), x).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt((int) chessman.getX(), x).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case SOUTH:
                    for (int x = (int) chessman.getY() - 1; x >= tile.getY(); x--) {
                        if (Board.getInstance().getChessmanAt((int) chessman.getX(), x) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt((int) chessman.getX(), x).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt((int) chessman.getX(), x).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case WEST:
                    for (int x = (int) chessman.getX() - 1; x >= tile.getX(); x--) {
                        if (Board.getInstance().getChessmanAt(x, (int) chessman.getY()) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt(x, (int) chessman.getY()).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt(x, (int) chessman.getY()).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case EAST:
                    for (int x = (int) chessman.getX() + 1; x <= tile.getX(); x++) {
                        if (Board.getInstance().getChessmanAt(x, (int) chessman.getY()) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt(x, (int) chessman.getY()).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt(x, (int) chessman.getY()).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case NORTHEAST:
                    for (int x = (int) chessman.getX() + 1; x <= tile.getX(); x++) {
                        if (Board.getInstance().getChessmanAt(x, (int) (chessman.getY() + (x - chessman.getX()))) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt(x, (int) (chessman.getY() + (x - chessman.getX()))).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt(x, (int) (chessman.getY() + (x - chessman.getX()))).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case SOUTHWEST:
                    for (int x = (int) chessman.getX() - 1; x >= tile.getX(); x--) {
                        if (Board.getInstance().getChessmanAt(x, (int) (chessman.getY() - (chessman.getX() - x))) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt(x, (int) (chessman.getY() - (chessman.getX() - x))).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt(x, (int) (chessman.getY() - (chessman.getX() - x))).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case NORTHWEST:
                    for (int y = (int) chessman.getY() + 1; y <= tile.getY(); y++) {
                        if (Board.getInstance().getChessmanAt((int) (chessman.getY() + (chessman.getX() - y)), y) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt((int) (chessman.getY() + (chessman.getX() - y)), y).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt((int) (chessman.getY() + (chessman.getX() - y)), y).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case SOUTHEAST:
                    for (int x = (int) chessman.getX() + 1; x <= tile.getX(); x++) {
                        if (Board.getInstance().getChessmanAt(x, (int) (chessman.getY() + (chessman.getX() - x))) != null) {
                            if (highlightAttack && Board.getInstance().getChessmanAt(x, (int) (chessman.getY() + (chessman.getX() - x))).getChessmanColor() != chessman.getChessmanColor()) {
                                Board.getInstance().getTileAt(x, (int) (chessman.getY() + (chessman.getX() - x))).attackable = true;
                                highlightAttackMoves.add(tile);
                            }
                            return;
                        }
                    }
                    break;
                case UNDEFINED:
                    if (Board.getInstance().getChessmanAt((int) tile.getX(), (int) tile.getY()) != null) {
                        if (highlightAttack && Board.getInstance().getChessmanAt((int) tile.getX(), (int) tile.getY()).getChessmanColor() != chessman.getChessmanColor()) {
                            tile.attackable = true;
                            highlightAttackMoves.add(tile);
                        }
                        return;
                    }
                    break;
                default:
                    break;
            }
            for (Tuple t: chessman.getAttackMoves()) {
                if (t.equals(new Tuple((int) (tile.getX() - chessman.getX()), (int) (tile.getY() - chessman.getY())))) {
                    return;
                }
            }
            tile.highlighted = true;
            highlightedTiles.add(tile);
        }
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

    private boolean isKingTile(Tile tileToCheck) {
        Chessman c = Board.getInstance().getChessmanAt((int) tileToCheck.getX(), (int) tileToCheck.getY());
        if (c.getClass().equals(King.class)) {
            return true;
        }
        return false;
    }

    private void populateBoard(){
        switch(Options.GAME_MODE) {
            //Add a new case corresponding to the integer given in options.
            case(0):
                RegularChess game = new RegularChess();
                game.instantiateChessmen();
                game.instantiateRules();
                for(Chessman man: game.getChessmen()){
                    Board.getInstance().addChessman(man);
                }
                break;
            default:
                throw new IllegalStateException("The game mode is not defined");
        }
    }
}
