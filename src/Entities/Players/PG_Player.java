package Entities.Players;

import Entities.IPlayer;

public class PG_Player extends IPlayer {
    final String position = "PG";
    final double pts_weight = 0.3;
    final double trb_weight = 0.1;
    final double ast_weight = 0.4;
    final double blk_weight = 0.1;
    final double stl_weight= 0.1;

    public PG_Player(String name, double pts, double trb, double ast, double blk, double stl){
        super(name,pts,trb,ast,blk,stl);
    }
}
