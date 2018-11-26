package TeenTitians.src;

import TeenTitians.src.guiandhandler.NavigationGUI;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

public class Login {
    private String userName;
    private String password;


    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Login() {
        userName = "";
        password = "";
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

//Code beyond Created by Austin
    Properties prop = new Properties();
    InputStream input = null;
    OutputStream output = null;

    /**
     * Name: writeinfo
     * This method writes the username and password to the textfile.
     */
    public void writeInfo() {
        try {
            FileWriter fw = new FileWriter("src/TeenTitians/src/savestate.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(userName + "/" + password);
            //pw.println("Password");


            pw.close();
        } catch (IOException e) {
            System.out.println("ERROR!");
        }
    }

    /**
     * Writes the values to the textfile.
     */
    public void writeValue() {
        try {
            FileWriter fw = new FileWriter("src/TeenTitians/src/savestate.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Alo. 333");
            //pw.println("Password1");


            pw.close();
        } catch (IOException e) {
            System.out.println("ERROR!");
        }
    }

    /**
     * Reads the username and password along with their specific values.
     */
    public void readInfoValue( String roomID, String inventory) {
        try {

            output = new FileOutputStream("src/TeenTitians/src/savestate.txt");

            // set the properties value
            prop.setProperty(userName + "/" + password, roomID +"/" + inventory);
            //prop.setProperty("password", "password1");


            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This method simply loads the the values to the console.
     * This does not have to be used in the overall code.
     */
    public String loadvalue() {

        try {

            input = new FileInputStream("src/TeenTitians/src/savestate.txt");

            // load a properties file
            prop.load(input);

            //get the property value and print it out
            return (prop.getProperty(userName + "/" + password));
            //System.out.println(prop.getProperty("password"));

        } catch (IOException e) {
            e.printStackTrace();
            return "LOADERROR";
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}