package edu.westga.cs3152.errormessages;

/**
 * Holds the error messages for the CNF
 * 
 * @author Alex DeCesare
 * @version 15-September-2021
 */
public final class CNFErrorMessages {

	public static final String CANNOT_SET_WHEN_VARAIBLE_IS_LESS_THAN_ONE = "Cannot set when the variable is less than one";
	
	public static final String CANNOT_SET_WHEN_VARIABLE_IS_MORE_THAN_THE_NUMBER_OF_VARIABLES = "Cannot set when the variable is more than the number of variables";
	
	public static final String CANNOT_SET_WHEN_VALUE_IS_LESS_THAN_NEGATIVE_ONE = "Cannot set when the value is less than negative one";
	
	public static final String CANNOT_SET_WHEN_VALUE_IS_EQUAL_TO_ZERO = "Cannot set when the value is equal to zero";
	
	public static final String CANNOT_SET_WHEN_VALUE_IS_MORE_THAN_ONE = "Cannot set when the value is more than one";
	
	public static final String CANNOT_SET_WHEN_VARIABLE_IS_ALREADY_PRESENT_IN_CLAUSE = "Cannot set when the variable is already present in the clause";
	
	
	public static final String CANNOT_UNSET_WHEN_VARIABLE_IS_LESS_THAN_ONE = "Cannot unset when the variable is less than one";
	
	public static final String CANNOT_UNSET_WHEN_VARIABLE_IS_MORE_THAN_NUMBER_OF_VARIABLES = "Cannot unset when the variable is more than the number of variables";
	
	public static final String CANNOT_UNSET_WHEN_THE_VALUE_BEING_UNSET_IS_MORE_THAN_ONE = "Cannot unset when the variable being unset is more than one";
	
	public static final String CANNOT_UNSET_WHEN_THE_VALUE_BEING_UNSET_IS_LESS_THAN_NEGATIVE_ONE = "Cannot unset when the variable being unset is less than negative one";
	
	public static final String CANNOT_UNSET_WHEN_THE_VALUES_BEING_UNSET_IS_EQUAL_TO_ZERO = "Cannot unset when the variable being unset is equal to zero";
}
