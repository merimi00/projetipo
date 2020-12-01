package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Direction;

import java.util.ArrayList;

public class EnvInf extends Environment {
    //variables

    //constructor
    public EnvInf(Game g){
        super();
        this.game = g;
        this.lanes.add(0,new Lane(g));
        //premiere planche
        for(int i = 1; i<this.game.height-1;i++){
            this.lanes.add( new Lane(this.game, i) );
        }
    }

    //methods
    @Override
    public void update() {
        for (Lane l : lanes) {
            l.update();
        }
        ArrayList<Lane> affiche = new ArrayList<>();
        if (this.game.getFrog().getDirection() == Direction.up) {
            //on cree une nouvelle route tout eh haut
            this.lanes.add(new Lane(this.game, this.lanes.size()));

            for (int i = 0; i < this.game.height; i++) {
                affiche.add(this.lanes.get(this.game.getFrogPos().ord + i ));
                affiche.get(i).ord = i;
                //changer lordonnee de cars
                for (int j = 0; j < affiche.get(i).cars.size(); j++) {
                    affiche.get(i).cars.get(j).leftPosition.ord = i;
                }
            }
        } else if (this.game.getFrog().getDirection() == Direction.down) {
            for (int i = 0; i < this.game.height; i++) {
                affiche.add(this.lanes.get(this.game.getFrogPos().ord + i));
                affiche.get(i).ord = i;
                for (int j = 0; j < affiche.get(i).cars.size(); j++) {
                    affiche.get(i).cars.get(j).leftPosition.ord = i;
                }
            }
            this.game.score ++;
        }


        for (int i = 0; i < affiche.size(); i++){
            for (int j = 0; j < affiche.get(i).cars.size(); j++){
                affiche.get(i).cars.get(j).addToGraphics();
            }
        }


    }

}
