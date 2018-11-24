package TeenTitians.src.guiandhandler;

import TeenTitians.src.Game;
import TeenTitians.src.entityclasses.Puzzle;
import TeenTitians.src.entityclasses.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
//NavigationGUI by Wesley;


public class NavigationGUI {

    Game game = new Game();

    PuzzleGUI pGUI;

    protected JFrame frame;
    protected JPanel mainTextP, statsP, cmdLineP,inventoryP, mapP, loginP, loginTP, loginPP;
    protected JTextArea mainTextA, statsTA, invenotryTA, titleCard, loginTA, loginPA;
    protected JTextField cmdLineTF, loginTF;
    protected JPasswordField loginPF;
    protected JButton showExits, searchItem, searchPuzzle, back;
    protected Container con;
    private Font font = new Font("Times new Roman", Font.PLAIN, 24);

    protected BufferedImage map1;
    protected BufferedImage map2;

    public boolean showingExits = false;
    private boolean hasPuzzlebeenlaunched = false;


    //GUIHandler guiHandler;


        public NavigationGUI() {
 //FRAME
            frame = new JFrame();
            frame.setSize(1600,800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.black);
            frame.setLayout(null);

            con = frame.getContentPane();
//LOGIN PANEL
            loginP = new JPanel(new GridLayout(3,1));
            loginP.setBounds(600, 200, 300,200);
            loginP.setBackground(Color.BLACK);
    //Title Card
            titleCard = new JTextArea("Phylactery");
            titleCard.setBackground(Color.BLACK);
            titleCard.setForeground(Color.white);
            titleCard.setFont(new Font("Algerian", Font.BOLD, 44));
    //Login Text Panel
            loginTP = new JPanel();
            loginTP.setBackground(Color.BLACK);
        //Login Username
            loginTA = new JTextArea("Username");
            loginTA.setBackground(Color.BLACK);
            loginTA.setForeground(Color.white);
            loginTA.setFont(font);
        //Login Text Field
            loginTF = new JTextField(30);
            loginTF.setHorizontalAlignment(JTextField.CENTER);
            loginTF.setForeground(Color.BLACK);
            loginTF.setFont(font);

    //Login Password
            loginPP = new JPanel();
            loginPP.setBackground(Color.BLACK);
        //Login Password
            loginPA = new JTextArea("Password");
            loginPA.setBackground(Color.BLACK);
            loginPA.setForeground(Color.white);
            loginPA.setFont(font);
        //Login Password Field
            loginPF = new JPasswordField(30);
            loginPF.setHorizontalAlignment(JPasswordField.CENTER);
            loginPF.setForeground(Color.BLACK);
            loginPF.setFont(font);
        //PASSWORD ACTIONLISTENER
            loginPF.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!("".equals(loginTF) || "".equals(loginPF))) {
                        game.login.setUserName(loginTF.getText());
                        game.login.setPassword(String.valueOf(loginPF.getPassword()));
//                        try {
//                            game.login.writeLoginInfo();
//                        } catch (IOException e1) {
//                            e1.printStackTrace();
//                        }

                        mainTextP.setVisible(true);
                        inventoryP.setVisible(true);
                        cmdLineP.setVisible(true);
                        statsP.setVisible(true);

                        loginP.setVisible(false);
                    }
                }
            });



//MAIN TEXT PANEL
            mainTextP = new JPanel(new GridLayout(4,1));
            mainTextP.setBounds(0,0,980,600);
            mainTextP.setBackground(Color.black);

            mainTextP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));
     //Main Text Area
            mainTextA = new JTextArea(game.room.getDecription());
            mainTextA.setBounds(0,0,950,600);
            mainTextA.setLineWrap(true);
            mainTextA.setBackground(Color.black);
            mainTextA.setForeground(Color.white);
            mainTextA.setFont(font);


//INVENTORY PANEL
            inventoryP = new JPanel();
            inventoryP.setBounds(1000,0, 500, 550);
            inventoryP.setBackground(Color.BLACK);
            inventoryP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));
    //Inventory Text Area
            invenotryTA = new JTextArea("Inventory");
            invenotryTA.setBackground(Color.BLACK);
            invenotryTA.setForeground(Color.white);
            invenotryTA.setFont(font);


