package model;

//import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author chuksigbe
 *
 */

public class NumericConversionModel {
	/**
	 * Here we are defining parameters that will be set from user input
	 *
	 * @param number_to_convert-- this holds the numerical value to be converted to target unit.
	 * @param unit_of_measure--- holds the unit of the number to be converted.
	 * @param target_unit--holds the target unit expected.
	 * @param student_response-- holds the answer supplied by student.
	 */
	
	private float number_to_convert;
	private String unit_of_measure;
	private String target_unit;
	private float student_response;
	private float output;
	private boolean status;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * returns the initial number to be converted.
	 * @param none
	 */
	public float get_number_to_convert()
	{
		return number_to_convert;
	}
	
	/**
	 * returns the current unit measure of the initial input.
	 * @param none
	 */
	
	public String get_unit_of_measure()
	{
		return unit_of_measure;
	}
	
	
	/**
	 * returns the result of the conversion.
	 * @param none
	 */
	
	public float get_result()
	{
		return output;
	}
	
	/**
	 * returns the correctness status of the conversion.
	 * @param none
	 */
	
	public boolean get_status()
	{
		return status;
	}
	
	/**
	 * returns the unit measure to be converted to.
	 * @param none
	 */
	
	public String get_target_unit()
	{
		return target_unit;
	}
	
	/**
	 * returns the student's answer.
	 * @param none
	 */
	public float get_student_response()
	{
		return student_response;
	}
	
	/**
	 * sets the current unit of the input parameter.
	 * @param accepts a float parameter
	 */
	public void set_number_to_convert(float input)
	{
		this.number_to_convert = input;
	}
	
	
	/**
	 * sets the current unit of the input parameter.
	 * @param accepts a String parameter
	 */
	public void set_unit_of_measure(String measure)
	{
		this.unit_of_measure = measure;
	}
	
	/**
	 * sets the desired unit of the input parameter.
	 * @param accepts a String parameter
	 */
	public void set_target_unit(String targetUnit)
	{
		this.target_unit = targetUnit;
	}
	
	/**
	 * sets the response from the student.
	 * @param accepts a float parameter
	 */
	public void set_student_response(float response)
	{
		this.student_response = response;
	}
	
	/**
	 * sets the result of the conversion.
	 * @param accepts a float parameter
	 */
	public void set_output(float response)
	{
		this.output = response;
	}
	
	/**
	 * sets the status of the conversion.
	 * @param accepts a boolean parameter
	 */
	public void set_status(boolean status)
	{
		this.status = status;
	}
	
	
	
	public float KelvinToFahrenheit(float input)
	{
		float output = 0.0f;
		//° F = 9/5 (K - 273.15) + 32
		
		output = Float.parseFloat(df.format((((input-273.15) * 1.8) + 32)));
		
		return output;
	}
	
	public float FahrenheitToKelvin(float input)
	{
		float output = 0.0f;
		
		//5/9 (° F - 32) + 273.15
		output = (float) ((((input-32)* 0.56) + 273.15) );
		
		return output;
	}
	
	public float KelvinToCelsius(float input)
	{
		float output = 0.0f;
		//T(°C) = T(K) - 273.15
		
		output = (float) (input - 273.15);
		
		return output;
	}
	
	public float CelsiusToKelvin(float input)
	{
		float output = 0.0f;
		//T(K) = T(°C) + 273.15
		
		output = (float) (input + 273.15);
		
		return output;
	}
	public float KelvinToRankie(float input)
	{
		float output = 0.0f;
		//ºR =(K - 273.15)* 1.8000+ 491.67
		
		output = (float) ((input - 273.15)*1.8000 + 491.67);
		
		return output;
	}
	
	public float RankieToKelvin(float input)
	{
		float output = 0.0f;
		//K =(ºR - 491.67)/1.8000 + 273.15
		
		output = (float) ((input - 491.67)/1.8000 +273.15);
		
		return output;
	}
	
	public float CelsiusToFahrenheit(float input)
	{
		float output = 0.0f;
		//T(°F) = T(°C) × 1.8 + 32
		
		output = (float) (input*1.8+32);
		
		return output;
	}
	
	public float FahrenheitToCelsius(float input)
	{
		float output = 0.0f;
		//T(°C) = (T(°F) - 32) / 1.8
		output = (float) ((input-32)/1.8);
		
		return output;
	}
	
	public float CelsiusToRankie(float input)
	{
		float output = 0.0f;
		//T(°R) = (T(°C) + 273.15) × 9/5
		output = (float) ((input + 273.15)*1.8);
		
		return output;
	}
	
	public float RankieToCelsius(float input)
	{
		float output = 0.0f;
		//T(°C) = (T(°R) - 491.67) × 5/9
		output = (float) ((input - 491.67)*0.56);
		
		return output;
	}
	public float FahrenheitToRankie(float input)
	{
		float output = 0.0f;
		//R =°F + 491.67
		
		output = (float) (input + 491.67);
		
		return output;
	}
	public float RankieToFahrenheit(float input)
	{
		float output = 0.0f;
		//T(°F) = T(°R) - 459.67
		
		output = (float) (input -459.67);
		
		return output;
	}
	
	public float LiterstoTablespoons(float input)
	{
		float output = 0.0f;
		//tablespoons = liters × 67.628045
		output = (float) (input * 67.628045);
		
		return output;
	}
	
	public float TablespoonsToLiters(float input)
	{
		float output = 0.0f;
		//L =tblsp /67.628
		
		output = (float) (input/67.628);
		
		return output;
	}
	
