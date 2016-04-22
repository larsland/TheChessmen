package tdt4240.chess.Models.Chessmen;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Utility.StateContext;
import tdt4240.chess.Models.Utility.States.RifleState;

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
