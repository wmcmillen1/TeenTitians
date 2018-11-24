package TeenTitians.src;

import TeenTitians.src.guiandhandler.NavigationGUI;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Login {
    private String userName;
    private String password;
    private File file;



    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
        URL url = getClass().getResource("savestate.txt");
        try {
            file = new File(url.toURI()  );
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public Login() {
        userName = "";
        password = "";
        URL url = getClass().getResource("savestate.txt");
        try {
            file = new File(url.toURI()  );
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeLoginInfo() throws IOException {
        //on odd # line write username.password
        String str = userName + "." + password + "\n";
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.write(str);
        writer.close();
    }

    public void writeSaveFile(String roomID) throws IOException {
        //on even # lines write current room number and Inventory
        String str = roomID;
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.write(str);
        writer.close();
    }

    public int readLoginInfo () {
        //on odd # lines read username.password, if they don't match current instance, then move to next odd # line
        int lineNo;
        try {
            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            for (lineNo = 1; lineNo <= 105; lineNo++) {
                if (br.readLine().equals(userName + "." + password)) {
                    br.readLine();
                    return lineNo;
                } else
                    br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String readSaveFile(int wantedLine) {
        //run readLoginInfo, when successful:
        //on next lines read to current room number and Inventory
        int lineNo;
        String line = "";
        if (wantedLine == 1) {
            return null;
        }
        try {

            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            for (lineNo = 1; lineNo <= 105; lineNo++) {
                if (lineNo == wantedLine) {
                    line = br.readLine();
                } else
                    br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //String[] newStringArray = line.split(".");

        return line;
    }
}
