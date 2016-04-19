package tdt4240.chess.Models.Chessmen;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.StateContext;
import tdt4240.chess.Utility.States.BishopState;
import tdt4240.chess.Utility.States.RifleState;

/**
 * Created by berg on 19/04/16.
 */
public class Rifle extends Chessman {

    public Rifle(int x, int y) {
        super(null);
        this.setBounds(x, y, 1, 1);

        context = new StateContext();
        context.setState(new RifleState(), this);
        context.setMoves(this);

    }
}
