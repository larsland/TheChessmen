package tdt4240.chess;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import org.junit.Test;
import org.junit.runner.RunWith;

import tdt4240.chess.Controllers.BoardController;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.ChessmanColor;
import tdt4240.chess.Models.Tile;

import static org.junit.Assert.assertTrue;

/**
 * Created by iver on 17/04/16.
 */

@RunWith(GdxTestRunner.class)
public class BoardControllerTest {

    /*
    Run a simple game that results in check mate. Assert that game is won.
    Source of game moves: https://www.chess.com/forum/view/fun-with-chess/shortest-games-possible
     */

    @Test
    public void boardController_CheckMateTest() {
        Board board = new Board();
        BoardController boardController = board.getController();

        InputEvent touchEvent = new InputEvent();
        Actor actor = new Actor();
        touchEvent.setTarget(actor);
        actor.setX(4);
        actor.setY(6);
        boardController.clicked(touchEvent, 4, 6);
        actor.setX(4);
        actor.setY(4);
        boardController.clicked(touchEvent, 4, 4);
        actor.setX(4);
        actor.setY(1);
        boardController.clicked(touchEvent, 4, 1);
        actor.setX(4);
        actor.setY(3);
        boardController.clicked(touchEvent, 4, 3);
        actor.setX(5);
        actor.setY(7);
        boardController.clicked(touchEvent, 5, 7);
        actor.setX(2);
        actor.setY(4);
        boardController.clicked(touchEvent, 2, 4);
        actor.setX(5);
        actor.setY(0);
        boardController.clicked(touchEvent, 5, 0);
        actor.setX(2);
        actor.setY(3);
        boardController.clicked(touchEvent, 2, 3);
        actor.setX(3);
        actor.setY(7);
        boardController.clicked(touchEvent, 3, 7);
        actor.setX(7);
        actor.setY(3);
        boardController.clicked(touchEvent, 7, 3);
        actor.setX(6);
        actor.setY(0);
        boardController.clicked(touchEvent, 6, 0);
        actor.setX(5);
        actor.setY(2);
        boardController.clicked(touchEvent, 5, 2);
        actor.setX(7);
        actor.setY(3);
        boardController.clicked(touchEvent, 7, 3);
        actor.setX(5);
        actor.setY(1);
        boardController.clicked(touchEvent, 5, 1);

        assertTrue(board.getWin() == ChessmanColor.WHITE);
    }

}
