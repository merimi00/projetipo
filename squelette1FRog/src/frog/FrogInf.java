package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class FrogInf implements IFrog{
    //variables
    protected Game game;
    protected Case pos;
    protected Direction dir;

    //constructor
    public FrogInf(Game game){
        this.dir = Direction.up;
        this.game = game;
        this.pos = new Case((this.game.width/2),0);
    }

    /** methode qui renvoie la position d'une grenouille
     * @param
     * @return Case **/
    public Case getPosition() {return this.pos;}

    /** methode qui renvoie la direction d'une grenouille
     * @param
     * @return Direction **/
    public Direction getDirection() { return this.dir; }

    /** methode qui change la position de la grenouille par rapport à sa direction
     * @param_direction
     * @return  **/
    public void move(Direction key) {
        if (key == Direction.down && this.pos.ord > 0) {
            this.pos = new Case(this.pos.absc, this.pos.ord - 1);
        }
        if (key == Direction.up) {
            this.pos = new Case(this.pos.absc, this.pos.ord + 1);
        }

        if (key == Direction.right && this.pos.absc < this.game.width - 1) {
            this.pos = new Case(this.pos.absc + 1, this.pos.ord);
        }
        if (key == Direction.left && this.pos.absc > 0) {
            this.pos = new Case(this.pos.absc - 1, this.pos.ord);
        }
    }


}
