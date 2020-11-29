package frog;

import gameCommons.Game;
import util.Case;
import util.Direction;

public class FrogInf extends Frog{
    protected Game game;
    protected Case pos;
    protected Direction dir;

    public FrogInf(Game g){
        super(g);
    }

}
