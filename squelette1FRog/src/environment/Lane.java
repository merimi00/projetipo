package environment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

import util.Case;
import gameCommons.Game;

public class Lane {
	protected Game game;
	protected int ord;
	protected int speed;
	protected ArrayList<Car> cars = new ArrayList<>();
	protected boolean leftToRight;
	protected double density;

	// TODO : Constructeur(s)
	//game, sens, vitesse, numero de route,
	//changer pour mayadd car
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
	/*public Lane(Game g, int ordonee, boolean a){
		this.game = g;
		this.ord = ordonee;
		Random r = new Random();
		this.speed = r.nextInt(10);//this.game.minSpeedInTimerLoops);
		this.leftToRight = r.nextBoolean();
	}*/
	int time = 0;
	public void update() {
		// TODO
		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge
		// Les voitures doivent etre ajoutes a l interface graphique meme quand elle ne bougent pas
		// A chaque tic d'horloge, une voiture peut etre ajoutée
		/*int i = 0;
		Timer timer = new Timer(this.speed,new ActionListener(){
			@Override
			public void actionPerformed(ActionEven;t e) {game.getGraphic().add(cars.get(i));i++;}});
		timer.start();
		//this.game.getGraphic().add(this.cars[i])
		mayAddCar();*/

		if(time == this.speed){
			for (int i = 0; i < this.cars.size(); i++) {
				this.cars.get(i).carMove();}
			time=0;}
		time++;
		this.mayAddCar();
		//for (Car car : this.cars) {
			//car.addToGraphics();
		//}
	}

	// TODO : ajout de methodes
	public boolean isSafe(Case position){
		//Case a = new Case(position.absc,position.ord+1);
		for (Car i : this.cars) {
			if(i.lengthPos(position)){return false;}
		}
		return true;
	}

	public int getOrd(){return this.ord;}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())
			/*&& isSafe(getprobelmeCase()) && isSafe(getprobelme2Case())*/){
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}
	/*private Case getprobelme2Case() {
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
	}*/
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
