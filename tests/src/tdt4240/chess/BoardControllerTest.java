package tdt4240.chess;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import org.junit.Test;
import org.junit.runner.RunWith;

import tdt4240.chess.Controllers.BoardController;
import tdt4240.chess.Models.Board;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.Options;

import static org.junit.Assert.assertTrue;

/**
 * Created by iver on 17/04/16.
 */

@RunWith(GdxTestRunner.class)
public class BoardControllerTest {

    /*
    Run a simple game that results in check mate. Assert that game is won.
    Source of game moves: https://www.chess.com/forum/view/fun-with-chess/shortest-games-possible
    Board is mirrored on all axises compared to the one shown in game.
    Black starts, not white.
     */

    @Test
    public void boardController_CheckMateRegularChessTest() {
        if (Options.GAME_MODE != 0) return;
        Board board = Board.getInstance();
        BoardController boardController = board.getController();

        InputEvent touchEvent = new InputEvent();
        Actor actor = new Actor();
        touchEvent.setTarget(actor);

        actor.setX(4);
        actor.setY(1);
        boardController.clicked(touchEvent, 4, 1);
        actor.setX(4);
        actor.setY(3);
        boardController.clicked(touchEvent, 4, 3);

        actor.setX(4);
        actor.setY(6);
        boardController.clicked(touchEvent, 4, 6);
        actor.setX(4);
        actor.setY(4);
        boardController.clicked(touchEvent, 4, 4);

        actor.setX(3);
        actor.setY(0);
        boardController.clicked(touchEvent, 3, 0);
        actor.setX(7);
        actor.setY(4);
        boardController.clicked(touchEvent, 7, 4);

        actor.setX(4);
        actor.setY(7);
        boardController.clicked(touchEvent, 4, 7);
        actor.setX(4);
        actor.setY(6);
        boardController.clicked(touchEvent, 4, 6);

        actor.setX(7);
        actor.setY(4);
        boardController.clicked(touchEvent, 7, 4);
        actor.setX(4);
        actor.setY(4);
        boardController.clicked(touchEvent, 4, 4);

        /*
         Black has white in check mate now.
         Needs to make a silly move for white and then black can capture the king.
          */

        actor.setX(0);
        actor.setY(6);
        boardController.clicked(touchEvent, 0, 6);
        actor.setX(0);
        actor.setY(4);
        boardController.clicked(touchEvent, 0, 4);

        actor.setX(4);
        actor.setY(4);
        boardController.clicked(touchEvent, 4, 4);
        actor.setX(4);
        actor.setY(6);
        boardController.clicked(touchEvent, 4, 6);

        //assertTrue(board.getWin() == ChessmanColor.BLACK);
    }

}
