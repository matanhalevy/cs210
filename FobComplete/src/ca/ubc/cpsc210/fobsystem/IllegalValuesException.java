package ca.ubc.cpsc210.fobsystem;

/**
 * An exception to describe when illegal values have been passed to a method
 * 
 * @author Gail Murphy
 */

public class IllegalValuesException extends Exception {
	public IllegalValuesException() {
		super("Size of fobs list does not match size of users list");
	}
}
