package Entities.Players;

import Entities.IPlayer;

public class C_Player extends IPlayer {
    final double pts_weight = 0.2;
    final double trb_weight = 0.3;
    final double ast_weight = 0;
    final double blk_weight = 0.4;
    final double stl_weight= 0.1;

    public C_Player(String name, double pts, double trb, double ast, double blk, double stl){
        super(name,pts,trb,ast,blk,stl);
        super.setPosition("C");
    }

}
