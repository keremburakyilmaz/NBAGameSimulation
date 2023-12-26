package Entities;

import java.util.ArrayList;

public class Team implements IEntity{
    private ArrayList<IPlayer> teamPlayers;
    private final String name;
    private final String imagePath;

    public Team(ArrayList<IPlayer> teamPlayers, String name, String imagePath){
        this.teamPlayers = teamPlayers;
        this.name = name;
        this.imagePath = imagePath;
    }
}
