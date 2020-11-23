package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	public ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int timer;

	// TODO : Constructeur(s)
	public Lane(Game game, int ord, int speed) {
		this.game = game;
		this.ord = ord;
		this.speed = speed;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = game.defaultDensity;
		this.timer = 0;
		for (int j = 0;j < this.density; j++){this.cars.add(new Car(this.game, this.leftToRight, this.ord));}
	}

	public void update() {

		if (this.timer == this.speed){
			for (Car car : cars) {
				car.avanceCar();
				this.timer = 0;
			}
		} else {
			this.timer ++;
		}
		for (Car car : this.cars) {
			car.addToGraphics();
		}
		mayAddCar();

		// TODO

		// Toutes les voitures se déplacent d'une case au bout d'un nombre "tic
		// d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut être ajoutée

	}

	// TODO : ajout de methodes

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
	 */

	/**
	 * Ajoute une voiture au début de la voie avec probabilité égale à la
	 * densité, si la première case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < this.density) {
				this.cars.add(new Car(this.game, getBeforeFirstCase(), this.leftToRight));
			}
		}
	}

	/**
	 * Teste si une case est safe
	 * @param c la case à tester
	 * @return true si elle est safe, false sinon
	 */
	public boolean isSafe(Case c) {
		for (int j = 0; j < this.cars.size(); j++){

			if (this.cars.get(j).comparePosCar(c)){
				return false;
			}
		}
		return true;
	}

	/**
	 * Renvoit la première case de la lane en fonction de leftToRight
	 * @return la première case
	 */
	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	/**
	 * Renvoit la case avant la première case de la lane
	 * @return la case avant la première
	 */
	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
