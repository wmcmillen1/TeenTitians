import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class SaveLoad 
{
	Properties prop = new Properties();
	InputStream input = null;
	OutputStream output = null;

	public void save() 
	{
		try {

			output = new FileOutputStream("Put Text File Here");

			// set the properties value
			// input code here
			

			// saves the properties to project root folder
			prop.store(output, null);

		} catch (IOException e) {
			e.printStackTrace();
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

	public void load() {
		try {

			input = new FileInputStream("Put Text File Here");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			//input code here
			

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
		SaveandLoad save = new SaveandLoad();
		SaveandLoad load = new SaveandLoad();
		save.save();
		load.load();
}
}
