/* abstract class Appliance
 * defines the basic properties and methods
 * that all the different appliance classes
 * CyclicFixed, CyclicVaries, RandomFixed, RandomVaries
 */
public abstract class Appliance 
{
	/* name of the appliance
	 * class variable
	 */
	static String name;
	// record the consumption and production
	Meter meter;
	
	// constructor that initialises the Appliance with a name
	public Appliance(String inputName)
	{
		name = inputName;
	}
	
	// setter method to set meter
	public void setMeter(Meter inputMeter)
	{
		meter = inputMeter;
	}
	
	// abstract method
	abstract double timePasses();
	
	protected void tellMeterToConsumeUnits(float units)
	{
		meter.consumeUnits(units);
	}
	
	public static void main(String[] args)
	{
		Appliance Fridge = new CyclicFixed(2.5, 4);
		Meter electricity = new Meter("electricity", 2.0, 5);
		
		Fridge.setMeter(electricity);
		Fridge.timePasses();
		electricity.report();
	}
}
