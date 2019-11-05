import java.util.Random;

/**
 * Name: RandomVaries
 * Type: public class which inherits from AppLiance
 * Use: switched on at a random time of the day;
 * 		consumes a variable amount of resources each time is switched on
 * 
 * @author Stefania Calnuschi
 *
 */
public class RandomVaries extends Appliance
{
	// float - minimum number of units consumed
	private float minUnitsConsumed;
	// float - maximum number of units consumed
	private float maxUnitsConsumed;
	// float - random number between minUnitsConsumed and maxUnitsConsumed
	private float unitsConsumed;
	// int - the probability is switched on
	private int probability;
	// boolean - true if the appliance is on, false if the appliance is off
	private boolean OnOff;
	
	// constructor for RandomVaries
	public RandomVaries(String name, 
			String utility, 
			float inputMin,
			float inputMax,
			int inputProbability)
	{
		super(name,utility);
		probability = inputProbability;
		minUnitsConsumed = inputMin;
		maxUnitsConsumed = inputMax;
	}
	
	/**
	 * Method: timePasses()
	 * Type: public void
	 * Use: override timePasses(); 
	 *      calculates how many units this appliance has used this time period
	 */
	public void timePasses()
	{
		// checkProbability gets a random number within 1 and probability
		int checkProbability = getRandomNumber(probability);
		// asserts to unitsConsumed a random number within a specified range
		unitsConsumed = getRandomNumber(minUnitsConsumed, maxUnitsConsumed);
		
		// if checkProbability is 1 means that the appliance is on
		//if(random.nextInt(probability) == 0) 
		if(checkProbability == 1)
		{		
			// updates the Meter associated with the appliance
			tellMeterToConsumeUnits(unitsConsumed);
			OnOff = true;
		}else
			OnOff = false;
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
	
	/**
	 * random number generator for checkProbability
	 * @param inputProb
	 * @return
	 */
	public int getRandomNumber(int inputProb)
	{
		int random = ((int)(Math.random() * inputProb) + 1);
		return random;
	}
}