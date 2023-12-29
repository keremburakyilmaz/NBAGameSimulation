package Entities.GUI;

import Entities.IPlayer;
import Entities.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class SeasonMatchPage extends JFrame {
    final int n = 1;
    private JList teamsList;
    private JButton pause;
    private JButton startSeason;
    private JButton viewTeam;

    boolean isEnded = false;
    boolean isPaused = false;
    ArrayList<Team> teams;
    ArrayList<Double> scores = new ArrayList<>();
    public SeasonMatchPage(ArrayList<Team> teams){
        this.teams = teams;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Season Matches!");
        setSize (new Dimension(651, 850));
        setLayout (null);

        DefaultListModel<String> seasonMatchList = new DefaultListModel<>();
        teamsList = new JList(seasonMatchList);
        teamsList.setCellRenderer(new CustomCellRenderer());
        pause = new JButton ("Pause");
        startSeason = new JButton ("Start Season");
        viewTeam = new JButton ("View Your Team");

        for (Team team: teams) {
            double score = 0;
            for (IPlayer player: team.getTeamPlayers()){
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

            scores.add(score);
        }
        System.out.println(scores);



        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPaused) {
                    pause.setText("Pause");
                    isPaused = false;
                } else {
                    pause.setText("Continue");
                    isPaused = true;
                }
            }
        });

        viewTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(teams.get(0));
                    }
                });
            }
        });

        startSeason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    for (int i = 0; i < 16; i++) {
                        for (int j = i + 1; j < 16; j++) {
                            updateList(seasonMatchList);
                            if (scores.get(i) * 1.05 >= scores.get(j)){
                                teams.get(i).won();
                                teams.get(j).lost();
                            } else {
                                teams.get(j).won();
                                teams.get(i).lost();
                            }
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            updateList(seasonMatchList);
                            if (scores.get(j) * 1.05 >= scores.get(i)){
                                teams.get(j).won();
                                teams.get(i).lost();
                            } else {
                                teams.get(i).won();
                                teams.get(j).lost();
                            }
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            updateList(seasonMatchList);
                        }
                    }
                }).start();
            }
        });

        teamsList.setBounds (0, 0, 670, 710);
        pause.setBounds (55, 740, 140, 35);
        startSeason.setBounds (250, 740, 140, 35);
        viewTeam.setBounds (445, 740, 140, 35);

        add (teamsList);
        add (pause);
        add (startSeason);
        add (viewTeam);
        setVisible(true);
    }

    private void updateList(DefaultListModel<String> seasonMatchList){
        seasonMatchList.clear();
        for(Team team: teams) {
            seasonMatchList.addElement(team.getName() + ", Wins: " + team.getWins() + ", Losses: " + team.getLosses());
        }
    }
}
