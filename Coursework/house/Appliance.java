/**
 * Class: Appliance
 * Type: public abstract
 * Use: defines the basic properties and methods that all different appliances
 *      classes will need
 * Appliances classes: CyclicFixed, CyclicVaries, RandomFixed, RandomVaries
 * 
 * @author Stefania Calnuschi
 *
 */
public abstract class Appliance 
{
	// String - name of this appliance
	private String name;
	// String - name of the meter
	protected String utility;
	// Meter - meter this appliances uses to record consumption and production
	Meter meter;
	
	// constructor that initialise this Appliance with a name
	public Appliance(String inputName, String inputUtility)
	{
		name= inputName;
		utility = inputUtility;
	}
	
	// public setter method to set the meter (electric or water)
	public void setMeter(Meter inputMeter)
	{
		// checks if the meter is either electric or water and throws exceptions
		meter = inputMeter;
		try
		{
			if(!(meter.utilityName.equals(utility)))
				throw new Exception("Error: wrong meter");
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	}
	
	/**
	 * Method: timePasses
	 * Type: abstract void
	 * Use: denotes one hour
	 */
	abstract void timePasses();
	
	/**
	 * Method: tellMeterToConsumeUnits
	 * Type: protected void
	 * Use: updates the Meter associated with the appliance by calling consumeUnits
	 * 
	 * @param units
	 */
	protected void tellMeterToConsumeUnits(float units)
	{
		meter.consumeUnits(units);
	}

	/**
	 * getter method for the name of the appliance
	 * @return
	 */
	public String getName() {
		return name;
	}

}
