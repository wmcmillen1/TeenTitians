package TeenTitians.src.entityclasses;

import jdk.nashorn.internal.ir.IfNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
//Room class by Wesley
public class Room {


    //exit enter//
    private String description;
    private String roomID;
    private String doors;
    private String monsters;
    private String items;
    private String teleporter;
    private String puzzleLandmark;
    private String[] exitList;

    //Allows you to jump to any room.
    public boolean DEBUG_MODE = true;


    public Room(String description, String roomID, String doors, String monsters, String items, String teleporter, String puzzle, String exitList) {
        this.description = description;
        this.roomID = roomID;
        this.doors = doors;
        this.monsters = monsters;
        this.items = items;
        this.teleporter = teleporter;
        this.puzzleLandmark = puzzle;
        this.exitList = exitList.split(",");
    }

    public Room (String roomID)
    {
        Room room = readFile(roomID);

        this.description = room.description;
        this.roomID = room.roomID;
        this.doors = room.doors;
        this.monsters = room.monsters;
        this.items = room.items;
        this.teleporter = room.teleporter;
        this.puzzleLandmark = room.puzzleLandmark;
        this.exitList = room.exitList;
    }

    public Room() {
        description = "You open your eyes to a smoky room. As your eyes wander up you see tall dirt walls and the moon�s shine bursting through the crevice. You realize that you are in a ditch with only two doors to exit one on your right and one directly in front of you.";
        roomID = "1";
        doors = "You see an exit leading South.";
        monsters = "none";
        items = "N/A";
        teleporter = "N/A";
        puzzleLandmark = "N/A";
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

    public String getPuzzleLandmark() {
        return puzzleLandmark;
    }

    public void setStairs(String puzzle) {
        this.puzzleLandmark = puzzle;
    }

    public String[] getExitList() {
        return exitList;
    }

    public void setExitList(String[] exitList) {
        this.exitList = exitList;
    }


    public Room exitRoom(String roomID) {
        Room room;
        if (roomID.contains("SR")) {
            boolean isSecretRoom = false;
            for (int i = 0; i < exitList.length; i++) {
                if (exitList[i].contains("SR")) {
                    isSecretRoom = true;

                }
            }
            if (isSecretRoom) {
                if (roomID.charAt(roomID.length()-1) == '1' && exitList[exitList.length-1].contains("1")) {
                    return room = new Room("28");
                } else if (roomID.charAt(roomID.length() - 1) == '2' && exitList[exitList.length-1].contains("2")) {
                    return room = new Room(roomID = "29");
                } else if (roomID.charAt(roomID.length() - 1) == '3' && exitList[exitList.length-1].contains("3")) {
                    return room = new Room(roomID = "30");
                } else if (roomID.charAt(roomID.length() - 1) == '4' && exitList[exitList.length-1].contains("4")) {
                    return room = new Room("31");
                } else if (roomID.charAt(roomID.length() - 1) == '5' && exitList[exitList.length-1].contains("5")) {
                    return room = new Room("32");
                } else if (roomID.charAt(roomID.length() - 1) == '6' && exitList[exitList.length-1].contains("6")) {
                    return room = new Room("33");
                } else if (roomID.charAt(roomID.length() - 1) == '7' && exitList[exitList.length-1].contains("7")) {
                    return room = new Room("34");
                }
            }
        }
        String newRoomID = "";
        for (int i = 0; i < roomID.length(); i++) {
                //IF current character is an interger, than add it to newRoomID
            if (roomID.charAt(i) == '1' || roomID.charAt(i) == '2' || roomID.charAt(i) == '3' || roomID.charAt(i) == '4' || roomID.charAt(i) == '5' || roomID.charAt(i) == '6' || roomID.charAt(i) == '7' || roomID.charAt(i) == '8' || roomID.charAt(i) == '9' || roomID.charAt(i) == '0') {
                newRoomID += roomID.charAt(i);
            }
        }
        String tempFilter = "";
        for (int h = 0; h < exitList.length; h++) {
            tempFilter = "";
            for (int i = 0; i < exitList[h].length(); i++) {
                if (exitList[h].charAt(i) == '1' || exitList[h].charAt(i) == '2' || exitList[h].charAt(i) == '3' || exitList[h].charAt(i) == '4' || exitList[h].charAt(i) == '5' || exitList[h].charAt(i) == '6' || exitList[h].charAt(i) == '7' || exitList[h].charAt(i) == '8' || exitList[h].charAt(i) == '9' || exitList[h].charAt(i) == '0') {
                    tempFilter += exitList[h].charAt(i);
                }
            }
            if (newRoomID.equals(tempFilter)) {
                room = readFile(newRoomID);
                return room;
            }
        }
        room = new Room(this.roomID);
        return room;

    }

    public String[] addExit (String newExit) {
        String[] newList = new String[exitList.length + 1];
        for (int i = 0; i < exitList.length; i++) {
            newList[i] = exitList[i];
        }
        newList[newList.length -1] = newExit;
        return newList;
    }

    public String enterRoom(Room room) {
        return room.getDecription();
    }

    public Room readFile(String roomID) {
        String newRoomID = "";
        for (int i = 0; i < roomID.length(); i++) {
            //IF current character is an interger, than add it to newRoomID
            if (roomID.charAt(i) == '1' || roomID.charAt(i) == '2' || roomID.charAt(i) == '3' || roomID.charAt(i) == '4' || roomID.charAt(i) == '5' || roomID.charAt(i) == '6' || roomID.charAt(i) == '7' || roomID.charAt(i) == '8' || roomID.charAt(i) == '9' || roomID.charAt(i) == '0') {
                newRoomID += roomID.charAt(i);
            }
        }

        String line = "";
        int wantedLine = Integer.parseInt(newRoomID);

        int lineNo;
        try {
            URL url = getClass().getResource("PhytextFile.txt");
            File file = null;
            try {
                file = new File(url.toURI()  );
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            for (lineNo = 1; lineNo <= 105; lineNo++) {
                if (lineNo == wantedLine) {
                    line = br.readLine();
                } else
                    br.readLine();
            }
            String[] roomArray = line.split("-");


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
