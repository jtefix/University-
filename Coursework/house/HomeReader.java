import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Class: HomeReader
 * Type: public class
 * Use: reads the file and stores information about appliances
 * 
 * @author Stefania Calnuschi
 *
 */
public class HomeReader 
{
	// BufferedReader - helps us to read from the file
	private BufferedReader reader;
	
	// constructor for HomeReader
	public HomeReader(String inputFile)
	{
		// throws exception if file is not found
		try {
			if(!inputFile.substring(inputFile.indexOf(".")).equals(".txt"))
				throw new IOException("Error: wrong file type");
			reader = new BufferedReader(new FileReader(new File(inputFile)));
			// reads from the file
		} 
		catch (FileNotFoundException e) {
			System.err.println(e);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	/**
	 * readLine method which returns the next line from the text file
	 * 
	 * @return
	 */
	protected String readLine() 
	{
		String line;
		// throws exception if it has no more lines to read
		try {
			line = reader.readLine();
			return line;
		}
		catch(Exception e){
			System.err.println(e);
		}
		return null;
	}
	
	/**
	 * Method: applianceReader
	 * Type: protected ArrayList
	 * Use: reads the file and memorises each appliance found
	 * 
	 * @return
	 */
	protected ArrayList<Appliance> applianceReader() 
	{
		// String - the next line to read from the file
		String s;
		// int - the counter will be reseted each time a new appliance is found
		int counter;
		String name = null; // appliance name
		String subclass = null; // appliance subclass
		String meter = null; // appliance meter
		String min = null; // appliance min
		String max = null; // appliance max
		String fixed = null; // appliance fixed
		String prob = null; // appliance prob
		String cycle = null; // appliance cycle
		// ArrayList<Appliance> - where the appliances from the file will be stored
		ArrayList<Appliance> appliances = new ArrayList<Appliance>();

		/**
		 * while you can read another line from the file;
		 * the counter is initiliazed to 1;
		 * while the next line is not empty, the line is splitted into strings depending on ":";
		 * depending on value of the counter either name, subclass, meter, min, max, fixed, prob or cycle
		 * will get the trimmed split String;
		 * some of them are stored or not depending on the subclass
		 */
		while((s = readLine()) != null) {
			counter = 1;
			while(s.length() != 0) {
				String[] split = s.split(":");
				switch(counter)
				{
					case 1:
						name = split[1].trim();
						break;

					case 2: 
						subclass = split[1].trim();
						break;

					case 3:	
						meter = split[1].trim();
						break;
						
					case 4: 
						min = null;
						if (subclass.equals("CyclicVaries") || subclass.equals("RandomVaries"))				
							min = split[1].trim();
						break;
					
					case 5: 
						max = null;
						if (subclass.equals("CyclicVaries") || subclass.equals("RandomVaries"))				
							max = split[1].trim();
						break;
					
					case 6: 
						fixed = null;
						if (subclass.equals("CyclicFixed") || subclass.equals("RandomFixed"))			
							fixed = split[1].trim();
						break;
					
					case 7: 
						prob = null;
						if (subclass.equals("RandomFixed") || subclass.equals("RandomVaries"))
							prob = split[1].trim().substring(split[1].indexOf("in ") + 2);
						break;
				
					case 8: 
						cycle = null;
						if (subclass.equals("CyclicFixed") || subclass.equals("CyclicVaries"))				
							cycle = split[1].trim().substring(0, split[1].indexOf("/") - 1);
						break;
				}
				
				counter ++;
				// if the next line does not exist, stop
				if ((s = readLine()) == null)
					break;
			}
			// the Strig[] details will store the new strings
			String[] details = {name, subclass, meter, min, max, fixed, prob, cycle};
			// applianceMaker() is called passing details as a parameter;
			// applianceMaker() will add the new appliance to the ArrayList
			appliances.add(applianceMaker(details));
		}
		
		return appliances;
	}
	
	/**
	 * Method: applianceMaker
	 * Type: public Appliance
	 * Use: makes a new appliance depending on if is a CyclicFixed, CyclicVaries, RandomFixed or RandomVaries appliance
	 * 
	 * @param details
	 * @return
	 */
	public Appliance applianceMaker(String[] details) 
	{	
		Appliance app = null;
		
		switch(details[1]) 
		{
			case "CyclicFixed":
				app = new CyclicFixed(details[0],details[2],Float.parseFloat(details[5]),Integer.parseInt(details[7]));
				break;
			
			case "CyclicVaries":
				app = new CyclicVaries(details[0],details[2],Float.parseFloat(details[3]),Float.parseFloat(details[4]),Integer.parseInt(details[7]));
				break;
			
			case "RandomFixed":
				app = new RandomFixed(details[0],details[2],Float.parseFloat(details[5]),Integer.parseInt(details[6]));
				break;
			
			case "RandomVaries":
				app = new RandomVaries(details[0],details[2],Float.parseFloat(details[3]),Float.parseFloat(details[4]),Integer.parseInt(details[6]));
				break;
		}
		return app;
	}
}
