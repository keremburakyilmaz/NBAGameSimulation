package Entities.GUI;

import Entities.IPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerViewPage extends JFrame {
    private JButton close;
    private JLabel playerName;
    private JLabel pts;
    private JLabel trb;
    private JLabel ast;
    private JLabel blk;
    private JLabel stl;
    private IPlayer player;
    public PlayerViewPage(IPlayer player) {
        this.player = player;
        setSize(new Dimension(228,420));
        setLayout(null);
        setVisible(true);

        close = new JButton ("Close");
        close.setFont(new Font("Ariel", Font.PLAIN, 16));
        close.setBackground(new Color(184,184,184));
        playerName = new JLabel(player.getName());
        playerName.setFont(new Font("Ariel", Font.BOLD, 16));
        pts = new JLabel("Points: " + player.getPts() + ", Weight: " + player.getWeightedPts());
        pts.setFont(new Font("Ariel", Font.PLAIN, 16));
        trb = new JLabel("Rebounds: " + player.getTrb() + ", Weight: " + player.getWeightedTrb());
        trb.setFont(new Font("Ariel", Font.PLAIN, 16));
        ast = new JLabel("Assists: " + player.getAst() + ", Weight: " + player.getWeightedAst());
        ast.setFont(new Font("Ariel", Font.PLAIN, 16));
        blk = new JLabel("Blocks: " + player.getBlk() + ", Weight: " + player.getWeightedBlk());
        blk.setFont(new Font("Ariel", Font.PLAIN, 16));
        stl = new JLabel("Steals: " + player.getStl() + ", Weight: " + player.getWeightedStl());
        stl.setFont(new Font("Ariel", Font.PLAIN, 16));

        close.setBounds (65, 325, 100, 25);
        playerName.setBounds (15, 20, 195, 30);
        pts.setBounds (15, 70, 195, 30);
        trb.setBounds (15, 120, 195, 30);
        ast.setBounds (15, 170, 195, 30);
        blk.setBounds (15, 220, 195, 30);
        stl.setBounds (15, 270, 195, 30);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add (close);
        add (playerName);
        add (pts);
        add (trb);
        add (ast);
        add (blk);
        add (stl);
    }
}
