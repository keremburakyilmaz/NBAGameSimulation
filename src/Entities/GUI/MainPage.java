package Entities.GUI;

import Entities.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainPage extends JFrame {
    private User user;
    public MainPage(User user) throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.user = user;
        setTitle("Main Page");
        setSize(650, 300);
        setVisible(true);
        ImageIcon pfp = new ImageIcon("src\\Pictures\\ProfilePictures\\pfp-1.png");
        JButton pfpButton = new JButton(pfp);
        pfpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new ChangeInformationPage(user);
                    }
                });
                dispose();
            }
        });

        JButton startDraft = new JButton("Start drafting");
        startDraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new DraftingPage();
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                dispose();
            }
        });
        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new StartPage();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                dispose();
            }
        });

        setLayout(new GridLayout(2,2,30,30));
        add(new JLabel("To change your information, click on your profile picture:"));
        add(pfpButton);
        add(logOut);
        add(startDraft);

    }
}
