package Entities;

import java.util.ArrayList;
import java.util.Random;

public class Team implements IEntity{
    private ArrayList<IPlayer> teamPlayers = new ArrayList<>();
    private final String name;
    private final String imagePath;
    private int wins = 0;
    private int losses = 0;
    final private int n = 1;

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

    public double calculateScore(){
        double score = 0;
        for (IPlayer player: getTeamPlayers()){
            if (player.getPts() - n < 0) {
                score += (new Random().nextDouble(0, (player.getPts() + n))) * player.getWeightedPts();
            } else {
                score += (new Random().nextDouble((player.getPts() - n), (player.getPts() + n))) * player.getWeightedPts();
            }

            if (player.getTrb() - n < 0) {
                score += (new Random().nextDouble(0, (player.getTrb() + n))) * player.getWeightedTrb();
            } else {
                score += (new Random().nextDouble((player.getTrb() - n), (player.getTrb() + n))) * player.getWeightedTrb();
            }

            if (player.getAst() - n < 0) {
                score += (new Random().nextDouble(0, (player.getAst() + n))) * player.getWeightedAst();
            } else {
                score += (new Random().nextDouble((player.getAst() - n), (player.getAst() + n))) * player.getWeightedAst();
            }

            if (player.getBlk() - n < 0) {
                score += (new Random().nextDouble(0, (player.getBlk() + n))) * player.getWeightedBlk();
            } else {
                score += (new Random().nextDouble((player.getBlk() - n), (player.getBlk() + n))) * player.getWeightedBlk();
            }

            if (player.getStl() - n < 0) {
                score += (new Random().nextDouble(0, (player.getStl() + n))) * player.getWeightedStl();
            } else {
                score += (new Random().nextDouble((player.getStl() - n), (player.getStl() + n))) * player.getWeightedStl();
            }
        }
        return score;
    }
}
