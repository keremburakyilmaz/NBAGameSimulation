package Entities.GUI;

import Entities.IPlayer;
import Entities.Players.*;
import Entities.Team;
import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class DraftingPage extends JFrame {

    private JComboBox jcomp1;
    private JButton select;
    private JLabel teamLabel1;
    private JLabel teamLabel2;
    private JLabel teamLabel3;
    private JLabel teamLabel4;
    private JLabel teamLabel5;
    private JLabel teamLabel6;
    private JLabel teamLabel7;
    private JLabel teamLabel8;
    private JLabel teamLabel9;
    private JLabel teamLabel10;
    private JLabel teamLabel11;
    private JLabel teamLabel12;
    private JLabel teamLabel13;
    private JLabel teamLabel14;
    private JLabel teamLabel15;
    private JLabel teamLabel16;
    private JButton startSeason;
    private JButton back;
    boolean isC = false;
    boolean isPF = false;
    boolean isPG = false;
    boolean isSF = false;
    boolean isSG = false;
    Set<String> playerNames = new TreeSet<>();

    private int number = 0;
    public DraftingPage(User user) throws IOException {

        String[] jcomp1Items = {"Item 1", "Item 2", "Item 3"};
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        setSize (new Dimension(1980, 600));
        setLayout (null);

        setVisible(true);
        String line;
        String[] player;
        ArrayList<IPlayer> players = new ArrayList<>();
        ArrayList<IPlayer> C_players = new ArrayList<>();
        ArrayList<IPlayer> PF_players = new ArrayList<>();
        ArrayList<IPlayer> PG_players = new ArrayList<>();
        ArrayList<IPlayer> SF_players = new ArrayList<>();
        ArrayList<IPlayer> SG_players = new ArrayList<>();
        Team team1 = new Team("KU Angeles Lakers", null);
        Team team2 = new Team("Boston KUltics", null);;
        Team team3 = new Team("ChicaKU Bulls", null);;
        Team team4 = new Team("Golden KU Warriors", null);;
        Team team5 = new Team("MiaKU Heats", null);;
        Team team6 = new Team("Toronto RaptorKUs", null);;
        Team team7 = new Team("KUladelphia 76ers", null);;
        Team team8 = new Team("WasKUngton Wizards", null);;
        Team team9 = new Team("KUleveland Cavaliers", null);;
        Team team10 = new Team("Houston RocKUts", null);;
        Team team11 = new Team("Atlanta HawKU", null);;
        Team team12 = new Team("KUharlotte Hornets", null);;
        Team team13 = new Team("New Orleans PeliKUns", null);;
        Team team14 = new Team("KU Antonio Spurs", null);;
        Team team15 = new Team("Minnesota TimberKUs", null);;
        Team team16 = new Team("Memphis KUrizzlies", null);;


        BufferedReader fileReader = new BufferedReader(new FileReader("src\\Logs\\2022-2023-NBA-Player-Stats-Regular.csv"));
        while ((line = fileReader.readLine()) != null) {
            player = line.split(";");
             switch(player[2]){
                case "C":
                    C_players.add(new C_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new C_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "PF":
                    PF_players.add(new PF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new PF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "PG":
                    PG_players.add(new PG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new PG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "SF":
                    SF_players.add(new SF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new SF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "SG":
                    SG_players.add(new SG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new SG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
            }
        }


        for(IPlayer iPlayer: C_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: PF_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: PG_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: SF_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: SG_players) {
            playerNames.add(iPlayer.getName());
        }

        jcomp1 = new JComboBox (playerNames.toArray());
        teamLabel1 = new JLabel (team1.getName());
        teamLabel2 = new JLabel (team2.getName());
        teamLabel3 = new JLabel (team3.getName());
        teamLabel4 = new JLabel (team4.getName());
        teamLabel5 = new JLabel (team5.getName());
        teamLabel6 = new JLabel (team6.getName());
        teamLabel7 = new JLabel (team7.getName());
        teamLabel8 = new JLabel (team8.getName());
        teamLabel9 = new JLabel (team9.getName());
        teamLabel10 = new JLabel (team10.getName());
        teamLabel11 = new JLabel (team11.getName());
        teamLabel12 = new JLabel (team12.getName());
        teamLabel13 = new JLabel (team13.getName());
        teamLabel14 = new JLabel (team14.getName());
        teamLabel15 = new JLabel (team15.getName());
        teamLabel16 = new JLabel (team16.getName());
        select = new JButton ("Select Player");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number < 5) {
                    double selectedPts = 0;
                    double selectedTrb = 0;
                    double selectedAst = 0;
                    double selectedBlk = 0;
                    double selectedStl = 0;
                    String selectedPos = "";
                    double count = 0;

                    String selectedPlayerName = jcomp1.getSelectedItem().toString();
                    for(IPlayer selectedPlayer: players) {
                        if (selectedPlayer.getName().matches(selectedPlayerName)){
                            selectedPts += selectedPlayer.getPts();
                            selectedTrb += selectedPlayer.getTrb();
                            selectedAst += selectedPlayer.getAst();
                            selectedBlk += selectedPlayer.getBlk();
                            selectedStl += selectedPlayer.getStl();
                            selectedPos  = selectedPlayer.getPosition();
                            count++;
                        }
                    }
                    switch (selectedPos) {
                        case "C":
                            isC = true;
                            team1.addPlayer(new C_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            break;
                        case "PF":
                            isPF = true;
                            team1.addPlayer(new PF_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            break;
                        case "PG":
                            isPG = true;
                            team1.addPlayer(new PG_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            break;
                        case "SF":
                            isSF = true;
                            team1.addPlayer(new SF_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            break;
                        case "SG":
                            isSG = true;
                            team1.addPlayer(new SG_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            break;

                    }

                    jcomp1.removeAllItems();

                    System.out.println(playerNames);
                    playerNames = new TreeSet<>();

                    if (!isC){
                        for(IPlayer iPlayer: C_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isPF) {
                        for(IPlayer iPlayer: PF_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isPG) {
                        for(IPlayer iPlayer: PG_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isSF) {
                        for(IPlayer iPlayer: SF_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isSG) {
                        for(IPlayer iPlayer: SG_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    for (String string: playerNames){
                        jcomp1.addItem(string);
                    }

                    System.out.println(playerNames);
                    number ++;
                } else {
                    JOptionPane.showMessageDialog(null, "Can only select 5 players!");
                }

            }
        });

        startSeason = new JButton ("Start Season");
        back = new JButton("Go Back");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new MainPage(user);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                dispose();
            }
        });

        add (jcomp1);
        add (select);
        add (teamLabel1);
        add (teamLabel2);
        add (teamLabel3);
        add (teamLabel4);
        add (teamLabel5);
        add (teamLabel6);
        add (teamLabel7);
        add (teamLabel8);
        add (teamLabel9);
        add (teamLabel10);
        add (teamLabel11);
        add (teamLabel12);
        add (teamLabel13);
        add (teamLabel14);
        add (teamLabel15);
        add (teamLabel16);
        add (startSeason);
        add(back);

        jcomp1.setBounds (65, 435, 625, 30);
        select.setBounds (715, 435, 130, 30);
        teamLabel1.setBounds (65, 40, 200, 170);
        teamLabel2.setBounds (275, 40, 200, 170);
        teamLabel3.setBounds (485, 40, 200, 170);
        teamLabel4.setBounds (695, 40, 200, 170);
        teamLabel5.setBounds (905, 40, 200, 170);
        teamLabel6.setBounds (1115, 40, 200, 170);
        teamLabel7.setBounds (1325, 40, 200, 170);
        teamLabel8.setBounds (1535, 40, 200, 170);
        teamLabel9.setBounds (65, 240, 200, 170);
        teamLabel10.setBounds (275, 240, 200, 170);
        teamLabel11.setBounds (485, 240, 200, 170);
        teamLabel12.setBounds (695, 240, 200, 170);
        teamLabel13.setBounds (905, 240, 200, 170);
        teamLabel14.setBounds (1115, 240, 200, 170);
        teamLabel15.setBounds (1325, 240, 200, 170);
        teamLabel16.setBounds (1535, 240, 200, 170);
        startSeason.setBounds (865, 435, 230, 30);
        back.setBounds(65,500,130,30);
    }

}
