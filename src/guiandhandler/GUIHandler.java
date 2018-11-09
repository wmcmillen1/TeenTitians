package guiandhandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entityclasses.Game;
import entityclasses.Room;

public class GUIHandler implements ActionListener {
    NavigationGUI GUI;
    Room room = new Room();
    Font font = new Font("Times new Roman", Font.PLAIN, 24);


    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = "";
        GUI = new NavigationGUI();
        if (e.getActionCommand() != null) {
           choice = e.getActionCommand();
        }
        boolean isThere = false;
        if (choice.equals("showExits")) {
                showExits();

        }
    }

    public void showExits() {
        String exitText = "";
        for (int i = 0; i < room.getExitList().length; i ++) {
            exitText+= room.getExitList()[i] + ", ";
        }
        GUI = new NavigationGUI();
        GUI.mainTextA.setText(exitText);
        GUI.showExits.setVisible(false);
        GUI.statsP.setVisible(false);
//        GUI.mainTextP.add(GUI.nExit);
//        GUI.mainTextP.add(GUI.wExit);
//        GUI.mainTextP.add(GUI.sExit);
//        GUI.mainTextP.add(GUI.eExit);
    }

    public void northExit() {
        GUI = new NavigationGUI();
        GUI.mainTextA.setText("IT WORKS");
        GUI.showExits.setVisible(true);
        GUI.statsP.setVisible(true);
//        GUI.mainTextP.remove(GUI.nExit);
//        GUI.mainTextP.remove(GUI.wExit);
//        GUI.mainTextP.remove(GUI.sExit);
//        GUI.mainTextP.remove(GUI.eExit);
    }
//
//    public void southExit() {
//        GUI = new NavigationGUI();
//        GUI.mainTextA.setText("you're more southy now");
//        GUI.showExits.setVisible(true);
//        GUI.statsP.setVisible(true);
//        GUI.mainTextP.remove(GUI.nExit);
//        GUI.mainTextP.remove(GUI.wExit);
//        GUI.mainTextP.remove(GUI.sExit);
//        GUI.mainTextP.remove(GUI.eExit);
//    }
//    public void westExit() {
//        GUI = new NavigationGUI();
//        GUI.mainTextA.setText("you're more westy now");
//        GUI.showExits.setVisible(true);
//        GUI.statsP.setVisible(true);
//        GUI.mainTextP.remove(GUI.nExit);
//        GUI.mainTextP.remove(GUI.wExit);
//        GUI.mainTextP.remove(GUI.sExit);
//        GUI.mainTextP.remove(GUI.eExit);
//    }
//    public void eastExit() {
//        GUI = new NavigationGUI();
//        GUI.mainTextA.setText("you're more easty now");
//        GUI.showExits.setVisible(true);
//        GUI.statsP.setVisible(true);
//        GUI.mainTextP.remove(GUI.nExit);
//        GUI.mainTextP.remove(GUI.wExit);
//        GUI.mainTextP.remove(GUI.sExit);
//        GUI.mainTextP.remove(GUI.eExit);
//    }

}
