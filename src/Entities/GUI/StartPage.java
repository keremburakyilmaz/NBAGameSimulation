package Entities.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartPage extends JFrame {
    public StartPage() throws IOException {
        setTitle("Start Page");
        JLabel picture = new JLabel(new ImageIcon(ImageIO.read(new File("src\\Pictures\\NBA-StartPage.jpg"))));
        setSize(1000,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton signUp = new JButton("Sign Up");
        signUp.setPreferredSize(new Dimension(200,90));
        signUp.setFont(new Font("Ariel", Font.PLAIN, 16));
        signUp.setBackground(new Color(184,184,184));
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new SignUpPage();
                    }
                });
                dispose();
            }
        });

        JLabel margin = new JLabel("");
        margin.setPreferredSize(new Dimension(200, 90));
        JLabel margin2 = new JLabel("");
        margin2.setPreferredSize(new Dimension(1000, 20));

        JButton logIn = new JButton("Log In");
        logIn.setFont(new Font("Ariel", Font.PLAIN, 16));
        logIn.setPreferredSize(new Dimension(200,90));
        logIn.setBackground(new Color(184,184,184));
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new LogInPage();
                    }
                });
                dispose();
            }
        });

        setLayout(new FlowLayout());
        add(picture);
        add(margin2);
        add(signUp);
        add(margin);
        add(logIn);
        setVisible(true);
    }
}