//CMD LINE PANEL
            cmdLineP = new JPanel();
            //cmdLineP.setBounds(-12, 1000, 1000, 80);
            cmdLineP.setBackground(Color.black);
            cmdLineP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));

    //Show Exits Button
            showExits = new JButton("Show Exits");
            showExits.setBackground(Color.black);
            showExits.setForeground(Color.white);
            showExits.setFont(font);
        //Show Exits ActionListener
            showExits.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showExits();
                }
            });
            showExits.setFocusPainted(true);
            showExits.setActionCommand("showExits");
    //CMD Line Text Field
            cmdLineTF = new JTextField(54);
            cmdLineTF.setBackground(Color.black);
            cmdLineTF.setForeground(Color.white);
            cmdLineTF.setFont(font);
            cmdLineTF.addActionListener(new ActionListener() {
                @Override
        //CMD Line ActionListener
                public void actionPerformed(ActionEvent e) {
                    //IF the GUI is currently showing exits, then feed player input into the ExitRoom method and
                    //Switch back to normal
                    if (showingExits) {
                        game.room = game.room.exitRoom(cmdLineTF.getText());
                        mainTextA.setText(game.room.enterRoom(game.room));
                        showExits.setVisible(true);
                        statsP.setVisible(true);
                        cmdLineTF.setText("");
                        game.puzzle = new Puzzle(game.room.getPuzzleLandmark());
                        showingExits = false;
                        back.setVisible(false);
                    }else{
                        String input = cmdLineTF.getText();
                        switch (input) {
                            case "/search":
                                search();
                                cmdLineTF.setText("");
                                break;
                            case "/save":
                                try {
                                    game.login.writeSaveFile(game.room.getRoomID());
                                    mainTextA.setText("Game Saved");
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                    mainTextA.setText("Save Failed");
                                }
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/load":
                                game.login.readSaveFile(game.login.readLoginInfo());
                                mainTextA.setText("Game Loaded");
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/attack":
                                mainTextA.setText("You Attack, Yay!");
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/block":
                                mainTextA.setText("You Block, Yay!");
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/help":
                                mainTextA.setText("/search, /save, /attack, /block, /help \n" +
                                        "While Showing Exits, type R(room number) or SR(room number");
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            default:
                                mainTextA.setText("Invalid Command\n" +
                                        "Use /help to retrive a list of available commands");
                                back.setVisible(true);
                                showExits.setVisible(false);
                        }
                    }
                }
            });

    //Search Item Button
            searchItem = new JButton("");

            searchItem.setBackground(Color.BLACK);
            searchItem.setForeground(Color.white);
            searchItem.setFont(font);
        //Search Item ActionListener
            searchItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainTextA.setText("you finds item, yey");
                }
            });

    //Search Puzzle Button
            searchPuzzle = new JButton("");

            searchPuzzle.setBackground(Color.BLACK);
            searchPuzzle.setForeground(Color.white);
            searchPuzzle.setFont(font);
        //Search Puzzle ActionListener
            searchPuzzle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (game.puzzle.isPuzzle()) {
                        pGUI = new PuzzleGUI(game.room.getPuzzleLandmark(), game.room.getRoomID());
                        hasPuzzlebeenlaunched = true;
                    }
                }
            });

    //Back Button
            back = new JButton("Back");

            back.setBackground(Color.BLACK);
            back.setForeground(Color.white);
            back.setFont(font);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainTextA.setText(game.room.getDecription());
                    showExits.setVisible(true);
                    statsP.setVisible(true);
                    cmdLineTF.setText("");
                    back.setVisible(false);
                    searchPuzzle.setVisible(false);
                    searchItem.setVisible(false);
                }
            });

//STATS PANEL
            statsP = new JPanel();
            statsP.setBounds(0,660, 1000,80);
            statsP.setBackground(Color.black);
            statsP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));

    //Stats Text Area
            statsTA = new JTextArea("HP:60");
            statsTA.setBounds(0,0,1000,80);
            statsTA.setLineWrap(true);
            statsTA.setBackground(Color.black);
            statsTA.setForeground(Color.white);
            statsTA.setFont(font);


//COMPONENTS ADD

    //Main Text Components
            mainTextP.add(mainTextA);
            mainTextP.add(searchItem);
            mainTextP.add(searchPuzzle);
            con.add(mainTextP);
    //Inventory Components
            inventoryP.add(invenotryTA);
            con.add(inventoryP);
    //CMD Line Components
            cmdLineP.add(cmdLineTF);
            cmdLineP.add(showExits);
            cmdLineP.add(back);
            mainTextP.add(cmdLineP);
    //Stats Components
            statsP.add(statsTA);
            con.add(statsP);
    //Login Components
            loginP.add(titleCard);

            loginTP.add(loginTA);
            loginTP.add(loginTF);
            loginP.add(loginTP);

            loginPP.add(loginPA);
            loginPP.add(loginPF);
            loginP.add(loginPP);

            con.add(loginP);
//COMPONENTS SET VISIBLE
            frame.setVisible(true);
    //LOGIN
            loginP.setVisible(true);
    //MAIN TEXT
            mainTextP.setVisible(false);
            searchItem.setVisible(false);
            searchPuzzle.setVisible(false);
    //INVENTORY
            inventoryP.setVisible(false);
    //CMD LINE
            cmdLineP.setVisible(false);
            back.setVisible(false);
    //STATS
            statsP.setVisible(false);

        }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainTextP() {
        return mainTextP;
    }

    public void setMainTextP(JPanel mainTextP) {
        this.mainTextP = mainTextP;
    }

    public JPanel getStatsP() {
        return statsP;
    }

    public void setStatsP(JPanel statsP) {
        this.statsP = statsP;
    }

    public JPanel getCmdLineP() {
        return cmdLineP;
    }

    public void setCmdLineP(JPanel cmdLineP) {
        this.cmdLineP = cmdLineP;
    }

    public JTextArea getMainTextA() {
        return mainTextA;
    }

    public void setMainTextA(String text) {
        this.mainTextA.setText(text);
    }

    public JTextArea getStatsTA() {
        return statsTA;
    }

    public void setStatsTA(JTextArea statsTA) {
        this.statsTA = statsTA;
    }

    public JTextField getCmdLineTF() {
        return cmdLineTF;
    }

    public void setCmdLineTF(JTextField cmdLineTF) {
        this.cmdLineTF = cmdLineTF;
    }

    public Container getCon() {
        return con;
    }

    public void setCon(Container con) {
        this.con = con;
    }


    public void showExits() {
        if (hasPuzzlebeenlaunched) {
            game.room.setExitList(pGUI.game.room.getExitList());
            hasPuzzlebeenlaunched = false;
        }

            String exitText = "";
        for (int i = 0; i < game.room.getExitList().length; i++) {
            exitText += game.room.getExitList()[i] + ", ";
        }
        mainTextA.setText(exitText);
        showExits.setVisible(false);
        showingExits = true;
        back.setVisible(true);
    }

    public void search() {

        game.puzzle.setUpPuzzle();
        searchPuzzle.setVisible(true);
        searchItem.setVisible(true);
        statsTA.setVisible(false);
        back.setVisible(true);
        showExits.setVisible(false);
        searchPuzzle.setText(game.puzzle.getpButtonDesc());



    }
}

