package Entities.Players;

import Entities.IPlayer;

public class SF_Player extends IPlayer {
    final String position = "SF";
    final double pts_weight = 0.2;
    final double trb_weight = 0.2;
    final double ast_weight = 0.15;
    final double blk_weight = 0.2;
    final double stl_weight= 0.25;

    public SF_Player(String name, double pts, double trb, double ast, double blk, double stl){
        super(name,pts,trb,ast,blk,stl);
    }
}
