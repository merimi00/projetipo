package gameCommons;

import java.awt.Color;
import java.util.Random;

import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import util.Case;
import util.Direction;

public class Game {

	public final Random randomGen = new Random();
	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;
	public int score;

	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;

	/**
	 *
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;
		this.score = 0;
	}

	/**
	 * Lie l'objet frog � la partie
	 *
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}
	public Case getFrogPos(){return this.frog.getPosition();}
	public Direction getFrogDir(){return this.frog.getDirection();}
	public IFrog getFrog(){return this.frog;}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 *
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue
	 * et lance un �cran de fin appropri� si tel est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		if (!environment.isSafe(frog.getPosition())) {
			graphic.endGameScreen("Défaite, votre score: " + this.score );
			return true;
		}
		return this.environment.isSafe(this.frog.getPosition());
	}

	/**
	 * Teste si la partie est gagnee
	 * et lance un �cran de fin appropri� si tel est le cas
	 *
	 * @return true si la partie est gagn�e

	public boolean testWin() {
	if (environment.isWinningPosition(frog.getPosition() )){
	graphic.endGameScreen("Victory");
	return true;
	}
	return this.environment.isWinningPosition(this.frog.getPosition());

	}*/

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(this.frog.getPosition().absc, 0, Color.GREEN));
		testLose();
		//testWin();
	}

}
