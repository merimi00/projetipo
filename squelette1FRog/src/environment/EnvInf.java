package environment;

import gameCommons.Game;
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
        /**
         for(int i = 1; i<this.game.height-1;i++){
         if(this.isSafe(this.game.getFrogPos())){
         this.lanes.remove(i);
         this.lanes.add(i,new Lane(this.game, i++));
         //decaler this.lanes.get(i)=this.lanes.get(i--);
         }}**/
        /** //on rajoute au fur et a mesure
         int comp = this.game.height-1;
         if(isSafe(this.game.getFrog())){
         this.lanes.add( new Lane(this.game, comp) );
         comp++;
         }**/

        if(this.game.getFrogDir() == Direction.up){
            
        }
    }

    public void update() {
        ArrayList<Lane> affiche = new ArrayList<>();
        if (this.game.getFrog().getDirection() == Direction.up) {
            this.lanes.add(new Lane(this.game, this.lanes.size()));
            for (int i = 0; i < this.game.height; i++) {
                affiche.add(this.lanes.get(this.game.getFrogPos().ord + i ));
                affiche.get(i).ord = i;
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
        }
        for (Lane l : lanes) {
            l.update();
        }
        for (int i = 0; i < affiche.size(); i++){
            affiche.get(i).update();
            for (int j = 0; j < affiche.get(i).cars.size(); j++){
                affiche.get(i).cars.get(j).addToGraphics();
            }
        }
    }




}
