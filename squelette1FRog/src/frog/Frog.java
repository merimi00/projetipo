package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	protected Game game;
	protected Case pos;
	protected Direction dir;

	public Frog(Game game){
		this.dir = Direction.up;
		this.game = game;
		this.pos = new Case((this.game.width/2),0);
	}
	public Case getPosition() {return this.pos;}
	public Direction getDirection() {
		return this.dir;
	}

	public void move(Direction key) {
		if (key == Direction.down && this.pos.ord > 0) {
			this.pos = new Case(this.pos.absc, this.pos.ord - 1);
		}
		if (key == Direction.up && this.pos.ord < this.game.height - 1) {
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
