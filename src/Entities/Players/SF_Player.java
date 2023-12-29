package Entities.Players;

import Entities.IPlayer;

public class SF_Player extends IPlayer {

    public SF_Player(String name, double pts, double trb, double ast, double blk, double stl){
        super(name,pts,trb,ast,blk,stl);
        super.setPosition("SF");
    }

}
