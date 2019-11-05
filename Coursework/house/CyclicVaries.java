/**
 * Class: CyclicVaries
 * Type: public class which inherits from Appliance
 * Use: switched on for a cycle;
 * 		uses a variable amount of resources each hour that the appliance is on
 * 
 * @author Stefania Calnuschi
 *
 */
public class CyclicVaries extends Appliance
{
	// float - minimum number of units consumed
	private float minUnitsConsumed;
	// float - maximum number of units consumed
	private float maxUnitsConsumed;
	// float - random number between minUnitsConsumed and maxUnitsConsumed
	private float unitsConsumed;
	// int - the hours is active in a 24-hour period
	private int activeTime;
	// int - checks if the activeTime is less or equal to 24
	private int internalClock;
	
	public CyclicVaries(String name, 
			String utility,
			float inputMin, 
			float inputMax,
			int inputActiveTime)
	{
		super(name,utility);
		minUnitsConsumed = inputMin;
		maxUnitsConsumed = inputMax;
		activeTime = inputActiveTime;
		
		// check if activeTime is between 1 and 24
		if(activeTime <= 24 && activeTime >= 1)
			activeTime = inputActiveTime;
		else
			activeTime=1;
		// resets the internalClock to 1
		internalClock=1;
	}
	
	/**
	 * Method: timePasses()
	 * Type: public void
	 * Use: override timePasses(); 
	 *      calculates how many units this appliance has used this time period
	 */
	public void timePasses()
	{
		// asserts to unitsConsumed a random number within a specified range
		unitsConsumed = getRandomNumber(minUnitsConsumed, maxUnitsConsumed);
		
		// checks if the internalClock is less or equal to activeTime
		if(internalClock<=activeTime)
		{
			// update the Meter associated with the appliance
			tellMeterToConsumeUnits(unitsConsumed);
			// internalClock increases by one each time timePasses is called
			internalClock ++;
			// if internalClock is equal to 25 is reseted to 1
			if(internalClock == 25)
				internalClock = 1;
		}
	}
	
	/**
	 * random number generator for unitsConsumed
	 * @param min
	 * @param max
	 * @return
	 */
	public float getRandomNumber(float min, float max)
	{
		float random = ((float)Math.random() * ((max - min) + 1)) + min;
		return random;
	}
	
}
