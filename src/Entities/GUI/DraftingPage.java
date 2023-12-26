package Entities.GUI;

import Entities.IPlayer;
import Entities.Players.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DraftingPage extends JFrame {

    private JComboBox jcomp1;
    private JButton select;
    private JLabel team1;
    private JLabel team2;
    private JLabel team3;
    private JLabel team4;
    private JLabel team5;
    private JLabel team6;
    private JLabel team7;
    private JLabel team8;
    private JLabel team9;
    private JLabel team10;
    private JLabel team11;
    private JLabel team12;
    private JLabel team13;
    private JLabel team14;
    private JLabel team15;
    private JLabel team16;
    private JButton startSeason;
    public DraftingPage() throws IOException {

        String[] jcomp1Items = {"Item 1", "Item 2", "Item 3"};
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        setSize (new Dimension(1047, 600));
        setLayout (null);

        setVisible(true);

        String[] player = new String[30];
        ArrayList<IPlayer> players = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader("src\\Logs\\2022-2023-NBA-Player-Stats-Regular.csv"));
        while (fileReader.readLine() != null) {
            player = fileReader.readLine().split(";");
            switch(player[2]){
                case "C":
                    players.add(new C_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                case "PF":
                    players.add(new PF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                case "PG":
                    players.add(new PG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                case "SF":
                    players.add(new SF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                case "SG":
                    players.add(new SG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));

            }
        }

        ArrayList<String> playerNames = new ArrayList<>();
        for(IPlayer iPlayer: players) {
            playerNames.add(iPlayer.getName());
        }

        jcomp1 = new JComboBox (playerNames.toArray());
        select = new JButton ("Select Player");
        team1 = new JLabel ("");
        team2 = new JLabel ("");
        team3 = new JLabel ("");
        team4 = new JLabel ("");
        team5 = new JLabel ("");
        team6 = new JLabel ("");
        team7 = new JLabel ("");
        team8 = new JLabel ("");
        team9 = new JLabel ("");
        team10 = new JLabel ("");
        team11 = new JLabel ("");
        team12 = new JLabel ("");
        team13 = new JLabel ("");
        team14 = new JLabel ("");
        team15 = new JLabel ("");
        team16 = new JLabel ("");
        startSeason = new JButton ("Start Season");

        add (jcomp1);
        add (select);
        add (team1);
        add (team2);
        add (team3);
        add (team4);
        add (team5);
        add (team6);
        add (team7);
        add (team8);
        add (team9);
        add (team10);
        add (team11);
        add (team12);
        add (team13);
        add (team14);
        add (team15);
        add (team16);
        add (startSeason);

        jcomp1.setBounds (65, 435, 625, 30);
        select.setBounds (715, 435, 130, 30);
        team1.setBounds (65, 40, 100, 170);
        team2.setBounds (175, 40, 100, 170);
        team3.setBounds (285, 40, 100, 170);
        team4.setBounds (395, 40, 100, 170);
        team5.setBounds (505, 40, 100, 170);
        team6.setBounds (615, 40, 100, 170);
        team7.setBounds (725, 40, 100, 170);
        team8.setBounds (835, 40, 100, 170);
        team9.setBounds (65, 240, 100, 170);
        team10.setBounds (175, 240, 100, 170);
        team11.setBounds (285, 240, 100, 170);
        team12.setBounds (395, 240, 100, 170);
        team13.setBounds (505, 240, 100, 170);
        team14.setBounds (615, 240, 100, 170);
        team15.setBounds (725, 240, 100, 170);
        team16.setBounds (835, 240, 100, 170);
        startSeason.setBounds (865, 435, 130, 30);
    }

}
