package environment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

import util.Case;
import gameCommons.Game;

public class Lane {
	//variables
	protected Game game;
	protected int ord;
	protected int speed;
	protected ArrayList<Car> cars = new ArrayList<>();
	protected boolean leftToRight;
	protected double density;

	//constructors
	public Lane(Game g, int ordonee){
		this.game = g;
		this.ord = ordonee;
		Random r = new Random();
		this.speed = r.nextInt(10)+3;//this.game.minSpeedInTimerLoops);
		this.leftToRight = r.nextBoolean();
		this.density = this.game.defaultDensity;
		int i =0;
		for (double j =0;j<this.density;j+=0.05){
			this.cars.add(new Car(g, this.leftToRight,this.ord));
		}
	}
	public Lane(Game game){
		this.game = game;
		this.ord = 0;
		this.speed = 0;
		this.leftToRight = false;
		this.density = 0;
	}

	//methods
	/** methode qui permet de mettre met à jour l'affichage
	 * @param
	 * @return
	 **/
	int time = 0;
	public void update() {
		if(time == this.speed){
			for (int i = 0; i < this.cars.size(); i++) {
				this.cars.get(i).carMove();}
			time=0;}
		time++;
		this.mayAddCar();
		/**for (Car car : this.cars) {car.addToGraphics();}**/
	}

	/** methode qui s'assure qu'on est sur une Case sans "danger"/voiture
	 * @param_Case
	 * @return boolean
	 **/
	public boolean isSafe(Case position){
		//Case a = new Case(position.absc,position.ord+1);
		for (Car i : this.cars) {
			if(i.lengthPos(position)){
				return false;}
		}
		return true;
	}

	/** methode qui renvoie l'ordonee de cette route
	 * @param
	 * @return int
	 **/
	public int getOrd(){return this.ord;}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilité égale à la
	 * densité, si la première case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())
			&& isSafe(getprobelmeCase()) && isSafe(getprobelme2Case())){
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}
	private Case getprobelme2Case() {
		if (leftToRight) {
			return new Case(2, ord);
		} else
			return new Case(game.width - 3, ord);
	}
	private Case getprobelmeCase() {
		if (leftToRight) {
			return new Case(1, ord);
		} else
			return new Case(game.width - 2, ord);
	}
	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else {
			return new Case(game.width, ord);
		}
	}

}
