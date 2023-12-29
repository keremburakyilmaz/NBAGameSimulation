package Entities.GUI;

import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JButton startDraft = new JButton("Start Draft");
        startDraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new DraftingPage(user);
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

        JButton icon = new JButton(new ImageIcon("src\\Pictures\\settings.png"));
        icon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new ChangeInformationPage(user);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                dispose();
            }
        });

        JLabel string = new JLabel("Tap on icon to change your information:");
        logOut.setBounds(35,115,100,25);
        string.setBounds(10,15,245,45);
        startDraft.setBounds(175,115,100,25);
        icon.setBounds(250,10,50,50);
        setLayout(null);
        setSize(320,190);
        add(icon);
        add(string);
        add(logOut);
        add(startDraft);

    }
}
