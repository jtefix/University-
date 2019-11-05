import java.util.*;
/**
 * Class: House
 * Type: public
 * Use: will incorporate the Meter and Appliances by having two types of Meter
 *      attached to it
 *           
 * @author Stefania Calnuschi
 *
 */
public class House 
{
	// Meter - electric meter
	private Meter electric;
	// Meter - water meter
	private Meter water;
	
	// constructor for the House
	public House()
	{
		electric = new Meter("electric", 0.013);
		water = new Meter("water", 0.002);
	}
	
	/**
	 * constructor for the House
	 * @param inputElectric
	 * @param inputWater
	 */
	public House(Meter inputElectric, Meter inputWater)
	{
		electric = inputElectric;
		water = inputWater;
	}
	
	/**
	 * ArrayList: Appliances
	 * Type: Appliance
	 * Use: add or remove appliances to the House
	 */
	protected ArrayList<Appliance> appliances = new ArrayList<Appliance>();
	
	/**
	 *  Method: addElectricAppliance
	 *  Type: protected void
	 *  Use: add an appliance to Appliance ArrayList and sets its meter to electric
	 * 
	 * @param specifiedAppliance
	 */
	protected void addElectricAppliance(Appliance specifiedAppliance)
	{
		specifiedAppliance.setMeter(electric);
		appliances.add(specifiedAppliance);
	}
	
	/**
	 * Method: addWaterAppliance
	 * Type: protected void
	 * Use: add an appliance to Appliance ArrayList and sets its meter to water
	 * 
	 * @param specifiedAppliance
	 */
	public void addWaterAppliance(Appliance specifiedAppliance)
	{
		specifiedAppliance.setMeter(water);
		appliances.add(specifiedAppliance);
	}
	
	/**
	 * Method: removeAppliance
	 * Type: public void
	 * Use: removes an appliance from the Appliance ArrayList 
	 * 
	 * @param specifiedAppliance
	 */
	public void removeAppliance(Appliance specifiedAppliance)
	{
		appliances.remove(specifiedAppliance);
	}
	
	/**
	 * Method: numAppliance
	 * Type: public int
	 * Use: returns the number of Appliances in the House
	 * 
	 * @return
	 */
	public int numAppliance()	
	{
		return appliances.size();
	}
	
	/**
	 * Method: activate
	 * Type: public double
	 * Use: simulates one hours passing in the House by calling timePasses on each of the
	 *      appliances in the House once
	 *      
	 * @return
	 */
	public double activate()
	{
		// calls timePasses() on each Appliance from appliances
		for(Appliance app : appliances)
		{
			try
			{
				app.timePasses();
			}catch(Exception e)
			{
				System.out.print(e);
			}
		}
		
		// calls report() on both house meters
		double e = electric.report();
		double w = water.report();
		// returns the sum of the costs reported by both meters
		return (e + w);
	}
	
	/**
	 * Method: activate
	 * Type: public void
	 * Use: simulates the noOfHours passing by calling timePasses() on each of the
	 *      appliances in the House an appropriate number of times
	 * 
	 * @param noOfHours
	 */
	public void activate(int noOfHours)
	{
		// initialize the totalCost to 0.0
		double totalCost = 0.0;
		
		// after each hour calls activate() and adds the cost to the totalCost
		for(int i = 1; i <= noOfHours; i++)
		{
			totalCost += activate();
		}
		//prints the totalCost
		System.out.println("Total cost: " + totalCost);
	}
	
	
	public static void main(String[] args)
	{
		// Battery - with the capacity equals to 5
		Battery battery = new Battery(7);
		// initialize the House meters
		Meter electric = new BatteryMeter("electric", 0.013, battery);
		Meter water = new Meter("water", 0.002);
		
		// House - new instance of a House
		House myHouse = new House(electric, water);
	    // HomeReader - new instance of a HomeReader
		HomeReader reader = new HomeReader("Config File.txt");
		
		// ArrayList<Appliance> - new ArrayList with appliances
		ArrayList<Appliance> appliances = new ArrayList<Appliance>(); 
		// call applianceReader() on appliances
		appliances = reader.applianceReader();
		
		// for each appliance print its name
		for(Appliance app : appliances)
		{
			System.out.println("Appliance name: " + app.getName());
			
			// checks if the appliance has an electric or water meter and the calls 
			// addElectricAppliance() or addWaterAppliance(), respectively
			if(app.utility.equals("electric"))
				myHouse.addElectricAppliance(app);
			else 
				if(app.utility.equals("water"))
					myHouse.addWaterAppliance(app);
		}
		
		// simulate one hours
		myHouse.activate();
		// simulate one week
		myHouse.activate(7*24);
	}
}
