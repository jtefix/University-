import java.util.Random;

/** 
 * Class: RandomFixed
 * Type: public class that inherits from Appliance
 * Use: switched on at a random time of the day;
 * 		consumes a fixed amount of resources each time is switched on
 * 
 * @author Stefania Calnuschi
 *
 */
public class RandomFixed extends Appliance
{
	// float - units that consumes
	private float unitsConsumed;
	// int - the probability is switched on
	private int probability;
	// boolean - true if the appliance is on, false if the appliance is off
	boolean OnOff;
	
	// constructor for RandomFixed
	public RandomFixed(String name, 
			String utility,
			float inputUnits,
			int inputProbability)
	{
		super(name,utility);
		unitsConsumed = inputUnits;
		probability = inputProbability;

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
		
        // if checkProbability is 1 means that the appliance is on
		if(checkProbability == 1) 
		{		
			// update the Meter associated with the appliance
			tellMeterToConsumeUnits(unitsConsumed);
			OnOff = true;
		}else
			OnOff = false;
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
