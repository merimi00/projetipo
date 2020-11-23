package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game game, Case pos, boolean lTR){
		this.leftPosition = pos ;
		this.leftToRight = lTR;
		this.length = game.randomGen.nextInt(4);
		this.game = game;
		addToGraphics();
	}

	public Car (Game game, boolean lTR, int i){
		this.leftToRight = lTR;
		this.game = game;
		int l;
		do {
			l = game.randomGen.nextInt(4);
		} while (l != 0);
		this.length = l;
		Case c;
		do {
			c = new Case(game.randomGen.nextInt(this.game.width), i);
		} while (comparePosCar(c));
		this.leftPosition = c;
		addToGraphics();
	}

	//TODO : ajout de methodes

	/**
	 * Fait avancer un véhicule d'une case en fonction de leftToRight
	 */
	public void avanceCar(){
		if (leftToRight){
			this.leftPosition = new Case(this.leftPosition.absc + 1, this.leftPosition.ord);
		} else {
			this.leftPosition = new Case(this.leftPosition.absc - 1, this.leftPosition.ord);
		}
	}
	/**
	 * Compare une case c avec toutes les cases occupées par le véhicule
	 * @param c la case à comparer
	 * @return true si la case c est occupée par le véhicule, false sinon
	 */
	public boolean comparePosCar(Case c){
		//si on part de droite a gauche
		if(this.leftToRight){
		for (int i = 0; i < this.length; i++){
			if ((this.leftPosition.absc + i) == c.absc && this.leftPosition.ord == c.ord){
				return true;
			}
		}}else{for (int i = 0; i < this.length; i++){
			if ((this.leftPosition.absc - i) == c.absc && this.leftPosition.ord == c.ord){
				return true;
			}
		}}
		return false;
	}


	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	public void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
