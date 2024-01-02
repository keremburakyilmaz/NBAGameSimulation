package Entities.GUI;

import Entities.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeProfilePicture extends JFrame {
    private User user;
    private String newPath;

    public ChangeProfilePicture(User user) throws IOException {
        this.user = user;
        setTitle("Choose Your Profile Picture!");
        setLayout(new GridLayout(4,3,30,30));
        setVisible(true);
        setSize(600,600);

        JButton pfp1 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-1.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp1);

        JButton pfp2 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-2.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp2);

        JButton pfp3 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-3.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp3);

        JButton pfp4 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-4.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp4);

        JButton pfp5 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-5.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp5);

        JButton pfp6 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-6.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp6);

        JButton pfp7 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-7.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp7);

        JButton pfp8 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-8.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp8);

        JButton pfp9 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-9.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp9);

        JButton pfp10 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-10.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp10);

        JButton pfp11 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-11.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp11);

        JButton pfp12 = new JButton(new ImageIcon(ImageIO.read(new File("src\\Pictures\\ProfilePictures\\pfp-12.png")).getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        changeButton(pfp12);

        pfp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-1.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-2.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-3.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-4.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-5.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-6.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-7.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-8.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-9.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-10.png";
                try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-11.png";try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        pfp12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPath = "src\\Pictures\\ProfilePictures\\pfp-12.png";try {
                    overwrite(newPath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Successfully updated profile picture!");
                dispose();
            }
        });

        add(pfp1);
        add(pfp2);
        add(pfp3);
        add(pfp4);
        add(pfp5);
        add(pfp6);
        add(pfp7);
        add(pfp8);
        add(pfp9);
        add(pfp10);
        add(pfp11);
        add(pfp12);
    }

    private void changeButton(JButton pfp){
        pfp.setBorderPainted(false);
        pfp.setContentAreaFilled(false);
        pfp.setFocusPainted(false);
        pfp.setOpaque(false);
    }

    private void overwrite(String newPath) throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        Scanner reader = new Scanner(new File("src\\Logs\\users.txt"));
        while(reader.hasNext()){
            data.add(reader.nextLine().split(";"));
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[0].equals(user.getNickname())) {
                data.get(i)[6] = newPath;
            }
        }

        FileWriter writer = new FileWriter(new File("src\\Logs\\users.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String string = "";
        for (int i = 0; i < data.size(); i++) {
            string += (data.get(i)[0] + ";" + data.get(i)[1] + ";" + data.get(i)[2] + ";" + data.get(i)[3] + ";" + data.get(i)[4] + ";" + data.get(i)[5] + ";" + data.get(i)[6] + "\n");
        }

        bufferedWriter.write(string);
        bufferedWriter.close();
    }
}
