package Entities.GUI;

import Entities.Team;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PlayOffPage extends JFrame {
    private JLabel q1;
    private JLabel q2;
    private JLabel q8;
    private JLabel q3;
    private JLabel q4;
    private JLabel q5;
    private JLabel q6;
    private JLabel q7;
    private JLabel s1;
    private JLabel s2;
    private JLabel s3;
    private JLabel s4;
    private JLabel winner;
    private JLabel f1;
    private JLabel f2;
    private ArrayList<Team> teams;
    private String log = "";
    public PlayOffPage(ArrayList<Team> teams){
        this.teams = teams;
        Collections.shuffle(teams);

        setSize (new Dimension(1494, 500));
        setLayout (null);
        setVisible(true);

        Team qt1 = teams.get(0);
        Team qt2 = teams.get(1);
        Team qt3 = teams.get(2);
        Team qt4 = teams.get(3);
        Team qt5 = teams.get(4);
        Team qt6 = teams.get(5);
        Team qt7 = teams.get(6);
        Team qt8 = teams.get(7);
        Team st1 = (qt1.calculateScore() > qt2.calculateScore()) ? qt1 : qt2;
        log += "Match #1 - " + qt1.getName() + " vs. " + qt2.getName() + ", Winner: " + st1.getName() + "\n";
        Team st2 = (qt3.calculateScore() > qt4.calculateScore()) ? qt3 : qt4;
        log += "Match #2 - " + qt3.getName() + " vs. " + qt4.getName() + ", Winner: " + st2.getName() + "\n";
        Team st3 = (qt5.calculateScore() > qt6.calculateScore()) ? qt5 : qt6;
        log += "Match #3 - " + qt5.getName() + " vs. " + qt6.getName() + ", Winner: " + st3.getName() + "\n";
        Team st4 = (qt7.calculateScore() > qt8.calculateScore()) ? qt7 : qt8;
        log += "Match #4 - " + qt7.getName() + " vs. " + qt8.getName() + ", Winner: " + st4.getName() + "\n";
        Team ft1 = (st1.calculateScore() > st2.calculateScore()) ? st1 : st2;
        log += "Match #5 - " + st1.getName() + " vs. " + st2.getName() + ", Winner: " + ft1.getName() + "\n";
        Team ft2 = (st3.calculateScore() > st4.calculateScore()) ? st3 : st4;
        log += "Match #6 - " + st3.getName() + " vs. " + st4.getName() + ", Winner: " + ft2.getName() + "\n";
        Team wt1 = (ft1.calculateScore() > ft2.calculateScore()) ? ft1 : ft2;
        log += "Match #7 - " + ft1.getName() + " vs. " + ft2.getName() + ", Winner: " + wt1.getName() + "\n";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(new File("src\\Logs\\PlayOffMatches.txt"));
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

        q1 = new JLabel (qt1.getName());
        q2 = new JLabel (qt2.getName());
        q3 = new JLabel (qt3.getName());
        q4 = new JLabel (qt4.getName());
        q5 = new JLabel (qt5.getName());
        q6 = new JLabel (qt6.getName());
        q7 = new JLabel (qt7.getName());
        q8 = new JLabel (qt8.getName());
        s1 = new JLabel (st1.getName());
        s2 = new JLabel (st2.getName());
        s3 = new JLabel (st3.getName());
        s4 = new JLabel (st4.getName());
        f1 = new JLabel (ft1.getName());
        f2 = new JLabel (ft2.getName());
        winner = new JLabel (wt1.getName());

        add (q1);
        add (q2);
        add (q8);
        add (q3);
        add (q4);
        add (q5);
        add (q6);
        add (q7);
        add (s1);
        add (s2);
        add (s3);
        add (s4);
        add (winner);
        add (f1);
        add (f2);

        q1.setBounds (40, 400, 150, 35);
        q2.setBounds (210, 400, 150, 35);
        q8.setBounds (1310, 400, 150, 35);
        q3.setBounds (405, 400, 150, 35);
        q4.setBounds (620, 400, 150, 35);
        q5.setBounds (760, 400, 150, 35);
        q6.setBounds (950, 400, 150, 35);
        q7.setBounds (1115, 400, 150, 35);
        s1.setBounds (90, 270, 150, 35);
        s2.setBounds (535, 270, 150, 35);
        s3.setBounds (845, 270, 150, 35);
        s4.setBounds (1205, 270, 150, 35);
        winner.setBounds (660, 25, 150, 35);
        f1.setBounds (315, 155, 150, 35);
        f2.setBounds (1040, 155, 150, 35);
    }
}
