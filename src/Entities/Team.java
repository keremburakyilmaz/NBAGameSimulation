package Entities;

import java.util.ArrayList;

public class Team implements IEntity{
    private ArrayList<IPlayer> teamPlayers = new ArrayList<>();
    private final String name;
    private final String imagePath;
    private int wins = 0;
    private int losses = 0;

    public Team(String name, String imagePath){
        this.name = name;
        this.imagePath = imagePath;
    }

    public ArrayList<IPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(ArrayList<IPlayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void addPlayer(IPlayer player) {
        getTeamPlayers().add(player);
    }

    public int getWins() {
        return wins;
    }

    public void won() {
        wins++;
    }

    public int getLosses() {
        return losses;
    }

    public void lost() {
        losses++;
    }
}
