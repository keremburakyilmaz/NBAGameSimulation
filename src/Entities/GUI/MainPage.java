package Entities.GUI;

import Entities.User;
import Exceptions.*;

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
        setVisible(true);

        JButton startDraft = new JButton("Start Draft");
        startDraft.setFont(new Font("Ariel", Font.PLAIN, 16));
        startDraft.setBackground(new Color(184,184,184));
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
                        } catch (InvalidAgeException ex) {
                            throw new RuntimeException(ex);
                        } catch (InvalidNameException ex) {
                            throw new RuntimeException(ex);
                        } catch (AlreadyExistsException ex) {
                            throw new RuntimeException(ex);
                        } catch (InvalidPasswordException ex) {
                            throw new RuntimeException(ex);
                        } catch (InvalidUsernameException ex) {
                            throw new RuntimeException(ex);
                        } catch (InvalidEmailException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                dispose();
            }
        });
        JButton logOut = new JButton("Log Out");
        logOut.setFont(new Font("Ariel", Font.PLAIN, 16));
        logOut.setBackground(new Color(184,184,184));
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
        icon.setBackground(new Color(184,184,184));
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
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                dispose();
            }
        });

        JLabel string = new JLabel("Tap on icon to change your information:");
        string.setFont(new Font("Ariel", Font.PLAIN, 16));
        logOut.setBounds(20,115,130,25);
        string.setBounds(10,15,345,45);
        startDraft.setBounds(225,115,130,25);
        icon.setBounds(300,10,50,50);
        setLayout(null);
        setSize(380,190);
        add(icon);
        add(string);
        add(logOut);
        add(startDraft);

    }
}
