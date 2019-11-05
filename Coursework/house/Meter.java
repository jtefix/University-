/**
 * Class: Meter
 * Type: public class
 * Use: represents an object that manages the consumption and production 
 * 		of a particular utility
 * 
 * @author Stefania Calnuschi
 *
 */
public class Meter 
{
	// String - describes the type of utility
	protected String utilityName;
	// double - cost of one unit of this type of utility
	protected double unitCost;
	/**
	 *  float - represents the balance of units that have been used since the
	 *          last meter reading; increase if an appliance consume units and
	 *          decrease if an appliance generates units;
	 */
	protected float meterReading;
	
	// constructor that initialises the values
	public Meter(String inputName,
			double inputCost)
	{
		utilityName = inputName;
		unitCost = inputCost;
		meterReading = 0;
	}
	
	/**
	 * Method: consumeUnits()
	 * Type: public void
	 * Use: adjust meterReading according to noOfUnits 
	 * 
	 * @param noOfUnits
	 */
	public void consumeUnits(float noOfUnits)
	{
		// update meterReading
		meterReading = meterReading + noOfUnits;
	}
	
	/**
	 * Method: report()
	 * Type: public double
	 * Use: prints the utility name and the balance of units used; calculates
	 *      the cost associated by multiplying meterReading by unitCost; reset
	 *      meterReading to zero; returns the cost associated with it
	 * 
	 * @return
	 */
	public double report()
	{
		System.out.println();
		// print the name of the utility 
		System.out.println("Utility name: " + utilityName);
		// print the balance of units that have been used
		System.out.println("Balance of units used: " + meterReading);
		
		double totalCost = 0.0;
		//the associated cost with the meterReading
        if(meterReading > 0)
        	totalCost = unitCost * meterReading; // calculate totalCost
        
		System.out.println("The cost associated: " + totalCost);
		
		setMeterReading(0); // reset meterReading to zero
		
		return totalCost;
	}
	
	/**
	 * setter method for meterReading
	 * @param meterReading
	 */
	protected void setMeterReading(float meterReading)
	{
		this.meterReading = meterReading;
	}
	
	/**
	 * getter method for meterReading
	 * @return
	 */
	protected float getMeterReading()
	{
		return meterReading;
	}
	
	/**
	 * getter method for utilityName
	 * @return
	 */
	protected String getUtilityName()
	{
		return utilityName;
	}
}
