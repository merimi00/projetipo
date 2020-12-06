package gameCommons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import environment.Environment;
import frog.Frog;
import frog.FrogInf;
import graphicalElements.IFroggerGraphics;
import graphicalElements.FroggerGraphic;
import environment.EnvInf;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Caractéristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = 100;
		int minSpeedInTimerLoops = 3;
		double defaultDensity = 0.01;
		final int modeJeu;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez 1 pour une jeu normal et 2 pour un jeu infini: ");
		modeJeu = sc.nextInt();

		
		//Création de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Création de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);

		IFrog frog;
		IEnvironment env;
		if (modeJeu == 1){
			frog = new Frog(game);
			env = new Environment(game);
		} else {
			 frog = new FrogInf(game);
			 env = new EnvInf(game);
		}
		//Création et liason de la grenouille
		game.setFrog(frog);
		graphic.setFrog(frog);
		//Création et liaison de l'environnement
		//IEnvironment env = new GivenEnvironment(game);
		//IEnvironment env = new Environment(game);
		game.setEnvironment(env);
		game.tim();
				
		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (modeJeu == 1){
					game.update();

				}
				if (modeJeu == 2){
					game.updateInf();
				}
				graphic.repaint();
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
