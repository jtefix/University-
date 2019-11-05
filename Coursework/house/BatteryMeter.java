/**
 * Class: BatteryMeter
 * Type: public class which inherits from Meter
 * Use: creates a Meter with a Battery attached to it and reports totalCost, 
 * 		adds unused energy into the battery
 * 
 * @author Stefania Calnuschi
 *
 */
public class BatteryMeter extends Meter
{
	// new instance of Battery
	private Battery myBattery;
	
	// constructor
	public BatteryMeter(String inputName, double inputCost, Battery inputBattery)
	{
		super(inputName, inputCost);
		myBattery = inputBattery;
	}
	
	public double report()
	{
		System.out.println();
		// print the name of the utility 
		System.out.println("Utility name: " + utilityName);
		// print the balance of units that have been used
		System.out.println("Balance of units used: " + meterReading);
		
		double totalCost = 0.0;
		
		if(meterReading > 0) // meterReading is positive => consumption exceeds production
		{
			/**
			 *  if the difference between meterReading and extraUnits is less or equal to 0
			 *  from extraUnits is subtracted meterReading 
			 *  else the extraUnits are subtracted from meterReading => battery is empty
			 */
			if(meterReading <= myBattery.extraUnits)
			{
				myBattery.extraUnits -= meterReading; 
				setMeterReading(0); // meterReading is set to 0
				System.out.println("Battery has " + myBattery.extraUnits + " units.");
				System.out.println("The cost associated: " + totalCost);
				
				return totalCost;
			}
			else 
			{
				System.out.println("Battery is empty.");
				
				meterReading -= myBattery.extraUnits;
				myBattery.extraUnits = 0; // extraUnits is set to 0
				totalCost = meterReading * unitCost;
				setMeterReading(0); // meterReading is set to 0
				
				System.out.println("The cost associated: " + totalCost);
				return totalCost;
			}
				
		}else // meterReading is negative => production exceeds consumption
		{
			// the excess units are stored in battery
			myBattery.extraUnits -= meterReading;
			System.out.println("Battery has been recharge. Now it has " + myBattery.extraUnits);
			
			if(myBattery.extraUnits > myBattery.capacityLimit) 
			{
				System.out.println("Battery has exceeded capacity limit. "
						+ (myBattery.extraUnits-myBattery.capacityLimit) 
							+ " units are lost.");
				myBattery.extraUnits = myBattery.capacityLimit;
			}
			setMeterReading(0); // meterReading is set to 0
			
			System.out.println("The cost associated: " + totalCost);
			
			return totalCost;
		}
	}
}
