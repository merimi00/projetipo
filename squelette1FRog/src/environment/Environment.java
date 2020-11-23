package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
    private ArrayList<Lane> road = new ArrayList<>(18);
    private Game game;


    public Environment (Game g){
        this.game = g;
        for (int i = 0; i < this.game.height; i++){
            this.road.add(i, new Lane(g, i, ((int) (Math.random() * (10 - this.game.minSpeedInTimerLoops)) + this.game.minSpeedInTimerLoops)));
        }
    }



    public boolean isSafe(Case c) {
        for (int i = 0; i < road.size(); i++){
            if(!road.get(i).isSafe(c)){
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }


    public void update() {
        for (Lane lane : this.road) {
            lane.update();
        }
    }



}
