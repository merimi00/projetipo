package environment;

import environment.Environment;
import environment.Lane;
import gameCommons.Game;
import util.Direction;

public class EnvInf extends Environment {
    //variables
    //hsizeuinzzefpp
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
           for(int i = 1; i<this.game.height-1;i++){
               if(this.isSafe(this.game.getFrogPos())){
                   this.lanes.remove(i);
                   this.lanes.add(i,new Lane(this.game, i++));
                   //decaler this.lanes.get(i)=this.lanes.get(i--);
               }
           }
       }
    }




}
