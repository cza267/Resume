package model;
/**
 * This is the model of this MVC implementation of a calculator.
 * It performs the functions of the calculator and keeps track
 * of what the user has entered.
 * 
 * @author Cheyenne Sanchez
 * @version 2.0
 */
public class CalculatorModel {

	/**
	 * This is the numeric value of the number the user is entering,
	 * or the number that was just calculated.
	 */
    private double displayValue;
    
    /**
	 * This is the previous value entered or calculated.
	 */
	private double internalValue;
	
	/**
	 * This is the String corresponding to what the user.
	 * is entering
	 */
	private String displayString;
	
	/**
	 * This is the last operation entered by the user.
	 */
	private String operation;
	
	/**
	 * This is true if the next digit entered starts a new value.
	 */
	private boolean start;
	
	/**
     * This is true if a decimal dot has been entered for the current value.
     */
    private boolean dot;

	/**
	 * Initializes the instance variables.
	 */
	public CalculatorModel() {
		displayValue = 0.0;
		displayString = "" + displayValue;
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";
	}

	/**
	 * @return the String value of what was just calculated
	 * or what the user is entering
	 */
	public String getValue() {
		return displayString;
	}
	
	
	/**
	 * Precondition: n must be greater than or equal to 0.
	 * Postcondition: Returns the factorial of n 
	 * @param n A nonnegative integer
	 * @returnThe factorial of n
	 */
	public double fact(double n) {
		//Precondition: n must be greater than or equal to 0. 
		//Postcondition: Returns the factorial of n 
		if(n ==0) {
				return 1;
		}
		else {
			//Iterative solution
				//Invariant: n > 0, so n-1 >= 0
			double result = 1;
			for(double i = n; i > 0; i--) {
				result = result * i;				
			}
			result = n * fact(n-1);
			return result;
		}
	}	
	
	/**
	 * Method modulo that will calculate the remainder between 2 numbers
	 * @param x A double specifying the user's input
	 * @param y A double specifying the user's input 
	 * @return The modulo remainder to be returned
	 */
	public double modulo(double x, double  y) {
		if ( y == 0) {
			return 0;
		}
		else {
			return (x % y); 
		}
	}
	/**
	 * A method that will calculate the value of one double raised to the power 
	 * of another double
	 * @param x A double specifying the user's input 
	 * @param y A double specifying the user's input
	 * @return The value of the double raised to the power of another r
	 */
	public double power(double x, double y)
	{
	    if(y ==0) {
	    	return 1;
	    }
	    else if(y == 1) {
	    	return x;
	    }
	    else {
	    return	x * power(x, y-1);
	    }
	}
	
	/**
	 * A method that will calculate the square root of the double x
	 * @param x A double specifying the user's input 
	 * @return The value of the x when it is square rooted
	 */
	public double sqrt(double x)
	{
		if(x ==0)
			return 0;
		else if(x == 1) {
			return 1;
		}
		else {
			return Math.sqrt(x); //something fix	
		}		
	}
	
	/**
	 * A method that will square any double of x
	 * @param x A double specifying the user's input
	 * @return The value of the x when it is squared
	 */
	public double squared(double x) {
		if(x == 0)
			return 0;
		else {
			return x * x;
		}
	}

	
	/**
	 * Updates the values maintained by the calculator based on the
	 * button that the user has just clicked.
	 * 
	 * @param text is the name of the button that the user has just clicked
	 */
	public void update(String text) {
	    if (start) {	
			internalValue = displayValue;
			displayValue = 0;
			displayString = "";
			start = false;
			dot = false;
		}
		if (text.length() == 1 && "0123456789".indexOf(text) >= 0) {
			displayString += text;
			displayValue = Double.valueOf(displayString);
		} else if (text.equals(".")) {
			if (! dot) {	
				dot = true;	
				if (displayString.equals("")) {
					displayString = "0";
				}
				displayString += ".";
			}
		} else {
		    if (operation.equals("+")) {
				displayValue = internalValue + displayValue;
			} else if (operation.equals("-")) {
				displayValue = internalValue - displayValue;
			} else if (operation.equals("*")) {
				displayValue = internalValue * displayValue;
			} else if (operation.equals("/")) {
				displayValue = internalValue / displayValue;
			}
		    // factorial operation
			 else if(operation.equals("n!") ) {
				displayValue = fact(internalValue);
			}
		    // Clear operation calls for zero
			 else if(operation.equals("C")) {
				 displayValue = 0;
			  }
		    // modulo operation 
			 else if(operation.equals("%")){
				 displayValue = modulo(internalValue, displayValue);
			 }
		    // power operation
			 else if(operation.equals("x^y")) {
				displayValue = power(internalValue, displayValue);
			 }
		    // square root  operation
			 else if(operation.equals("sqrt")) {
				 displayValue = sqrt(internalValue);
			 }
		    // PI operation calls for math class in Java library
			 else if(operation.equals("sin")) {
				 displayValue = Math.sin(internalValue*(Math.PI/180));
			 }
		    // squared operation
			 else if(operation.equals("x^2")) {
				 displayValue = squared(internalValue);
			 }
		    // Exponential function	
			 else if(operation.equals("tan")) {
				 displayValue = Math.tan(internalValue*(Math.PI/180));
			 }
		    // Logarithmic function
			 else if(operation.equals("cos")) {
				 displayValue = Math.cos(internalValue*(Math.PI/180));
			 }
		    
		    	
			displayString = "" + displayValue;
			 internalValue = displayValue;
			
			operation = text;
			
			start = true;
		}
	}

	
}
