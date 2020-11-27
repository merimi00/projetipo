package environment;

import java.awt.Color;
import java.util.Random;

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
	public Car(Game game, boolean sens, int ordonnee){
		Random r = new Random();
		this.game = game;
		this.leftPosition = new Case(r.nextInt(this.game.width),ordonnee);
		this.leftToRight = sens;
		this.length =  r.nextInt( 4);
		addToGraphics();
	}

	/*public Car(Game game, int len, boolean sens){
		this.game = game;
		//
		this.leftPosition = new Case(0,0);
		this.leftToRight = sens;
		this.length = len;
		addToGraphics();
	}*/
	public Car(Game game, Case c, boolean sens){
		this.game = game;
		this.leftPosition = c;
		this.leftToRight = sens;
		Random r = new Random();
		this.length =  r.nextInt( 4);
		addToGraphics();
	}

	//TODO : ajout de methodes
	public Case carMove(Case c){
		return this.leftPosition = c;
	}
	public void carMove(){
		if(this.leftToRight){
			this.leftPosition = new Case(this.leftPosition.absc+1,this.leftPosition.ord);


		}else{
			this.leftPosition = new Case(this.leftPosition.absc-1,this.leftPosition.ord);


		}
	}

	public Case getCase(){
		return this.leftPosition;
	}

	public int getLength(){return this.length;}

	public boolean lengthPos(Case c){
		if(this.leftToRight) {
			for (int i = 0; i < this.length; i++) {
				if (this.leftPosition.absc - i == c.absc) {
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

	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
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
