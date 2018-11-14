package TeenTitians.src.guiandhandler;

import TeenTitians.src.entityclasses.Puzzle;
import TeenTitians.src.entityclasses.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class PuzzleGUI {
    Puzzle puzzle;
    Room room;

    private JFrame frame;
    private JPanel mainTextP, cmdLineP;
    private JTextArea mainTextA;
    private JTextField cmdLineTF;
    private JButton back, utility;
    private Container con;
    private Font font = new Font("Times new Roman", Font.PLAIN, 24);

    private boolean hasFailed = false;

    public PuzzleGUI(String puzzleLandmark, String roomID) {
        puzzle = new Puzzle(puzzleLandmark);
        puzzle.setUpPuzzle();

        room = new Room(roomID);

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

        mainTextA = new JTextArea(puzzle.getPuzzleDescription());
        mainTextA.setBounds(0,0,1000,500);
        mainTextA.setLineWrap(true);
        mainTextA.setBackground(Color.black);
        mainTextA.setForeground(Color.white);
        mainTextA.setFont(font);

        mainTextP.add(mainTextA);
        con.add(mainTextP);


        cmdLineP = new JPanel();
        cmdLineP.setBounds(-12, 660, 1000, 80);
        cmdLineP.setBackground(Color.black);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(font);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasFailed) {
                    mainTextA.setText(puzzle.getPuzzleDescription());
                    hasFailed = false;
                }else {
                    frame.dispose();
                }
            }
        });
        cmdLineP.add(back);

        cmdLineTF = new JTextField(54);
        cmdLineTF.setBounds(0,0,1000,80);
        cmdLineTF.setBackground(Color.black);
        cmdLineTF.setForeground(Color.white);
        cmdLineTF.setFont(font);
        cmdLineTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reward = puzzle.implementSolution(cmdLineTF.getText());
                if (reward.equals("fail")) {
                    mainTextA.setText("Nothing seems to happen");
                    hasFailed = true;
                }else if (reward.equals("success")) {
                    room.setExitList(room.addExit(puzzle.getRewardAccess()));
                    mainTextA.setText("A door slides open. A secret passage has been unlocked");
                }else{
                    mainTextA.setText("ERROR");
                }
            }
        });
        cmdLineP.add(cmdLineTF);

        con.add(cmdLineP);
    }


}
