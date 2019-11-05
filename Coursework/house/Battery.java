/**
 * Class: Battery 
 * Type: public class
 * Use: ability to store a utility
 *      has a capacityLimit 
 *      has extraUnits which is the units that get stored in battery
 * 
 * @author Stefania Calnuschi
 *
 */
public class Battery
{
	// float - the capacity of the battery
	protected float capacityLimit;
	// float - the units that get stored in battery
	protected float extraUnits; 

	// constructor
	protected Battery(float inputCapacity)
	{
		capacityLimit = inputCapacity;
		extraUnits = 0;
	}
}
