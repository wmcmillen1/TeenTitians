package entityclasses;

import jdk.nashorn.internal.ir.IfNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Room {
//entityclasses.Room Class by Jerson&Wesley; Text File by Clyde, ReadFile by Austin. Jerson, Clyde & Wesley did
    //their portioned work on time and fully completed.

    //exit enter//
    private String description;
    private String roomID;
    private String doors;
    private String monsters;
    private String items;
    private String teleporter;
    private String stairs;
    private String[] exitList;
    private String currentRoom = "R1";


    public Room(String description, String roomID, String doors, String monsters, String items, String teleporter, String stairs, String exitList) {
        this.description = description;
        this.roomID = roomID;
        this.doors = doors;
        this.monsters = monsters;
        this.items = items;
        this.teleporter = teleporter;
        this.stairs = stairs;
        this.exitList = exitList.split(",");
        currentRoom = roomID;
    }

    public Room (String roomID)
    {
        readFile(roomID);

    }

    public Room() {
        description = "You open your eyes to a smoky room. As your eyes wander up you see tall dirt walls and the moon�s shine bursting through the crevice. You realize that you are in a ditch with only two doors to exit one on your right and one directly in front of you.";
        roomID = "1";
        doors = "You see an exit leading South.";
        monsters = "none";
        items = "N/A";
        teleporter = "N/A";
        stairs = "N/A";
        exitList = "2,3".split(",");

    }

    public String getDecription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getMonsters() {
        return monsters;
    }

    public void setMonsters(String monsters) {
        this.monsters = monsters;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getTeleporter() {
        return teleporter;
    }

    public void setTeleporter(String teleporter) {
        this.teleporter = teleporter;
    }

    public String getStairs() {
        return stairs;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    public String[] getExitList() {
        return exitList;
    }

    public void setExitList(String[] exitList) {
        this.exitList = exitList;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room exitRoom(String roomID) {
        currentRoom = roomID;
        Room room = readFile(roomID);
        return room;
    }

    public String enterRoom(Room room) {
        return room.getDecription();
    }

    public Room readFile(String roomID) {
//        //Test Lines
//        if (roomID.equalsIgnoreCase("2")) {
//            return new Room("You see iron forged shackles and chains attached to the walls of what appears to be a Prison Cell. There are cracks on the far side of the wall behind the long scroll painting...", "2", "South West North", "none", "N/A", "N/A", "N/A", "1,3");
//        }else if(roomID.equalsIgnoreCase("3")) {
//            return new Room("You see a large corridor with several gargoyles around the room. You also see a crest in the middle of the ground. There are 4 doors around you not including the one you just came in from.", "3", "South West North", "none", "N/A", "N/A", "N/A", "1,2,4,7,8");
//        }else if(roomID.equalsIgnoreCase("4")) {
//            return new Room("For some reason there appears to be a cross on the wall. There is a tapestry covering the wall. The room is split in the middle with seats you can kneel on both sides. Not sure why there is a chapel down here. Looking at the tapestry again, the colors seem to shift...", "4", "South West North", "none", "N/A", "N/A", "N/A", "4,8");
//        }else if(roomID.equalsIgnoreCase("5")) {
//            return new Room("As you enter you notice the temperature dropped and is on the cooler side now. There are barrels stacked on top of one another scattered across the room. Looks like someone found the wine cellar and had a party for themselves.", "5", "South West North", "none", "N/A", "N/A", "N/A", "3,8");
//        }else if(roomID.equalsIgnoreCase("6")) {
//            return new Room("You push a large granite door to get in this room. This small room has almost no furniture. Decorated with large bones, broken stone, and dead vermin all around. The pentagram on the floor covered in blood makes the room seem more like a sacrificial chamber.", "6", "South West North", "none", "N/A", "N/A", "N/A", "4,7");
//        }else if(roomID.equalsIgnoreCase("7")) {
//            return new Room("As you enter this strangely tiny room, you are surrounded by bookcases that are strangely arranged. Only one bookcase is covering the wall, and there are a series of 5 levers off in a corner...", "7", "South West North", "none", "N/A", "N/A", "N/A", "8, 5");
//        }else if(roomID.equalsIgnoreCase("8")) {
//            return new Room("When you enter this room you see that it is rather small. It only has has one chair with several spikes on the seat and the back of the chair. You also see the remains of a fire under the seat. You also spot heavy bags of sand in the corner of the room. This chair doesn't look very comfortable at all", "8", "South West North", "none", "N/A", "N/A", "N/A", "3,6");
//        }else{
//            return new Room("You push a large granite door to get in this room. This small room has almost no furniture. Decorated with large bones, broken stone, and dead vermin all around. The pentagram on the floor covered in blood makes the room seem more like a sacrificial chamber.", "0", "South West North", "none", "N/A", "N/A", "N/A", "3,2");
//        }
        String line = "";
        int wantedLine = Integer.parseInt(roomID);
        System.out.println(wantedLine);
        int lineNo;
        try {
            FileReader fr = new FileReader("C:/Users/Wes McMillen/Desktop/Text-Based Adventure Game/src/entityclasses/PhytextFile.txt");

            BufferedReader br = new BufferedReader(fr);
            for (lineNo = 1; lineNo <= 105; lineNo++) {
                if (lineNo == wantedLine) {
                    line = br.readLine();
                } else
                    br.readLine();
            }
            String[] roomArray = line.split("-");
            for (int i = 0; i < roomArray.length; i++) {
                System.out.println(roomArray[i]);
            }

            String roomsID = roomArray[0];
            String description = roomArray[1];

            String doors = roomArray[2];
            String monsters = roomArray[3];
            String items = roomArray[4];
            String teleporter = roomArray[5];
            String stairs = roomArray[6];
            String exitList = roomArray[7];
            Room newRoom = new Room(description, roomsID, doors, monsters, items, teleporter, stairs, exitList);
            return newRoom;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Room oldRoom = new Room();
        return oldRoom;
    }
}
