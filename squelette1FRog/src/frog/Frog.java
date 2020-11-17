package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	private Game game;
	private Case pos;
	private Direction dir;

	//constructeur
	public Frog(){

	}


	/**
	 * Donne la position actuelle de la grenouille
	 * @return
	 */
	public Case getPosition(){
		return this.pos;

	}
	/**
	 * Donne la direction de la grenouille, c'est � dire de son dernier mouvement
	 * @return
	 */
	public Direction getDirection(){
		return this.dir;
	}
	/**
	 * D�place la grenouille dans la direction donn�e et teste la fin de partie
	 * @param key
	 */
	public void move(Direction key){

	}


}
