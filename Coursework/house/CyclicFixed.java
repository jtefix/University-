/**
 * Class: CyclicFixed
 * Type: public class which inherits from Appliance
 * Use: switches on for a set a cycle;
 *      uses a fixed amount of resources each hour the appliance is on
 * 
 * @author Stefania Calnuschi
 *
 */
public class CyclicFixed extends Appliance
{
	// float - units that consumes
	private float unitsConsumed;
	// int - the hours is active in a 24-hour period
	private int activeTime;
	// int - checks if the activeTime is less or equal to 24
	private int internalClock;
	
	// constructor
	public CyclicFixed(String name, 
			String utility, 
			float inputUnitsConsumed,
			int inputActiveTime)
	{
		super(name,utility);
		unitsConsumed = inputUnitsConsumed;
		
		// check if activateTime is between 1 and 24
		if(inputActiveTime <= 24 && inputActiveTime >= 1)
			activeTime = inputActiveTime;
		else
			activeTime = 1;
		// resets the internalClock to 1
		internalClock = 1;
	}

	/**
	 * Method: timePasses()
	 * Type: public void
	 * Use: override timePasses(); 
	 *      calculates how many units this appliance has used this time period
	 */
	public void timePasses() 
	{
		// checks if the internalClock is less or equal to activeTime
		if(internalClock <= activeTime)
		{
			// update the Meter associated with the appliance
			tellMeterToConsumeUnits(unitsConsumed);
			// if internalClock is equal to 25 is reseted to 1
			if(internalClock == 25)
				internalClock = 1;
		}
		// internalClock increases by one each time timePasses is called
		internalClock ++;
	}
}
