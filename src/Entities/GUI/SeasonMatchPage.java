package Entities.GUI;

import Entities.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import static java.lang.Thread.sleep;

public class SeasonMatchPage extends JFrame {
    final int n = 1;
    private JList teamsList;
    private JButton pause;
    private JButton startSeason;
    private JButton viewTeam;

    boolean isPaused = false;
    private ArrayList<Team> teams;
    private ArrayList<Team> playOffTeams;
    private ArrayList<Double> scores = new ArrayList<>();
    private String log = "";
    public SeasonMatchPage(ArrayList<Team> teams){
        this.teams = teams;
        this.playOffTeams = new ArrayList<>();
        set();
        DefaultListModel<String> seasonMatchList = new DefaultListModel<>();
        teamsList = new JList(seasonMatchList);
        teamsList.setCellRenderer(new CustomCellRenderer());
        pause = new JButton ("Pause");
        pause.setFont(new Font("Ariel", Font.PLAIN, 16));
        pause.setBackground(new Color(184,184,184));
        startSeason = new JButton ("Start Season");
        startSeason.setFont(new Font("Ariel", Font.PLAIN, 16));
        startSeason.setBackground(new Color(184,184,184));
        viewTeam = new JButton ("View Your Team");
        viewTeam.setFont(new Font("Ariel", Font.PLAIN, 16));
        viewTeam.setBackground(new Color(184,184,184));

        for (Team team: teams) {
            scores.add(team.calculateScore());
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
                    int count = 0;
                    for (int i = 0; i < 16; i++) {
                        for (int j = i + 1; j < 16; j++) {
                            updateList(seasonMatchList);
                            if (scores.get(i) * 1.05 >= scores.get(j)) {
                                teams.get(i).won();
                                teams.get(j).lost();
                                count++;
                                log += "Match #" + count + "- Home: " + teams.get(i).getName() + " Away: " + teams.get(j).getName() + ", Winner: " + teams.get(i).getName() + "\n";
                            } else {
                                teams.get(j).won();
                                teams.get(i).lost();
                                count++;
                                log += "Match #" + count + "- Home: " + teams.get(i).getName() + " Away: " + teams.get(j).getName() + ", Winner: " + teams.get(j).getName() + "\n";
                            }
                            sleep();
                            updateList(seasonMatchList);
                            if (scores.get(j) * 1.05 >= scores.get(i)) {
                                teams.get(j).won();
                                teams.get(i).lost();
                                count++;
                                log += "Match #" + count + "- Home: " + teams.get(j).getName() + " Away: " + teams.get(i).getName() + ", Winner: " + teams.get(j).getName() + "\n";
                            } else {
                                teams.get(i).won();
                                teams.get(j).lost();
                                count++;
                                log += "Match #" + count + "- Home: " + teams.get(j).getName() + " Away: " + teams.get(i).getName() + ", Winner: " + teams.get(i).getName() + "\n";
                            }
                            sleep();
                            updateList(seasonMatchList);

                            while (isPaused) {
                                sleep();
                            }
                        }
                    }

                    log();
                    filterPlayOff(teams);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new PlayOffPage(playOffTeams);
                        }
                    });
                }).start();
            }
        });

        setBounds();

        add();
    }

    private void filterPlayOff(ArrayList<Team> teams) {
        for (int i = 0; i < 8; i++) {
            int maxWin = 0;
            int index = -1;
            for (Team team : teams) {
                if (team.getWins() > maxWin) {
                    maxWin = team.getWins();
                    index = teams.indexOf(team);
                }
            }
            playOffTeams.add(teams.get(index));
            teams.remove(index);
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void set() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Season Matches!");
        setSize (new Dimension(671, 850));
        setLayout (null);
        setVisible(true);
    }

    private void add() {
        add (teamsList);
        add (pause);
        add (startSeason);
        add (viewTeam);
    }

    private void setBounds() {
        teamsList.setBounds (0, 0, 670, 710);
        pause.setBounds (55, 740, 140, 35);
        startSeason.setBounds (250, 740, 140, 35);
        viewTeam.setBounds (445, 740, 160, 35);
    }

    private void log() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(new File("src\\Logs\\SeasonMatches.txt"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        BufferedWriter writer = new BufferedWriter(fileWriter);
        try {
            writer.write(log);
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void updateList(DefaultListModel<String> seasonMatchList){
        seasonMatchList.clear();
        seasonMatchList.addElement("");
        seasonMatchList.addElement("");
        seasonMatchList.addElement("");
        seasonMatchList.addElement("");
        for(Team team: teams) {
            seasonMatchList.addElement(team.getName() + ", Wins: " + team.getWins() + ", Losses: " + team.getLosses());
        }
    }
}
