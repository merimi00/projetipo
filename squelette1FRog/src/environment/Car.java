package environment;

import java.awt.Color;
import java.util.Random;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	//variables
	protected Game game;
	protected Case leftPosition;
	protected boolean leftToRight;
	protected int length;
	protected final Color colorLtR = Color.BLACK;
	protected final Color colorRtL = Color.BLUE;

	//constructors
	public Car(Game game, boolean sens, int ordonnee){
		Random r = new Random();
		this.game = game;
		this.leftPosition = new Case(r.nextInt(this.game.width),ordonnee);
		this.leftToRight = sens;
		this.length =  r.nextInt( 4);
		addToGraphics();
	}

	public Car(Game game, Case c, boolean sens){
		this.game = game;
		this.leftPosition = c;
		this.leftToRight = sens;
		Random r = new Random();
		this.length =  r.nextInt( 4);
		addToGraphics();
	}

	//methods
	/**Methode qui permet faire déplacer la voiture sur la route
	 * @param
	 * @return
	 * **/
	public void carMove(){
		if(this.leftToRight){
			this.leftPosition = new Case(this.leftPosition.absc+1,this.leftPosition.ord);
		}else{
			this.leftPosition = new Case(this.leftPosition.absc-1,this.leftPosition.ord);
		}
	}
	/** methode qui renvoie la position d'une voiture
	 * @param
	 * @return Case**/
	public Case getCase(){
		return this.leftPosition;
	}

	/** methode qui renvoie la taille d'une voiture
	 * @param
	 * @return int **/
	public int getLength(){return this.length;}

	/**
	 * renvoie un booleen pour indiquer si la position c est sur une voiture
	 * ou pas considérant sa taille
	 * @param_Case
	 * @return boolean **/
	public boolean lengthPos(Case c){
		if(this.leftToRight) {
			for (int i = 0; i < this.length; i++) {
				if (this.leftPosition.absc - i  == c.absc) {
					return true;
				}
			}
		}else{
			for (int i = 0; i < this.length; i++) {
				if (this.leftPosition.absc + i == c.absc) {
					return true;
				}
			}
		}
		return false;
	}

	/** Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture
	 * @param
	 * @return**/
	public void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic().add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
