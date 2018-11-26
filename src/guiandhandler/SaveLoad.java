import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class SaveLoad 
{
	Properties prop = new Properties();
	InputStream input = null;
	OutputStream output = null;

	/**
	 * Name: writeinfo
	 * This method writes the username and password to the textfile.
	 * 
	 */
	public void writeinfo()
	{
		try
		{
			FileWriter fw = new FileWriter("text file goes here");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("username");
			pw.println("Password");
		
			
			
			pw.close();
		}catch (IOException e)
		{
			System.out.println("ERROR!");
		}
	}
	/**
	 * Writes the values to the textfile.
	 */
	public void writevalue()
	{
		try
		{
			FileWriter fw = new FileWriter("text file goes here");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("Alo");
			pw.println("Password1");
		
			
			
			pw.close();
		}catch (IOException e)
		{
			System.out.println("ERROR!");
		}
	}
/**
 * Reads the username and password along with their specific values.
 */
	public void readinfovalue()
	{
		try {

			output = new FileOutputStream("text file goes here");

			// set the properties value
			prop.setProperty("username", "Alo");
			prop.setProperty("password", "password1");
			
			
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
	public void loadvalue()
	{
		
	try {

		input = new FileInputStream("text file goes here");

		// load a properties file
		prop.load(input);

		//get the property value and print it out
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));

	} catch (IOException e) {
		e.printStackTrace();
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
	public static void main(String [] args) 
	{
		SaveLoad save = new SaveLoad();
		save.writeinfo();
		save.writevalue();
		save.readinfovalue();
		save.loadvalue();
		
	}

}
