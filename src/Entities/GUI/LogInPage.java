package Entities.GUI;

import Entities.User;
import Exceptions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LogInPage extends JFrame {
    public LogInPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Log In Page");
        setSize(800,300);

        JLabel username_ = new JLabel("Username: ");
        username_.setHorizontalAlignment(JLabel.CENTER);
        JTextField username = new JTextField();

        JLabel password_ = new JLabel("Password: ");
        password_.setHorizontalAlignment(JLabel.CENTER);
        JTextField password = new JPasswordField();

        JButton back = new JButton("<---- Go back");
        back.setPreferredSize(new Dimension(400,110));
        back.addActionListener(new ActionListener() {
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

        JButton logIn = new JButton("Log In");
        back.setPreferredSize(new Dimension(400,110));
        logIn.addActionListener(new ActionListener() {
            @SuppressWarnings("resource")
			@Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src\\Logs\\users.txt");
                Scanner reader;
                try {
                    reader = new Scanner(file);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                while(reader.hasNext()){
                    String[] data = reader.nextLine().split(";");
                    if (data[0].equals(username.getText().strip()) && data[1].equals(password.getText().strip())){
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    new MainPage(new User(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), data[6]));
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
                    } else {
                        JOptionPane.showMessageDialog(null, "No Such User!");
                        username.setText("");
                        password.setText("");
                    }
                }
            }
        });

        setLayout(new GridLayout(3,2,20,20));
        add(username_);
        add(username);
        add(password_);
        add(password);
        add(back);
        add(logIn);

        setVisible(true);
    }
}
