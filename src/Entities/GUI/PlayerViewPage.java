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
        playerName = new JLabel(player.getName());
        pts = new JLabel("Points: " + player.getPts() + ", Weight: " + player.getWeightedPts());
        trb = new JLabel("Rebounds: " + player.getTrb() + ", Weight: " + player.getWeightedTrb());
        ast = new JLabel("Assists: " + player.getAst() + ", Weight: " + player.getWeightedAst());
        blk = new JLabel("Blocks: " + player.getBlk() + ", Weight: " + player.getWeightedBlk());
        stl = new JLabel("Steals: " + player.getStl() + ", Weight: " + player.getWeightedStl());

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
