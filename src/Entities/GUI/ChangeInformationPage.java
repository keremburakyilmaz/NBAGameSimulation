package Entities.GUI;

import Entities.User;
import Entities.UserValidator;
import Exceptions.InvalidAgeException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidPasswordException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeInformationPage extends JFrame {
    private User user;
    ArrayList<String[]> data = new ArrayList<>();
    public ChangeInformationPage(User user) throws FileNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.user = user;
        setTitle("Change Your Information");
        setSize(650, 300);

        JLabel password_ = new JLabel("Password: ");
        password_.setHorizontalAlignment(JLabel.CENTER);
        JTextField password = new JTextField();

        JLabel age_ = new JLabel("Age:");
        age_.setHorizontalAlignment(JLabel.CENTER);
        JTextField age = new JTextField();

        JLabel email_ = new JLabel("Email:");
        email_.setHorizontalAlignment(JLabel.CENTER);
        JTextField email = new JTextField();

        File file = new File("src\\Logs\\users.txt");
        Scanner reader = new Scanner(file);
        while(reader.hasNext()){
            data.add(reader.nextLine().split(";"));
        }

        JButton back = new JButton("<---- Go back");
        back.setFont(new Font("Ariel", Font.PLAIN, 16));
        back.setBackground(new Color(184,184,184));
        back.setPreferredSize(new Dimension(400,110));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new MainPage(user);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                dispose();
            }
        });

        JButton update = new JButton("Update");
        update.setFont(new Font("Ariel", Font.PLAIN, 16));
        update.setBackground(new Color(184,184,184));
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    UserValidator.validateAge(Integer.parseInt(age.getText()));
                    UserValidator.validatePassword(password.getText());
                    UserValidator.validateEmail(email.getText());
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i)[0] == user.getNickname()) {
                            data.get(i)[5] = age.getText();
                            data.get(i)[1] = password.getText();
                            data.get(i)[4] = email.getText();
                        }
                    }

                    FileWriter writer = new FileWriter(file);
                    for (int i = 0; i < data.size(); i++) {
                        writer.write(data.get(i)[0] + ";" + data.get(i)[1] + ";" + data.get(i)[2] + ";" + data.get(i)[3] + ";" + data.get(i)[4] + ";" + data.get(i)[5] + ";" + data.get(i)[6] + "\n");
                    }

                } catch (InvalidAgeException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Age!");
                } catch (InvalidPasswordException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Password!");
                } catch (InvalidEmailException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Email!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    age.setText("");
                    password.setText("");
                    email.setText("");
                }
            }
        });

        setLayout(new GridLayout(4,2,20,20));
        add(password_);
        add(password);
        add(age_);
        add(age);
        add(email_);
        add(email);
        add(back);
        add(update);
        setVisible(true);
    }
}
