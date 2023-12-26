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
        signUp.setPreferredSize(new Dimension(400,110));
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

        JButton logIn = new JButton("Log In");
        logIn.setPreferredSize(new Dimension(400,110));
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
        add(signUp);
        add(logIn);
        setVisible(true);
    }
}