	public float LitersTocubic_inches(float input)
	{
		float output = 0.0f;
		//in³ =L * 61.024
		
		output = (float) (input*61.024);
		
		return output;
	}
	
	public float cubic_inchesToLiters(float input)
	{
		float output = 0.0f;
		//L =in³/61.024
		output = (float) (input/61.024);
		
		return output;
	}
	
	public float LitersTocups(float input)
	{
		float output = 0.0f;
		//cups = liters × 4.226753
		
		output = (float) (input*4.226753);
		
		return output;
	}
	
	public float cupsToLiters(float input)
	{
		float output = 0.0f;
		//liters = cups × 0.236588
		
		output = (float) (input *0.236588);
		
		return output;
	}
	
	public float LitersTocubic_feet(float input)
	{
		float output = 0.0f;
		//ft³ =L * 0.035315
		
		output = (float) (input * 0.035315);
		
		return output;
	}
	
	public float cubic_feetToLiters(float input)
	{
		float output = 0.0f;
		//L =ft³/0.035315
		
		output = (float) (input/0.035315);
		
		return output;
	}
	
	public float LitersTogallons(float input)
	{
		float output = 0.0f;
		//gal lqd =L * 0.26417
		
		output = (float) (input * 0.26417);
		
		return output;
	}
	
	public float gallonsToLiters(float input)
	{
		float output = 0.0f;
		//L =US gal/0.26417
		
		output = (float) (input/0.26417);
		
		return output;
	}
	
	public float cubic_inchesTotablespoons(float input)
	{
		float output = 0.0f;
		//L =US gal/0.26417
		
		output = (float) (input*1.108);
		
		return output;
	}
	
	
	
	public float tablespoonsTocubic_inches(float input)
	{
		float output = 0.0f;
		//cubic inches = tablespoons × 0.902344
		output = (float) (input*0.902344);
		return output;
	}
	
	public float tablespoonsTocups(float input)
	{
		float output = 0.0f;
		
		//cups = tablespoons × 0.0625
		
		output = (float) (input*0.0625);
		
		return output;
	}
	
	public float cupsTotablespoons(float input)
	{
		float output = 0.0f;
		//tablespoons = cups × 16
		
		output = (float) (input*16);
		
		return output;
	}
	
	public float tablespoonsTocubic_feet(float input)
	{
		float output = 0.0f;
		//cubic feet = tablespoons × 0.000522
		
		output = (float) (input*0.000522);
		
		return output;
	}
	
	public float cubic_feetTotablespoons(float input)
	{
		float output = 0.0f;
		//tablespoons = cubic feet × 1915.012947
		
		output = (float) (input*1915.012947);
		
		return output;
	}
	
	public float tablespoonsTogallons(float input)
	{
		float output = 0.0f;
		//gallons = tablespoons × 0.003906
		
		output = (float) (input*0.003906);
		
		return output;
	}
	
	public float cubic_inchesTocups(float input)
	{
		float output = 0.0f;
		//cups = cubic inches × 0.069264
		
		output = (float) (input*0.069264);
		
		return output;
	}
	
	public float cupsTocubic_inches(float input)
	{
		float output = 0.0f;
		//cubic inches = cups × 14.4375
		
		output = (float) (input*14.4375);
		
		return output;
	}
	
	public float gallonsTotablespoons(float input)
	{
		float output = 0.0f;
		//tablespoons = gallons × 256
		
		output = (float) (input*256);
		
		return output;
	}
	
	public float cubic_inchesTocubic_feet(float input)
	{
		float output = 0.0f;
		//cubic_feet = cubic_inches 1/1728 
		
		output = (float) (input*(1/1728));
		
		return output;
	}
	
	public float cubic_feetTocubic_inches(float input)
	{
		float output = 0.0f;
		//cubic_inches = cubic_feet 1*1728 
		
		output = (float) (input*1728);
		
		return output;
	}
	
	public float cubic_inchesTogallons(float input)
	{
		float output = 0.0f;
		//US gal lqd =in³ * 0.0043290 
		
		output = (float) (input*0.0043290);
		
		return output;
	}
	
	public float gallonsTocubic_inches(float input)
	{
		float output = 0.0f;
		//cubic inches = gallons × 231
		
		output = (float) (input*231);
		
		return output;
	}
	
	public float cupsTocubic_feet(float input)
	{
		float output = 0.0f;
		//cubic feet = cups × 0.008355 
		
		output = (float) (input*0.008355);
		
		return output;
	}
	
	public float cubic_feetTocups(float input)
	{
		float output = 0.0f;
		//cups = cubic feet × 119.688309
		
		output = (float) (input*119.688309);
		
		return output;
	}
	
	public float cupsTogallons(float input)
	{
		float output = 0.0f;
		//gallons = cups × 0.0625
		
		output = (float) (input*0.0625);
		
		return output;
	}
	
	public float gallonsTocups(float input)
	{
		float output = 0.0f;
		//cups = gallons × 16
		
		output = (float) (input*16);
		
		return output;
	}
	
	public float cubic_feetTogallon(float input)
	{
		float output = 0.0f;
		//gallon = cubic feet × 7.481
		
		output = (float) (input*7.481);
		
		return output;
	}
	
	public float gallonTocubic_feet(float input)
	{
		float output = 0.0f;
		//cubic feet = gallon / 7.481
		
		output = (float) (input/7.481);
		
		return output;
	}


}
