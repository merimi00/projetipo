package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {

    //variables
    protected Game game;
    protected ArrayList<Lane> lanes = new ArrayList<>();

    //constructor
    public Environment(Game g){
        this.game = g;
        this.lanes.add(0,new Lane(g));
        for(int i = 1; i<this.game.height-1;i++){
            this.lanes.add( new Lane(this.game, i) );}
        this.lanes.add(this.game.height-1,new Lane(g));
    }
    public Environment(){
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
        //Case a = new Case(c.absc,c.ord+1);
        return this.lanes.get(c.ord).isSafe(c);
    }

    /**
     * Teste si la case est une case d'arrivee
     *
     * @param c
     * @return vrai si la case est une case de victoire
     */
    //public boolean isWinningPosition(Case c){
       // if(c.ord == this.game.height-1){return true;}
       // return false;
    //}

    /**
     * Effectue une �tape d'actualisation de l'environnement
     */
    public void update(){
       for (Lane l : lanes){
           l.update();
       }
    }

}
