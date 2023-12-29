package Entities.GUI;

import Entities.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TeamViewPage extends JFrame {
    private JButton close;
    private JButton teamName;
    private JButton player1;
    private JButton player2;
    private JButton player3;
    private JButton player4;
    private JButton player5;
    private boolean is1;
    private boolean is2;
    private boolean is3;
    private boolean is4;
    private boolean is5;
    public TeamViewPage(Team team) {
        setVisible(true);
        close = new JButton ("Close");
        close.setFont(new Font("Ariel", Font.PLAIN, 16));
        close.setBackground(new Color(184,184,184));
        teamName = new JButton ("");
        teamName.setFont(new Font("Ariel", Font.BOLD, 16));
        player1 = new JButton ("");
        player1.setFont(new Font("Ariel", Font.PLAIN, 16));
        player2 = new JButton ("");
        player2.setFont(new Font("Ariel", Font.PLAIN, 16));
        player3 = new JButton ("");
        player3.setFont(new Font("Ariel", Font.PLAIN, 16));
        player4 = new JButton ("");
        player4.setFont(new Font("Ariel", Font.PLAIN, 16));
        player5 = new JButton ("");
        player5.setFont(new Font("Ariel", Font.PLAIN, 16));

        setSize(new Dimension(228,430));
        setLayout(null);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        close.setBounds (65, 325, 100, 25);
        teamName.setBounds (15, 20, 195, 30);
        player1.setBounds (15, 70, 195, 30);
        player2.setBounds (15, 120, 195, 30);
        player3.setBounds (15, 170, 195, 30);
        player4.setBounds (15, 220, 195, 30);
        player5.setBounds (15, 270, 195, 30);

        teamName.setBorderPainted(false);
        teamName.setContentAreaFilled(false);
        teamName.setFocusPainted(false);
        teamName.setOpaque(false);

        player1.setBorderPainted(false);
        player1.setContentAreaFilled(false);
        player1.setFocusPainted(false);
        player1.setOpaque(false);

        player2.setBorderPainted(false);
        player2.setContentAreaFilled(false);
        player2.setFocusPainted(false);
        player2.setOpaque(false);

        player3.setBorderPainted(false);
        player3.setContentAreaFilled(false);
        player3.setFocusPainted(false);
        player3.setOpaque(false);

        player4.setBorderPainted(false);
        player4.setContentAreaFilled(false);
        player4.setFocusPainted(false);
        player4.setOpaque(false);

        player5.setBorderPainted(false);
        player5.setContentAreaFilled(false);
        player5.setFocusPainted(false);
        player5.setOpaque(false);

        switch(team.getTeamPlayers().size()) {
            case 0:
                teamName.setText(team.getName());
                break;
            case 1:
                teamName.setText(team.getName());
                player1.setText(team.getTeamPlayers().get(0).getName());
                is1 = true;
                break;
            case 2:
                teamName.setText(team.getName());
                player1.setText(team.getTeamPlayers().get(0).getName());
                player2.setText(team.getTeamPlayers().get(1).getName());
                is1 = true;
                is2 = true;
                break;
            case 3:
                teamName.setText(team.getName());
                player1.setText(team.getTeamPlayers().get(0).getName());
                player2.setText(team.getTeamPlayers().get(1).getName());
                player3.setText(team.getTeamPlayers().get(2).getName());
                is1 = true;
                is2 = true;
                is3 = true;
                break;
            case 4:
                teamName.setText(team.getName());
                player1.setText(team.getTeamPlayers().get(0).getName());
                player2.setText(team.getTeamPlayers().get(1).getName());
                player3.setText(team.getTeamPlayers().get(2).getName());
                player4.setText(team.getTeamPlayers().get(3).getName());
                is1 = true;
                is2 = true;
                is3 = true;
                is4 = true;
                break;
            case 5:
                teamName.setText(team.getName());
                player1.setText(team.getTeamPlayers().get(0).getName());
                player2.setText(team.getTeamPlayers().get(1).getName());
                player3.setText(team.getTeamPlayers().get(2).getName());
                player4.setText(team.getTeamPlayers().get(3).getName());
                player5.setText(team.getTeamPlayers().get(4).getName());
                is1 = true;
                is2 = true;
                is3 = true;
                is4 = true;
                is5 = true;
                break;
        }

        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is1) {
                    new PlayerViewPage(team.getTeamPlayers().get(0));
                }
            }
        });

        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is2) {
                    new PlayerViewPage(team.getTeamPlayers().get(1));
                }
            }
        });

        player3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is3) {
                    new PlayerViewPage(team.getTeamPlayers().get(2));
                }
            }
        });

        player4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is4) {
                    new PlayerViewPage(team.getTeamPlayers().get(3));
                }
            }
        });

        player5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (is5) {
                    new PlayerViewPage(team.getTeamPlayers().get(4));
                }
            }
        });

        add (close);
        add (teamName);
        add (player1);
        add (player2);
        add (player3);
        add (player4);
        add (player5);
    }
}
