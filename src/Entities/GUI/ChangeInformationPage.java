package Entities.GUI;

import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChangeInformationPage extends JFrame {
    private User user;
    public ChangeInformationPage(User user) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.user = user;
        setTitle("Change Your Information");
        setSize(650, 300);

        JLabel password_ = new JLabel("New Password: ");
        password_.setHorizontalAlignment(JLabel.CENTER);
        JTextField password = new JTextField();

        JLabel age_ = new JLabel("New Age:");
        age_.setHorizontalAlignment(JLabel.CENTER);
        JTextField age = new JTextField();

        JLabel email_ = new JLabel("New Email:");
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
