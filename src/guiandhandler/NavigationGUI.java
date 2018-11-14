package TeenTitians.src.guiandhandler;

import TeenTitians.src.entityclasses.Puzzle;
import TeenTitians.src.entityclasses.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//NavigationGUI & GUIHandler by Wesley;


public class NavigationGUI {
    protected Room room = new Room("1");
    Puzzle puzzle = new Puzzle(room.getPuzzleLandmark());
    PuzzleGUI pGUI;

    protected JFrame frame;
    protected JPanel mainTextP, statsP, cmdLineP;
    protected JTextArea mainTextA, statsTA;
    protected JTextField cmdLineTF;
    protected JButton showExits, searchItem, searchPuzzle, back;
    protected Container con;
    private Font font = new Font("Times new Roman", Font.PLAIN, 24);

    private boolean showingExits = false;
    private boolean hasPuzzlebeenlaunched = false;
    //GUIHandler guiHandler;


        public NavigationGUI() {
            //guiHandler = new GUIHandler();
            frame = new JFrame();
            frame.setSize(1000,800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.black);
            frame.setLayout(null);
            frame.setVisible(true);
            con = frame.getContentPane();

            mainTextP = new JPanel(new GridLayout(4,1));
            mainTextP.setBounds(0,0,1000,500);
            mainTextP.setBackground(Color.black);
            mainTextA = new JTextArea(room.getDecription());
            mainTextA.setBounds(0,0,1000,500);
            mainTextA.setLineWrap(true);
            mainTextA.setBackground(Color.black);
            mainTextA.setForeground(Color.white);
            mainTextA.setFont(font);
            mainTextP.add(mainTextA);
            con.add(mainTextP);

            statsP = new JPanel();
            statsP.setBounds(0,580, 1000,80);
            statsP.setBackground(Color.black);
            statsTA = new JTextArea("HP:60");
            statsTA.setBounds(0,0,1000,80);
            statsTA.setLineWrap(true);
            statsTA.setBackground(Color.black);
            statsTA.setForeground(Color.white);
            statsTA.setFont(font);
            statsP.add(statsTA);
            con.add(statsP);

            cmdLineP = new JPanel();
            cmdLineP.setBounds(-12, 660, 1000, 80);
            cmdLineP.setBackground(Color.black);

            showExits = new JButton("Show Exits");
            showExits.setBackground(Color.black);
            showExits.setForeground(Color.white);
            showExits.setFont(font);
            showExits.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showExits();
                }
            });
            showExits.setFocusPainted(true);
            showExits.setActionCommand("showExits");
            cmdLineP.add(showExits);

            cmdLineTF = new JTextField(54);
            cmdLineTF.setBounds(0,0,1000,80);
            cmdLineTF.setBackground(Color.black);
            cmdLineTF.setForeground(Color.white);
            cmdLineTF.setFont(font);
            cmdLineTF.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (showingExits) {
                        room = room.exitRoom(cmdLineTF.getText());
                        mainTextA.setText(room.enterRoom(room));
                        showExits.setVisible(true);
                        statsP.setVisible(true);
                        cmdLineTF.setText("");
                        puzzle = new Puzzle(room.getPuzzleLandmark());
                        showingExits = false;
                    }else{
                        if (cmdLineTF.getText().equalsIgnoreCase("/search")) {
                            search();
                            cmdLineTF.setText("");
                        }
                    }
                }
            });
            cmdLineP.add(cmdLineTF);

            searchItem = new JButton("");
            searchItem.setVisible(false);
            searchItem.setBackground(Color.BLACK);
            searchItem.setForeground(Color.white);
            searchItem.setFont(font);
            searchItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainTextA.setText("you finds item, yey");
                }
            });
            mainTextP.add(searchItem);

            searchPuzzle = new JButton("");
            searchPuzzle.setVisible(false);
            searchPuzzle.setBackground(Color.BLACK);
            searchPuzzle.setForeground(Color.white);
            searchPuzzle.setFont(font);
            searchPuzzle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (puzzle.isPuzzle()) {
                        pGUI = new PuzzleGUI(room.getPuzzleLandmark(), room.getCurrentRoom());
                        hasPuzzlebeenlaunched = true;
                    }
                }
            });
            mainTextP.add(searchPuzzle);

            back = new JButton("Back");
            back.setVisible(false);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.white);
            back.setFont(font);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainTextA.setText(room.getDecription());
                    showExits.setVisible(true);
                    statsP.setVisible(true);
                    cmdLineTF.setText("");
                    back.setVisible(false);
                    searchPuzzle.setVisible(false);
                    searchItem.setVisible(false);
                }
            });
            cmdLineP.add(back);

            con.add(cmdLineP);
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

    public void setMainTextA(JTextArea mainTextA) {
        this.mainTextA = mainTextA;
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
            for (int i = 0; i < pGUI.room.getExitList().length; i++) {
                System.out.println(pGUI.room.getExitList());
            }
            room.setExitList(pGUI.room.getExitList());
            hasPuzzlebeenlaunched = false;
        }

            String exitText = "";
        for (int i = 0; i < room.getExitList().length; i++) {
            exitText += room.getExitList()[i] + ", ";
        }
        mainTextA.setText(exitText);
        showExits.setVisible(false);
        statsP.setVisible(false);
        showingExits = true;
        back.setVisible(true);
    }

    public void search() {

        puzzle.setUpPuzzle();
        searchPuzzle.setVisible(true);
        searchItem.setVisible(true);
        statsTA.setVisible(false);
        back.setVisible(true);
        showExits.setVisible(false);
        searchPuzzle.setText(puzzle.getpButtonDesc());



    }
}

