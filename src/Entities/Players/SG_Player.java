package Entities.Players;

import Entities.IPlayer;

public class SG_Player extends IPlayer {

    public SG_Player(String name, double pts, double trb, double ast, double blk, double stl){
        super(name,pts,trb,ast,blk,stl);
        super.setPosition("SG");
    }
}
