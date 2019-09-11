package controller;

import model.NumericConversionModel;
import view.NumericConversionView;

/**
 * @author chuksigbe
 *
 */

public class NumericConversionController {
	private NumericConversionModel numberConversion;
	private NumericConversionView displayConversion;
	
	//define constructor
	public NumericConversionController(NumericConversionModel numberConversion, NumericConversionView displayConversion)
	{
		this.numberConversion = numberConversion;
		this.displayConversion = displayConversion;
	}
	
	/**
	 * set the number to convert derived from user input and set using the model set method.
	 * @param accepts a float parameter
	 */
	public void setNumberToConvert(float value)
	{
		numberConversion.set_number_to_convert(value);
	}
	
	/**
	 * set the unit of the value to be converted using the model set method.
	 * @param accepts String parameter
	 */
	public void setUnitToMeasure(String currentUnit)
	{
		numberConversion.set_unit_of_measure(currentUnit);
	}
	
	
	/**
	 * set the desired value to be converted to using the model set method.
	 * @param accepts String parameter
	 */
	public void setTargetUnit(String targetUnit)
	{
		numberConversion.set_target_unit(targetUnit);
	}
	
	
	/**
	 * set the response gotten from the student using the model set method.
	 * @param accepts a float parameter
	 */
	public void setStudentResponse(float studentResonse)
	{
		numberConversion.set_student_response(studentResonse);
	}
	
	
	//get values from the model

	/**
	 * returns the number to convert derived from user input and set using the model set method.
	 * @param empty
	 */
	public float getNumberToConvert()
	{
		return numberConversion.get_number_to_convert();
	}
	
	/**
	 * returns the unit of the value to be converted using the model set method.
	 * @param empty
	 */
	public String getUnitToMeasure()
	{
		return numberConversion.get_unit_of_measure();
	}
	
	
	/**
	 * returns the desired value to be converted to using the model set method.
	 * @param empty
	 */
	public String setTargetUnit()
	{
		return numberConversion.get_target_unit();
	}
	
	
	/**
	 * returns the response gotten from the student using the model set method.
	 * @param empty
	 */
	public float getStudentResponse()
	{
		return numberConversion.get_student_response();
	}
	
	
	public void updateDisplay()
	{
		displayConversion.printConversionDetails(numberConversion.get_number_to_convert(), numberConversion.get_unit_of_measure(), numberConversion.get_target_unit(), numberConversion.get_student_response(), numberConversion.get_result(), numberConversion.get_status());
	}

}
