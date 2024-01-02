package Entities.GUI;

import Entities.User;
import Entities.UserValidator;
import Exceptions.InvalidAgeException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidPasswordException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeInformationPage extends JFrame {
    private User user;
    ArrayList<String[]> data = new ArrayList<>();
    public ChangeInformationPage(User user) throws IOException {
        this.user = user;
        set();

        JLabel password_ = new JLabel("Password: ");
        password_.setFont(new Font("Ariel", Font.PLAIN, 16));
        password_.setHorizontalAlignment(JLabel.CENTER);
        JTextField password = new JTextField();

        JLabel age_ = new JLabel("Age:");
        age_.setFont(new Font("Ariel", Font.PLAIN, 16));
        age_.setHorizontalAlignment(JLabel.CENTER);
        JTextField age = new JTextField();

        JLabel email_ = new JLabel("Email:");
        email_.setFont(new Font("Ariel", Font.PLAIN, 16));
        email_.setHorizontalAlignment(JLabel.CENTER);
        JTextField email = new JTextField();

        JLabel pfp = new JLabel("");
        JButton pfp_ = new JButton("Click here to change your profile picture");
        pfp_.setFont(new Font("Ariel", Font.PLAIN, 10));
        pfp_.setBorderPainted(false);
        pfp_.setContentAreaFilled(false);
        pfp_.setFocusPainted(false);
        pfp_.setOpaque(false);
        pfp_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new ChangeProfilePicture(user);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
            }
        });

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
                    validate(age, password, email);
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i)[0].equals(user.getNickname())) {
                            data.get(i)[5] = age.getText();
                            data.get(i)[1] = password.getText();
                            data.get(i)[4] = email.getText();
                        }
                    }

                    log(file);

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

        add(password_, password, age_, age, email_, email, back, update, pfp, pfp_);
    }

    private void add(JLabel password_, JTextField password, JLabel age_, JTextField age, JLabel email_, JTextField email, JButton back, JButton update, JLabel pfp, JButton pfp_) {
        add(password_);
        add(password);
        add(age_);
        add(age);
        add(email_);
        add(email);
        add(pfp);
        add(pfp_);
        add(back);
        add(update);
    }

    private void set() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(5,2,20,20));
        setTitle("Change Your Information");
        setSize(650, 400);
    }

    private void log(File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String string = "";
        for (int i = 0; i < data.size(); i++) {
            string += (data.get(i)[0] + ";" + data.get(i)[1] + ";" + data.get(i)[2] + ";" + data.get(i)[3] + ";" + data.get(i)[4] + ";" + data.get(i)[5] + ";" + data.get(i)[6] + "\n");
        }

        bufferedWriter.write(string);
        bufferedWriter.close();
    }

    private static void validate(JTextField age, JTextField password, JTextField email) throws InvalidAgeException, InvalidPasswordException, InvalidEmailException {
        UserValidator.validateAge(Integer.parseInt(age.getText()));
        UserValidator.validatePassword(password.getText());
        UserValidator.validateEmail(email.getText());
    }
}
