public class CyclicFixed extends Appliance
{
	// how many units it consumes
	double unitsConsumed;
	// for how long in a 24 hour period it is active
	int howLong;
	
	// create constructor
	public CyclicFixed(double inputUnitsConsumed, int inputHowLong)
	{
		super(name);
		unitsConsumed = inputUnitsConsumed;
		howLong = inputHowLong;
		
		if(howLong > 24 && howLong < 1)
		{
			howLong = inputHowLong;
		}
	}
	
	// override timePasses
	public double timePasses()
	{
		double x = howLong;
		// calculate how many units this appliance used
		x *= unitsConsumed;
		
		return x;
	}
}
