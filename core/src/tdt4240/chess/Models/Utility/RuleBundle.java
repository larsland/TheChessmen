package tdt4240.chess.Models.Utility;

import java.util.ArrayList;

import tdt4240.chess.Models.Chessman;

/**
 * Created by Fredrik on 17/04/16.
 */
public interface RuleBundle {

    void instantiateChessmen();
    void instantiateRules();
    ArrayList<Chessman> getChessmen();
}
