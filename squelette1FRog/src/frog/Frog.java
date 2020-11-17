package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	private Game game;
	private Case pos;
	private Direction dir;

	public Frog(Game game){
		this.pos = new Case(0,0);
		this.dir = Direction.up;
		this.game = game;
	}

	public Case getPosition() {
		return this.pos;
	}

	public Direction getDirection() {
		return this.dir;
	}

	public void move(Direction key) {
		if (key == Direction.up) {
			if (this.pos.ord < 19) {
				this.pos = new Case(this.pos.absc, this.pos.ord + 1);
			}
		}

		if (key == Direction.down){
			if (this.pos.ord > 0) {
				this.pos = new Case(this.pos.absc, this.pos.ord - 1);
			}
		}
		if (key == Direction.right) {
			if (this.pos.absc < 25) {
				this.pos = new Case(this.pos.absc + 1, this.pos.ord);
			}
		}
		if (key == Direction.left){
			if (this.pos.absc > 0) {
				this.pos = new Case(this.pos.absc - 1, this.pos.ord);
			}
		}



	}


}
