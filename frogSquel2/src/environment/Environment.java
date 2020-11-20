package environment;

import java.util.ArrayList;
import java.util.Random;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
    //TODO
    //variables
    private Game game;
    private ArrayList<Lane> lanes = new ArrayList<>();
    private boolean leftToRight;
    private double density;
    //constructor
    public Environment(Game g){
        this.game = g;
        Random r = new Random();
        int i =  r.nextInt(2);
        if(i%2 == 0){this.leftToRight=true;i++;}else{this.leftToRight=false;i++;}
        this.density = r.nextDouble();
    }
    //methods
    /**
     * Teste si une case est sure, c'est � dire que la grenouille peut s'y poser
     * sans mourir
     *
     * @param c
     *            la case � tester
     * @return vrai s'il n'y a pas danger
     */
    public boolean isSafe(Case c){
        return true;
    }

    /**
     * Teste si la case est une case d'arrivee
     *
     * @param c
     * @return vrai si la case est une case de victoire
     */
    public boolean isWinningPosition(Case c){
        return true;
    }

    /**
     * Effectue une �tape d'actualisation de l'environnement
     */
    public void update(){

    }


}
