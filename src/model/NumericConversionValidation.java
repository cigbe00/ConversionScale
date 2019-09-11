/**
 * 
 */
package model;

/**
 * @author chuksigbe
 * 
 * @implNote
 * Defines validation method for user input
 *
 */
public class NumericConversionValidation {
	
	public boolean isNumericValueValid(String input)
	{
		if(input == "")
		{
			System.out.println("Input number must be entered");
			return false;
		}
		try{
		    @SuppressWarnings("unused")
			float inputValue = Float.parseFloat(input);
		}catch (NumberFormatException ex) {
		    //handle exception here
			System.out.println("Invalid number format entered!!");
			return false;
		}
		return true;
	}
	
	public boolean isUnitMeasureValid(String input)
	{
	
		if(input == "")
		{
			System.out.println("UnitMeasure must be entered");
			return false;
		}
		else if(input.equalsIgnoreCase("Kelvin")|| input.equalsIgnoreCase("Celsius") || input.equalsIgnoreCase("Fahrenheit")|| input.equalsIgnoreCase("Rankine") || input.equalsIgnoreCase("liters") || input.equalsIgnoreCase("tablespoons")||input.equalsIgnoreCase("cubic-inches")||input.equalsIgnoreCase("cups")|| input.equalsIgnoreCase("cubic-feet")||input.equalsIgnoreCase("gallons") )
		{
			return true;
		}
		else {
			System.out.println("Invalid Unit measure entered!");
			return false;
		}
		
	}
	
	public boolean isTargetMeasureValid(String input)
	{
		
		if(input == "")
		{
			System.out.println("Target Measure must be entered");
			return false;
		}
		else if(input.equalsIgnoreCase("Kelvin")|| input.equalsIgnoreCase("Celsius") || input.equalsIgnoreCase("Fahrenheit")|| input.equalsIgnoreCase("Rankine") || input.equalsIgnoreCase("liters") || input.equalsIgnoreCase("tablespoons")||input.equalsIgnoreCase("cubic-inches")||input.equalsIgnoreCase("cups")|| input.equalsIgnoreCase("cubic-feet")||input.equalsIgnoreCase("gallons") )
		{
			return true;
		}
		else {
			System.out.println("Invalid Unit measure entered!");
			return false;
		}
	}
	
	public boolean isStudentResponseValid(String input)
	{
		if(input == "")
		{
			System.out.println("Student response must be entered");
			return false;
		}
		try{
		    @SuppressWarnings("unused")
			float inputValue = Float.parseFloat(input);
		}catch (NumberFormatException ex) {
		    //handle exception here
			System.out.println("Invalid numeric format entered!!");
			return false;
		}
		return true;
	}
	
	

}
