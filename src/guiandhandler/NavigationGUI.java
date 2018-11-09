package guiandhandler;

import entityclasses.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//NavigationGUI & GUIHandler by Wesley;


public class NavigationGUI {
    Room room = new Room();
    protected JFrame frame;
    protected JPanel mainTextP, statsP, cmdLineP;
    protected JTextArea mainTextA, statsTA;
    protected JTextField cmdLineTF;
    protected JButton showExits, nExit, sExit, wExit, eExit;
    protected Container con;
    Font font = new Font("Times new Roman", Font.PLAIN, 24);
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
                    room = room.exitRoom(cmdLineTF.getText());
                    mainTextA.setText(room.enterRoom(room));
                    showExits.setVisible(true);
                    statsP.setVisible(true);
                    cmdLineTF.setText("");
                }
            });
            cmdLineP.add(cmdLineTF);

//            wExit = new JButton("West Exit");
//            wExit.setBounds(460,500,500,50);
//            wExit.setBackground(Color.black);
//            wExit.setForeground(Color.white);
//            wExit.setFont(font);
//            wExit.addActionListener(guiHandler);
//            wExit.setActionCommand("wE");
//            wExit.setFocusPainted(true);
//
//            nExit = new JButton("North Exit");
//            wExit.setBounds(510,500,500,50);
//            nExit.setBackground(Color.black);
//            nExit.setForeground(Color.white);
//            nExit.setFont(font);
//            nExit.addActionListener(guiHandler);
//            nExit.setFocusPainted(true);
//            nExit.setActionCommand("nE");
//
//            sExit = new JButton("South Exit");
//            wExit.setBounds(560,500,500,50);
//            sExit.setBackground(Color.black);
//            sExit.setForeground(Color.white);
//            sExit.setFont(font);
//            sExit.addActionListener(guiHandler);
//            sExit.setFocusPainted(true);
//            sExit.setActionCommand("sE");
//
//            eExit = new JButton("East Exit");
//            eExit.setBounds(610,500,500,50);
//            eExit.setBackground(Color.black);
//            eExit.setForeground(Color.white);
//            eExit.setFont(font);
//            eExit.addActionListener(guiHandler);
//            eExit.setFocusPainted(true);
//            eExit.setActionCommand("eE");

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
        String exitText = "";
        for (int i = 0; i < room.getExitList().length; i++) {
            exitText += room.getExitList()[i] + ", ";
        }
        mainTextA.setText(exitText);
        showExits.setVisible(false);
        statsP.setVisible(false);
    }
}

