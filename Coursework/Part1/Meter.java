/* create Meter class
 * an object that manages the consumption and production
 * of a particular utility
 */
public class Meter 
{
	// describes the type of utility
	private String utilityName;
	//the cost of one unit of this type of utility
	private double unitCost;
	/*the balance of units that have been used since
	 * the last meter reading and will be increased whenever
	 * an appliance consumes units and decreased every time 
	 * an appliance generates units
	 */
	private float meterReading = 0;
	
	// constructor that initialises the values
	public Meter(String inputName, 
			double inputCost, 
			float inputReading)
	{
		utilityName = inputName;
		unitCost = inputCost;
		meterReading = inputReading;
	}
	
	// adjust meterReading appropriately
	public float consumeUnits(float noOfUnitsConsumed)
	{
		meterReading += noOfUnitsConsumed;
		return meterReading;
		
	}
	
	/* report the amount of units of the utility that 
	 * have been used and the corresponding cost incurred
	 * to the home occupier
	 */
	public double report()
	{
		//print the name of the utility
		System.out.println("Utility name: " + utilityName);
		//print the balance of units that have been used
		System.out.println("Balance of units used: " + meterReading);
		//the associated cost with the meter reading
		double x = unitCost * meterReading;
		System.out.println("The cost associated: " + x);
		
		meterReading = 0; // reset meterReading to zero
		
		return x;
	}
	
	
}
