package Entities.Players;

import Entities.IPlayer;

public class PF_Player extends IPlayer {
    final String position = "PF";
    final double pts_weight = 0.3;
    final double trb_weight = 0.3;
    final double ast_weight = 0.1;
    final double blk_weight = 0.2;
    final double stl_weight= 0.1;

    public PF_Player(String name, double pts, double trb, double ast, double blk, double stl){
        super(name,pts,trb,ast,blk,stl);
    }
}
