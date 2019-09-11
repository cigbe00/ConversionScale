
package driver_classes;

import java.util.Scanner;

import controller.NumericConversionController;
import model.NumericConversionModel;
import model.NumericConversionValidation;
import view.NumericConversionView;

/**
 * @author chuksigbe
 *
 */
public class NumericConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("****************************************************************");
		System.out.println("****************************************************************");
		System.out.println("****************************************************************");
		System.out.println("****************************************************************");
		System.out.println("*-------------------Conversion Calculator----------------------*");
		System.out.println("*-------------------By Chukwudi Igbe---------------------------*");
		System.out.println("*                           *");
		System.out.println("*>>>>>>>>Temperature Scale:<<<<<<<<<<*");
		System.out.println("*-----------------Between Kelvin, Celsius, Fahrenheit, and Rankine----------------------*");
		System.out.println("              ");
		System.out.println("*>>>>>>>>>>>Volume Scale<<<<<<<<<<<<<<*");
		System.out.println("              ");
		System.out.println("*------------------------between liters, tablespoons, cubic-inches, cups, cubic-feet, and gallons-------------------*");
		System.out.println("           ");
		System.out.println("*>>>>>>>>>>>>>>>>>All Answers must be to 2 decimal places<<<<<<<<<<<<<<<<<<*");
		System.out.println("           ");
		System.out.println("****************************************************************");
		System.out.println("****************************************************************");
		System.out.println("****************************************************************");
		System.out.println("****************************************************************");
		System.out.println("                    ");
		
		//Fetch inputs from user:
		NumericConversionModel data = retrieveInfo();
		
		//Write details in data to console:
		NumericConversionView display = new NumericConversionView();
		NumericConversionController handler = new NumericConversionController(data, display);
		
		handler.updateDisplay();
		

	}
	
	private static NumericConversionModel retrieveInfo()
	{
		NumericConversionModel data = new NumericConversionModel();
		
		 /* This reads the input provided by user
         * using keyboard
         */
		Scanner in = new Scanner(System.in);
		
		//Initialize validation class
		NumericConversionValidation val = new NumericConversionValidation();
		
		//Get number to convert
		System.out.println("Enter the Numeric Value to converted:  ");
        String inputValue = in.nextLine();
        boolean result = val.isNumericValueValid(inputValue);
        if( result == true)
        {
        	System.out.println("You entered Numeric value "+inputValue);
        	float inputV = Float.parseFloat(inputValue);
        	data.set_number_to_convert(inputV);
        }
        
        
        else {
        	int count = 0;
        	while(result == false && count<3)
        	{
	        	System.out.println("Enter the Numeric Value to converted:  ");
	            inputValue = in.nextLine();
	            result = val.isNumericValueValid(inputValue);
	            float inputV = Float.parseFloat(inputValue);
	            data.set_number_to_convert(inputV);
	            count++;
        	}
        	if(count>=3)
        	{
	        	System.out.println("   ");
	        	System.out.println("Number of retries exceeded!... Exiting");
	        	System.out.println("   ");
	        	in.close();
	        	System.exit(1);;
        	}
        }
        
        //Get Unit Measure
        System.out.println("Enter the Unit of Measure Value:  ");
        String inputmeasure = in.nextLine();
        
        boolean resultmeasure = val.isUnitMeasureValid(inputmeasure);
        
        if( resultmeasure == true)
        {
        	System.out.println("You entered Unit Measure: "+inputmeasure);
        	
        	data.set_unit_of_measure(inputmeasure);
        }
        else {
        	
        	int count = 0;
        	while(resultmeasure == false && count<3)
        	{
	        	System.out.println("Enter the Unit of Measure Value:  ");
	            inputmeasure = in.nextLine();
	            resultmeasure = val.isUnitMeasureValid(inputmeasure);
	            count++;
        	}
        	if(count>=3)
        	{
	        	System.out.println("   ");
	        	System.out.println("Number of retries exceeded!... Exiting");
	        	System.out.println("   ");
	        	in.close();
	        	System.exit(1);;
        	}
        }
        
      //Get Target Measure
        System.out.print("Enter the Target of Measure Value:  ");
        System.out.println(" ");
        String inputarget = in.nextLine();
        boolean resulttarget = val.isTargetMeasureValid(inputarget);
        if( resulttarget == true)
        {
        	System.out.println("You entered Target Measure: "+inputarget);
        	System.out.println(" ");
        	data.set_target_unit(inputarget);
        }
        else {
        	int count = 0;
        	while(resulttarget == false && count < 3)
        	{
		    	System.out.println("Enter the Target of Measure Value:  ");
		    	System.out.println(" ");
		        inputarget = in.nextLine();
		        resulttarget = val.isTargetMeasureValid(inputarget);
		        count++;
        	}
        	if(count>=3)
        	{
	        	System.out.println("   ");
	        	System.out.println("Number of retries exceeded!... Exiting");
	        	System.out.println("   ");
	        	in.close();
	        	System.exit(1);;
        	}
        }
        
        
      //Get Student Response value
        System.out.println("Enter the Student's Response:  ");
        System.out.println(" ");
        String inputresponse = in.nextLine();
        boolean resultresponse = val.isStudentResponseValid(inputresponse);
        if( resultresponse == true)
        {
        	System.out.println("You entered Student's response value "+inputresponse);
        	float inputVr = Float.parseFloat(inputresponse);
        	data.set_student_response(inputVr);
        }
        else {
        	int count=0;
        	while(resultresponse == false && count < 3)
        	{
	        	System.out.println("Enter the Student's Response:  ");
	            inputresponse = in.nextLine();
	            resultresponse = val.isStudentResponseValid(inputresponse);
	            float inputVr = Float.parseFloat(inputresponse);
	        	data.set_student_response(inputVr);
	            count++;
        	}
        	if(count>=3)
        	{
	        	System.out.println("   ");
	        	System.out.println("Number of retries exceeded!... Exiting");
	        	System.out.println("   ");
	        	in.close();
	        	System.exit(1);;
        	}
        }
        in.close();
        
        
        
		if(data.get_unit_of_measure().equalsIgnoreCase("Kelvin") && data.get_target_unit().equalsIgnoreCase("Celsius"))
		{
			float oup = data.KelvinToCelsius(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}
//			System.out.println("Output is: "+data.KelvinToCelsius(data.get_number_to_convert()));
//			System.out.println("Answer status is: "+data.get_status());
			
			
		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Celsius") && data.get_target_unit().equalsIgnoreCase("Kelvin"))
		{
			float oup = data.CelsiusToKelvin(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Kelvin") && data.get_target_unit().equalsIgnoreCase("Fahrenheit"))
		{
			float oup = data.KelvinToFahrenheit(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Fahrenheit") && data.get_target_unit().equalsIgnoreCase("Kelvin"))
		{
			float oup = data.FahrenheitToKelvin(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Kelvin") && data.get_target_unit().equalsIgnoreCase("Rankine"))
		{
			float oup = data.KelvinToRankie(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Rankine") && data.get_target_unit().equalsIgnoreCase("Kelvin"))
		{
			float oup = data.RankieToKelvin(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Celsius") && data.get_target_unit().equalsIgnoreCase("Fahrenheit"))
		{
			float oup = data.CelsiusToFahrenheit(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Fahrenheit") && data.get_target_unit().equalsIgnoreCase("Celsius"))
		{
			float oup = data.FahrenheitToCelsius(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Celsius") && data.get_target_unit().equalsIgnoreCase("Rankine"))
		{
			float oup = data.CelsiusToRankie(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Rankine") && data.get_target_unit().equalsIgnoreCase("Celsius"))
		{
			float oup = data.RankieToCelsius(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Fahrenheit") && data.get_target_unit().equalsIgnoreCase("Rankine"))
		{
			float oup = data.FahrenheitToRankie(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("Rankine") && data.get_target_unit().equalsIgnoreCase("Fahrenheit"))
		{
			float oup = data.FahrenheitToRankie(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("liters") && data.get_target_unit().equalsIgnoreCase("tablespoons"))
		{
			float oup = data.LiterstoTablespoons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("tablespoons") && data.get_target_unit().equalsIgnoreCase("liters"))
		{
			float oup = data.TablespoonsToLiters(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("liters") && data.get_target_unit().equalsIgnoreCase("cubic-inches"))
		{
			float oup = data.LitersTocubic_inches(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-inches") && data.get_target_unit().equalsIgnoreCase("liters"))
		{
			float oup = data.cubic_inchesToLiters(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("liters") && data.get_target_unit().equalsIgnoreCase("cups"))
		{
			float oup = data.LitersTocups(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cups") && data.get_target_unit().equalsIgnoreCase("liters"))
		{
			float oup = data.cupsToLiters(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("liters") && data.get_target_unit().equalsIgnoreCase("cubic-feet"))
		{
			float oup = data.LitersTocubic_feet(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-feet") && data.get_target_unit().equalsIgnoreCase("liters"))
		{
			float oup = data.LitersTocubic_feet(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("liters") && data.get_target_unit().equalsIgnoreCase("gallons"))
		{
			float oup = data.LitersTogallons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("gallons") && data.get_target_unit().equalsIgnoreCase("liters"))
		{
			float oup = data.gallonsToLiters(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("tablespoons") && data.get_target_unit().equalsIgnoreCase("cubic-inches"))
		{
			float oup = data.tablespoonsTocubic_inches(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-inches") && data.get_target_unit().equalsIgnoreCase("tablespoons"))
		{
			float oup = data.cubic_inchesTotablespoons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("tablespoons") && data.get_target_unit().equalsIgnoreCase("cups"))
		{
			float oup = data.tablespoonsTocups(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cups") && data.get_target_unit().equalsIgnoreCase("tablespoons"))
		{
			float oup = data.cupsTotablespoons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("tablespoons") && data.get_target_unit().equalsIgnoreCase("cubic-feet"))
		{
			float oup = data.tablespoonsTocubic_feet(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-feet") && data.get_target_unit().equalsIgnoreCase("tablespoons"))
		{
			float oup = data.cubic_feetTotablespoons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("tablespoons") && data.get_target_unit().equalsIgnoreCase("gallons"))
		{
			float oup = data.tablespoonsTogallons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("gallons") && data.get_target_unit().equalsIgnoreCase("tablespoons"))
		{
			float oup = data.gallonsTotablespoons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-inches") && data.get_target_unit().equalsIgnoreCase("cups"))
		{
			float oup = data.cubic_inchesTocups(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cups") && data.get_target_unit().equalsIgnoreCase("cubic-inches"))
		{
			float oup = data.cupsTocubic_inches(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-inches") && data.get_target_unit().equalsIgnoreCase("cubic-feet"))
		{
			float oup = data.cubic_inchesTocubic_feet(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-feet") && data.get_target_unit().equalsIgnoreCase("cubic-inches"))
		{
			float oup = data.cubic_feetTocubic_inches(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-inches") && data.get_target_unit().equalsIgnoreCase("gallons"))
		{
			float oup = data.cubic_inchesTogallons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cups") && data.get_target_unit().equalsIgnoreCase("cubic-feet"))
		{
			float oup = data.cupsTocubic_feet(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-feet") && data.get_target_unit().equalsIgnoreCase("cups"))
		{
			float oup = data.cubic_feetTocups(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cups") && data.get_target_unit().equalsIgnoreCase("gallons"))
		{
			float oup = data.cupsTogallons(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("gallons") && data.get_target_unit().equalsIgnoreCase("cups"))
		{
			float oup = data.gallonsTocups(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("cubic-feet") && data.get_target_unit().equalsIgnoreCase("gallons"))
		{
			float oup = data.cubic_feetTogallon(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		else if(data.get_unit_of_measure().equalsIgnoreCase("gallons") && data.get_target_unit().equalsIgnoreCase("cubic-feet"))
		{
			float oup = data.gallonTocubic_feet(data.get_number_to_convert());
			data.set_output(oup);
			if(data.get_student_response() == oup)
			{
				data.set_status(true);
			}
			else {
				data.set_status(false);
			}

		}
		
		
		else {
			System.out.println("===>>nothing found ");
		}
		
		
		System.out.println("  ");
		System.out.println("  ");
        return data;
	}
}
