package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
    private ArrayList<Lane> road;
    private Game game;


    public Environment (Game g){
        this.game = g;
        this.road = new ArrayList<>(this.game.height);
        for (int i = 0; i < road.size(); i++){
            this.road.get(i) = new Lane(this.game,i, speed);
            //je sais pas trop comment faire pour la vitesse
        }
    }


    public boolean isSafe(Case c) {
        for (int i = 0; i < road.size(); i++){
            isSafe(c);
        }
        return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        if (c.ord == this.game.height - 1){
            return true;
        }
        return false;
    }


    public void update() {
        for (int i = 0; i < this.road.size(); i++){
            this.road.get(i).update();
        }
    }



}
