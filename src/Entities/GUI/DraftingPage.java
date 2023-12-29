package Entities.GUI;

import Entities.IPlayer;
import Entities.Players.*;
import Entities.Team;
import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class DraftingPage extends JFrame {

    private JComboBox jcomp1;
    private JButton select;
    private JLabel teamLabel1;
    private String team1String = "";
    private JLabel teamLabel2;
    private String team2String = "";
    private JLabel teamLabel3;
    private String team3String = "";
    private JLabel teamLabel4;
    private String team4String = "";
    private JLabel teamLabel5;
    private String team5String = "";
    private JLabel teamLabel6;
    private String team6String = "";
    private JLabel teamLabel7;
    private String team7String = "";
    private JLabel teamLabel8;
    private String team8String = "";
    private JLabel teamLabel9;
    private String team9String = "";
    private JLabel teamLabel10;
    private String team10String = "";
    private JLabel teamLabel11;
    private String team11String = "";
    private JLabel teamLabel12;
    private String team12String = "";
    private JLabel teamLabel13;
    private String team13String = "";
    private JLabel teamLabel14;
    private String team14String = "";
    private JLabel teamLabel15;
    private String team15String = "";
    private JLabel teamLabel16;
    private String team16String = "";
    private JButton startSeason;
    private JButton back;
    boolean isC = false;
    boolean isPF = false;
    boolean isPG = false;
    boolean isSF = false;
    boolean isSG = false;
    Set<String> playerNames = new TreeSet<>();
    ArrayList<Team> teams = new ArrayList<>();
    private int number = 0;
    public DraftingPage(User user) throws IOException {

        String[] jcomp1Items = {"Item 1", "Item 2", "Item 3"};
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        setSize (new Dimension(1980, 600));
        setLayout (null);

        setVisible(true);
        String line;
        String[] player;
        ArrayList<IPlayer> players = new ArrayList<>();
        ArrayList<IPlayer> C_players = new ArrayList<>();
        ArrayList<IPlayer> PF_players = new ArrayList<>();
        ArrayList<IPlayer> PG_players = new ArrayList<>();
        ArrayList<IPlayer> SF_players = new ArrayList<>();
        ArrayList<IPlayer> SG_players = new ArrayList<>();
        Team team1 = new Team(user.getName() + "'s Team", null);
        team1String += user.getName() + "'s Team \n";
        Team team2 = new Team("Boston KUltics", null);
        team2String += team2.getName() + "\n";
        Team team3 = new Team("ChicaKU Bulls", null);
        team3String += team3.getName() + "\n";
        Team team4 = new Team("Golden KU Warriors", null);
        team4String += team4.getName() + "\n";
        Team team5 = new Team("MiaKU Heats", null);
        team5String += team5.getName() + "\n";
        Team team6 = new Team("Toronto RaptorKUs", null);
        team6String += team6.getName() + "\n";
        Team team7 = new Team("KUladelphia 76ers", null);
        team7String += team7.getName() + "\n";
        Team team8 = new Team("WasKUngton Wizards", null);
        team8String = team8.getName() + "\n";
        Team team9 = new Team("KUleveland Cavaliers", null);
        team9String += team9.getName() + "\n";
        Team team10 = new Team("Houston RocKUts", null);
        team10String += team10.getName() + "\n";
        Team team11 = new Team("Atlanta HawKU", null);
        team11String += team11.getName() + "\n";
        Team team12 = new Team("KUharlotte Hornets", null);
        team12String += team12.getName() + "\n";
        Team team13 = new Team("New Orleans PeliKUns", null);
        team13String += team13.getName() + "\n";
        Team team14 = new Team("KU Antonio Spurs", null);
        team14String += team14.getName() + "\n";
        Team team15 = new Team("Minnesota TimberKUs", null);
        team15String += team15.getName() + "\n";
        Team team16 = new Team("Memphis KUrizzlies", null);
        team16String += team16.getName() + "\n";


        BufferedReader fileReader = new BufferedReader(new FileReader("src\\Logs\\2022-2023-NBA-Player-Stats-Regular.csv"));
        while ((line = fileReader.readLine()) != null) {
            player = line.split(";");
             switch(player[2]){
                case "C":
                    C_players.add(new C_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new C_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "PF":
                    PF_players.add(new PF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new PF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "PG":
                    PG_players.add(new PG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new PG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "SF":
                    SF_players.add(new SF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new SF_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
                case "SG":
                    SG_players.add(new SG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    players.add(new SG_Player(player[1], Double.parseDouble(player[29]), Double.parseDouble(player[23]), Double.parseDouble(player[24]), Double.parseDouble(player[26]), Double.parseDouble(player[25])));
                    break;
            }
        }


        for(IPlayer iPlayer: C_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: PF_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: PG_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: SF_players) {
            playerNames.add(iPlayer.getName());
        }
        for(IPlayer iPlayer: SG_players) {
            playerNames.add(iPlayer.getName());
        }

        jcomp1 = new JComboBox (playerNames.toArray());
        jcomp1.setRenderer(new CustomCellRenderer());
        teamLabel1 = new JLabel (team1String);
        teamLabel1.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel2 = new JLabel (team2String);
        teamLabel2.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel3 = new JLabel (team3String);
        teamLabel3.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel4 = new JLabel (team4String);
        teamLabel4.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel5 = new JLabel (team5String);
        teamLabel5.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel6 = new JLabel (team6String);
        teamLabel6.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel7 = new JLabel (team7String);
        teamLabel7.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel8 = new JLabel (team8String);
        teamLabel8.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel9 = new JLabel (team9String);
        teamLabel9.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel10 = new JLabel (team10String);
        teamLabel10.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel11 = new JLabel (team11String);
        teamLabel11.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel12 = new JLabel (team12String);
        teamLabel12.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel13 = new JLabel (team13String);
        teamLabel13.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel14 = new JLabel (team14String);
        teamLabel14.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel15 = new JLabel (team15String);
        teamLabel15.setFont(new Font("Ariel", Font.PLAIN, 16));
        teamLabel16 = new JLabel (team16String);
        teamLabel16.setFont(new Font("Ariel", Font.PLAIN, 16));
        select = new JButton ("Select Player");
        select.setFont(new Font("Ariel", Font.PLAIN, 16));
        select.setBackground(new Color(184,184,184));
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number < 5) {
                    double selectedPts = 0;
                    double selectedTrb = 0;
                    double selectedAst = 0;
                    double selectedBlk = 0;
                    double selectedStl = 0;
                    String selectedPos = "";
                    int count = 0;

                    String selectedPlayerName = jcomp1.getSelectedItem().toString();
                    for(IPlayer selectedPlayer: players) {
                        if (selectedPlayer.getName().matches(selectedPlayerName)){
                            selectedPts += selectedPlayer.getPts();
                            selectedTrb += selectedPlayer.getTrb();
                            selectedAst += selectedPlayer.getAst();
                            selectedBlk += selectedPlayer.getBlk();
                            selectedStl += selectedPlayer.getStl();
                            selectedPos  = selectedPlayer.getPosition();
                            count++;
                        }
                    }

                    int randomIndex;

                    switch (selectedPos) {
                        case "C":
                            isC = true;
                            team1.addPlayer(new C_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            team1String += selectedPlayerName + "\n";

                            randomIndex = new Random().nextInt(C_players.size());
                            team2.addPlayer(C_players.get(randomIndex));
                            team2String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team3.addPlayer(C_players.get(randomIndex));
                            team3String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team4.addPlayer(C_players.get(randomIndex));
                            team4String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team5.addPlayer(C_players.get(randomIndex));
                            team5String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team6.addPlayer(C_players.get(randomIndex));
                            team6String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team7.addPlayer(C_players.get(randomIndex));
                            team7String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team8.addPlayer(C_players.get(randomIndex));
                            team8String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team9.addPlayer(C_players.get(randomIndex));
                            team9String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team10.addPlayer(C_players.get(randomIndex));
                            team10String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team11.addPlayer(C_players.get(randomIndex));
                            team11String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team12.addPlayer(C_players.get(randomIndex));
                            team12String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team13.addPlayer(C_players.get(randomIndex));
                            team13String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team14.addPlayer(C_players.get(randomIndex));
                            team14String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team15.addPlayer(C_players.get(randomIndex));
                            team15String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(C_players.size());
                            team16.addPlayer(C_players.get(randomIndex));
                            team16String += C_players.get(randomIndex).getName() + "\n";
                            C_players.remove(randomIndex);

                            break;
                        case "PF":
                            isPF = true;
                            team1.addPlayer(new PF_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            team1String += selectedPlayerName + "\n";

                            randomIndex = new Random().nextInt(PF_players.size());
                            team2.addPlayer(PF_players.get(randomIndex));
                            team2String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team3.addPlayer(PF_players.get(randomIndex));
                            team3String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team4.addPlayer(PF_players.get(randomIndex));
                            team4String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team5.addPlayer(PF_players.get(randomIndex));
                            team5String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team6.addPlayer(PF_players.get(randomIndex));
                            team6String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team7.addPlayer(PF_players.get(randomIndex));
                            team7String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team8.addPlayer(PF_players.get(randomIndex));
                            team8String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team9.addPlayer(PF_players.get(randomIndex));
                            team9String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team10.addPlayer(PF_players.get(randomIndex));
                            team10String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team11.addPlayer(PF_players.get(randomIndex));
                            team11String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team12.addPlayer(PF_players.get(randomIndex));
                            team12String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team13.addPlayer(PF_players.get(randomIndex));
                            team13String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team14.addPlayer(PF_players.get(randomIndex));
                            team14String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team15.addPlayer(PF_players.get(randomIndex));
                            team15String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PF_players.size());
                            team16.addPlayer(PF_players.get(randomIndex));
                            team16String += PF_players.get(randomIndex).getName() + "\n";
                            PF_players.remove(randomIndex);

                            break;
                        case "PG":
                            isPG = true;
                            team1.addPlayer(new PG_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            team1String += selectedPlayerName + "\n";

                            randomIndex = new Random().nextInt(PG_players.size());
                            team2.addPlayer(PG_players.get(randomIndex));
                            team2String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team3.addPlayer(PG_players.get(randomIndex));
                            team3String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team4.addPlayer(PG_players.get(randomIndex));
                            team4String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team5.addPlayer(PG_players.get(randomIndex));
                            team5String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team6.addPlayer(PG_players.get(randomIndex));
                            team6String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team7.addPlayer(PG_players.get(randomIndex));
                            team7String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team8.addPlayer(PG_players.get(randomIndex));
                            team8String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team9.addPlayer(PG_players.get(randomIndex));
                            team9String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team10.addPlayer(PG_players.get(randomIndex));
                            team10String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team11.addPlayer(PG_players.get(randomIndex));
                            team11String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team12.addPlayer(PG_players.get(randomIndex));
                            team12String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team13.addPlayer(PG_players.get(randomIndex));
                            team13String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team14.addPlayer(PG_players.get(randomIndex));
                            team14String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team15.addPlayer(PG_players.get(randomIndex));
                            team15String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(PG_players.size());
                            team16.addPlayer(PG_players.get(randomIndex));
                            team16String += PG_players.get(randomIndex).getName() + "\n";
                            PG_players.remove(randomIndex);

                            break;
                        case "SF":
                            isSF = true;
                            team1.addPlayer(new SF_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            team1String += selectedPlayerName + "\n";

                            randomIndex = new Random().nextInt(SF_players.size());
                            team2.addPlayer(SF_players.get(randomIndex));
                            team2String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team3.addPlayer(SF_players.get(randomIndex));
                            team3String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team4.addPlayer(SF_players.get(randomIndex));
                            team4String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team5.addPlayer(SF_players.get(randomIndex));
                            team5String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team6.addPlayer(SF_players.get(randomIndex));
                            team6String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team7.addPlayer(SF_players.get(randomIndex));
                            team7String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team8.addPlayer(SF_players.get(randomIndex));
                            team8String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team9.addPlayer(SF_players.get(randomIndex));
                            team9String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team10.addPlayer(SF_players.get(randomIndex));
                            team10String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team11.addPlayer(SF_players.get(randomIndex));
                            team11String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team12.addPlayer(SF_players.get(randomIndex));
                            team12String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team13.addPlayer(SF_players.get(randomIndex));
                            team13String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team14.addPlayer(SF_players.get(randomIndex));
                            team14String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team15.addPlayer(SF_players.get(randomIndex));
                            team15String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SF_players.size());
                            team16.addPlayer(SF_players.get(randomIndex));
                            team16String += SF_players.get(randomIndex).getName() + "\n";
                            SF_players.remove(randomIndex);

                            break;
                        case "SG":
                            isSG = true;
                            team1.addPlayer(new SG_Player(selectedPlayerName, selectedPts / count, selectedTrb / count, selectedAst / count, selectedBlk / count, selectedStl / count));
                            team1String += selectedPlayerName + "\n";

                            randomIndex = new Random().nextInt(SG_players.size());
                            team2.addPlayer(SG_players.get(randomIndex));
                            team2String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team3.addPlayer(SG_players.get(randomIndex));
                            team3String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team4.addPlayer(SG_players.get(randomIndex));
                            team4String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team5.addPlayer(SG_players.get(randomIndex));
                            team5String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team6.addPlayer(SG_players.get(randomIndex));
                            team6String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team7.addPlayer(SG_players.get(randomIndex));
                            team7String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team8.addPlayer(SG_players.get(randomIndex));
                            team8String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team9.addPlayer(SG_players.get(randomIndex));
                            team9String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team10.addPlayer(SG_players.get(randomIndex));
                            team10String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team11.addPlayer(SG_players.get(randomIndex));
                            team11String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team12.addPlayer(SG_players.get(randomIndex));
                            team12String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team13.addPlayer(SG_players.get(randomIndex));
                            team13String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team14.addPlayer(SG_players.get(randomIndex));
                            team14String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team15.addPlayer(SG_players.get(randomIndex));
                            team15String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            randomIndex = new Random().nextInt(SG_players.size());
                            team16.addPlayer(SG_players.get(randomIndex));
                            team16String += SG_players.get(randomIndex).getName() + "\n";
                            SG_players.remove(randomIndex);

                            break;

                    }



                    jcomp1.removeAllItems();

                    playerNames = new TreeSet<>();

                    if (!isC){
                        for(IPlayer iPlayer: C_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isPF) {
                        for(IPlayer iPlayer: PF_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isPG) {
                        for(IPlayer iPlayer: PG_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isSF) {
                        for(IPlayer iPlayer: SF_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    if (!isSG) {
                        for(IPlayer iPlayer: SG_players) {
                            playerNames.add(iPlayer.getName());
                        }
                    }

                    for (String string: playerNames){
                        jcomp1.addItem(string);
                    }

                    number ++;
                } else {
                    JOptionPane.showMessageDialog(null, "Can only select 5 players!");
                }

            }
        });

        startSeason = new JButton ("Start Season");
        startSeason.setFont(new Font("Ariel", Font.PLAIN, 16));
        startSeason.setBackground(new Color(184,184,184));
        startSeason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number == 5) {
                    teams.add(team1);
                    teams.add(team2);
                    teams.add(team3);
                    teams.add(team4);
                    teams.add(team5);
                    teams.add(team6);
                    teams.add(team7);
                    teams.add(team8);
                    teams.add(team9);
                    teams.add(team10);
                    teams.add(team11);
                    teams.add(team12);
                    teams.add(team13);
                    teams.add(team14);
                    teams.add(team15);
                    teams.add(team16);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new SeasonMatchPage(teams);
                        }
                    });
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select 5 players!");

                }
            }
        });

        back = new JButton("Go Back");
        back.setFont(new Font("Ariel", Font.PLAIN, 16));
        back.setBackground(new Color(184,184,184));
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

        teamLabel1.setForeground(new Color(102,102,153));
        teamLabel2.setForeground(new Color(102,102,153));
        teamLabel3.setForeground(new Color(102,102,153));
        teamLabel4.setForeground(new Color(102,102,153));
        teamLabel5.setForeground(new Color(102,102,153));
        teamLabel6.setForeground(new Color(102,102,153));
        teamLabel7.setForeground(new Color(102,102,153));
        teamLabel8.setForeground(new Color(102,102,153));
        teamLabel9.setForeground(new Color(102,102,153));
        teamLabel10.setForeground(new Color(102,102,153));
        teamLabel11.setForeground(new Color(102,102,153));
        teamLabel12.setForeground(new Color(102,102,153));
        teamLabel13.setForeground(new Color(102,102,153));
        teamLabel14.setForeground(new Color(102,102,153));
        teamLabel15.setForeground(new Color(102,102,153));
        teamLabel16.setForeground(new Color(102,102,153));

        add (jcomp1);
        add (select);
        add (teamLabel1);
        add (teamLabel2);
        add (teamLabel3);
        add (teamLabel4);
        add (teamLabel5);
        add (teamLabel6);
        add (teamLabel7);
        add (teamLabel8);
        add (teamLabel9);
        add (teamLabel10);
        add (teamLabel11);
        add (teamLabel12);
        add (teamLabel13);
        add (teamLabel14);
        add (teamLabel15);
        add (teamLabel16);
        JButton teamButton1 = new JButton("View Team Players");
        teamButton1.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton1.setBackground(new Color(184,184,184));
        JButton teamButton2 = new JButton("View Team Players");
        teamButton2.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton2.setBackground(new Color(184,184,184));
        JButton teamButton3 = new JButton("View Team Players");
        teamButton3.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton3.setBackground(new Color(184,184,184));
        JButton teamButton4 = new JButton("View Team Players");
        teamButton4.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton4.setBackground(new Color(184,184,184));
        JButton teamButton5 = new JButton("View Team Players");
        teamButton5.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton5.setBackground(new Color(184,184,184));
        JButton teamButton6 = new JButton("View Team Players");
        teamButton6.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton6.setBackground(new Color(184,184,184));
        JButton teamButton7 = new JButton("View Team Players");
        teamButton7.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton7.setBackground(new Color(184,184,184));
        JButton teamButton8 = new JButton("View Team Players");
        teamButton8.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton8.setBackground(new Color(184,184,184));
        JButton teamButton9 = new JButton("View Team Players");
        teamButton9.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton9.setBackground(new Color(184,184,184));
        JButton teamButton10 = new JButton("View Team Players");
        teamButton10.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton10.setBackground(new Color(184,184,184));
        JButton teamButton11 = new JButton("View Team Players");
        teamButton11.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton11.setBackground(new Color(184,184,184));
        JButton teamButton12 = new JButton("View Team Players");
        teamButton12.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton12.setBackground(new Color(184,184,184));
        JButton teamButton13 = new JButton("View Team Players");
        teamButton13.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton13.setBackground(new Color(184,184,184));
        JButton teamButton14 = new JButton("View Team Players");
        teamButton14.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton14.setBackground(new Color(184,184,184));
        JButton teamButton15 = new JButton("View Team Players");
        teamButton15.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton15.setBackground(new Color(184,184,184));
        JButton teamButton16 = new JButton("View Team Players");
        teamButton16.setFont(new Font("Ariel", Font.PLAIN, 13));
        teamButton16.setBackground(new Color(184,184,184));
        add(teamButton1);
        add(teamButton2);
        add(teamButton3);
        add(teamButton4);
        add(teamButton5);
        add(teamButton6);
        add(teamButton7);
        add(teamButton8);
        add(teamButton9);
        add(teamButton10);
        add(teamButton11);
        add(teamButton12);
        add(teamButton13);
        add(teamButton14);
        add(teamButton15);
        add(teamButton16);
        add (startSeason);
        add(back);

        teamButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team1);
                    }
                });
            }
        });
        teamButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team2);
                    }
                });
            }
        });
        teamButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team3);
                    }
                });
            }
        });
        teamButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team4);
                    }
                });
            }
        });
        teamButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team5);
                    }
                });
            }
        });
        teamButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team6);
                    }
                });
            }
        });
        teamButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team7);
                    }
                });
            }
        });
        teamButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team8);
                    }
                });
            }
        });
        teamButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team9);
                    }
                });
            }
        });
        teamButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team10);
                    }
                });
            }
        });
        teamButton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team11);
                    }
                });
            }
        });
        teamButton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team12);
                    }
                });
            }
        });
        teamButton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team13);
                    }
                });
            }
        });
        teamButton14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team14);
                    }
                });
            }
        });
        teamButton15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team15);
                    }
                });
            }
        });
        teamButton16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new TeamViewPage(team16);
                    }
                });
            }
        });



        jcomp1.setBounds (65, 435, 625, 30);
        select.setBounds (715, 435, 130, 30);
        teamLabel1.setBounds (65, 40, 200, 100);
        teamButton1.setBounds(65,180,150,30);
        teamLabel2.setBounds (275, 40, 200, 100);
        teamButton2.setBounds(275,180,150,30);
        teamLabel3.setBounds (485, 40, 200, 100);
        teamButton3.setBounds(485,180,150,30);
        teamLabel4.setBounds (695, 40, 200, 100);
        teamButton4.setBounds(695,180,150,30);
        teamLabel5.setBounds (905, 40, 200, 100);
        teamButton5.setBounds(905,180,150,30);
        teamLabel6.setBounds (1115, 40, 200, 100);
        teamButton6.setBounds(1115,180,150,30);
        teamLabel7.setBounds (1325, 40, 200, 100);
        teamButton7.setBounds(1325,180,150,30);
        teamLabel8.setBounds (1535, 40, 200, 100);
        teamButton8.setBounds(1535,180,150,30);
        teamLabel9.setBounds (65, 240, 200, 100);
        teamButton9.setBounds(65,350,150,30);
        teamLabel10.setBounds (275, 240, 200, 100);
        teamButton10.setBounds(275,350,150,30);
        teamLabel11.setBounds (485, 240, 200, 100);
        teamButton11.setBounds(485,350,150,30);
        teamLabel12.setBounds (695, 240, 200, 100);
        teamButton12.setBounds(695,350,150,30);
        teamLabel13.setBounds (905, 240, 200, 100);
        teamButton13.setBounds(905,350,150,30);
        teamLabel14.setBounds (1115, 240, 200, 100);
        teamButton14.setBounds(1115,350,150,30);
        teamLabel15.setBounds (1325, 240, 200, 100);
        teamButton15.setBounds(1325,350,150,30);
        teamLabel16.setBounds (1535, 240, 200, 100);
        teamButton16.setBounds(1535,350,150,30);
        startSeason.setBounds (865, 435, 230, 30);
        back.setBounds(65,500,130,30);
    }

}
