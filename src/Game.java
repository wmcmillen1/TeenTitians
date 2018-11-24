package TeenTitians.src;

import TeenTitians.src.entityclasses.Puzzle;
import TeenTitians.src.entityclasses.Room;
import TeenTitians.src.entityclasses.gameentities.Monster;
import TeenTitians.src.entityclasses.gameentities.Player;
import TeenTitians.src.guiandhandler.NavigationGUI;

public class Game {
//Game by Wesley
protected Player player = new Player(75,75,33,33,0, 15, "player", 25,"You're you of course");
public Room room = new Room("1");
public Puzzle puzzle= new Puzzle(room.getPuzzleLandmark());
public Login login = new Login();
    public static void main(String[] args) {
        NavigationGUI nav = new NavigationGUI();





        //Since the variable for room in nav references the Game.room version of the object, then it should get and set
        //that version of the object.

    }


}
