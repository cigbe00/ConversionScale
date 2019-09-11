package view;

/**
 * @author chuksigbe
 *
 */
public class NumericConversionView {
	
	public void printConversionDetails(float inputValue, String unitMeasure, String targetMeasure, float studentResponse, float correctAnswer, boolean status)
	{
		
		System.out.println("Value to be Converted: "+inputValue);
		System.out.println("Unit of value to be Converted: "+unitMeasure);
		System.out.println("Target unit to be Converted: "+targetMeasure);
		System.out.println("Student's answer: "+studentResponse);
		System.out.println("Correct Answer is: "+ correctAnswer);
		System.out.println("Correctness status: "+ status);
	}

}
