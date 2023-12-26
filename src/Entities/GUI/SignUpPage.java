package Entities.GUI;

import Entities.User;
import Exceptions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUpPage extends JFrame {
    public SignUpPage() {
        setTitle("Sign Up Page");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel username_ = new JLabel("Username: ");
        username_.setHorizontalAlignment(JLabel.CENTER);
        JTextField username = new JTextField();

        JLabel password_ = new JLabel("Password: ");
        password_.setHorizontalAlignment(JLabel.CENTER);
        JTextField password = new JPasswordField();

        JLabel name_ = new JLabel("Name:");
        name_.setHorizontalAlignment(JLabel.CENTER);
        JTextField name = new JTextField();

        JLabel surname_ = new JLabel("Surname:");
        surname_.setHorizontalAlignment(JLabel.CENTER);
        JTextField surname = new JTextField();

        JLabel age_ = new JLabel("Age:");
        age_.setHorizontalAlignment(JLabel.CENTER);
        JTextField age = new JTextField();

        JLabel email_ = new JLabel("Email:");
        email_.setHorizontalAlignment(JLabel.CENTER);
        JTextField email = new JTextField();

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

        JButton signUp = new JButton("Sign Up");
        signUp.setPreferredSize(new Dimension(400,110));
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User(username.getText(), password.getText(), name.getText(), surname.getText(), email.getText(), Integer.parseInt(age.getText()), "src\\Pictures\\ProfilePictures\\pfp-1.png");
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new MainPage(user);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InvalidUsernameException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Username!");
                } catch (InvalidAgeException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Age!");
                } catch (InvalidPasswordException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Password!");
                } catch (InvalidNameException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Name!");
                } catch (InvalidEmailException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Email!");
                } catch (AlreadyExistsException ex) {
                    JOptionPane.showMessageDialog(null, "This account already exists!");
                } finally {
                    username.setText("");
                    password.setText("");
                    name.setText("");
                    surname.setText("");
                    email.setText("");
                    age.setText("");
                }
            }
        });

        setLayout(new GridLayout(7,2,30,30));
        add(username_);
        add(username);
        add(password_);
        add(password);
        add(name_);
        add(name);
        add(surname_);
        add(surname);
        add(age_);
        add(age);
        add(email_);
        add(email);
        add(back);
        add(signUp);
        setVisible(true);
    }
}
