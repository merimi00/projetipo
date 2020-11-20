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
	public Car(Game game, boolean sens){
		this.game = game;
		this.leftPosition = new Case(0,0);
		this.leftToRight = sens;
		Random r = new Random();
		this.length =  r.nextInt( 4);

	}
	public Car(Game game, int len, boolean sens){
		this.game = game;
		this.leftPosition = new Case(0,0);
		this.leftToRight = sens;
		this.length = len;
	}
	public Car(Game game, Case c, boolean sens){
		this.game = game;
		this.leftPosition = c;
		this.leftToRight = sens;
		Random r = new Random();
		this.length =  r.nextInt( 4);

	}

	//TODO : ajout de methodes
	public Case carMove(Case c){
		return this.leftPosition = c;
	}
	public Case carMove(){
		if(this.leftToRight){
			return this.leftPosition = new Case(this.leftPosition.absc+1,this.leftPosition.ord);
		}else{return this.leftPosition = new Case(this.leftPosition.absc -1,this.leftPosition.ord);}
	}



	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
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
