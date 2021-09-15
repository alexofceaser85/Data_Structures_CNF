package edu.westga.cs3152.errormessages;

/**
 * Holds the error messages for the file reader
 * 
 * @author Alex DeCesare
 * @version 15-September-2021
 */
public final class FileReaderErrorMessages {

	public static final String THE_FILE_NAME_CANNOT_BE_NULL = "The file name cannot be null";
	
	public static final String THE_FILE_NAME_CANNOT_BE_EMPTY = "The file name cannot be empty";
	
	public static final String THE_FILE_CANNOT_BE_FOUND = "The file cannot be found";
	
	public static final String THE_NUMBER_OF_CLAUSES_IN_THE_FILE_DOES_NOT_MATCH_ACTUAL_NUMBER_OF_CLAUSES = "The number of clauses listed in the file header does not match the actual number of clases";
	
	public static final String THE_HEADER_FORMAT_IS_INVALID_LACKING_P = "The header format is invalid, it is lacking the 'p' as the first word in the header";
	
	public static final String THE_HEADER_FORMAT_IS_INVALID_LACKING_CNF = "The header format is invalid, it is lacking the 'cnf' as the second word in the header";
	
	public static final String COULD_NOT_PARSE_TO_INTEGER = "Could not convert file data to an integer, please check for non integers in the file";
	
	public static final String THE_NUMBER_VALUES_CANNOT_BE_ABOVE_THE_NUMBER_OF_VARIABLES = "The number value cannot be above the number of variables";
	
	public static final String THE_NUMBER_VALUES_CANNOT_BE_BELOW_THE_NEGATIVE_OF_THE_NUMBER_OF_VARIABLES = "The number value cannot be below the negative of the number of variables";
	
	public static final String A_CLAUSE_CANNOT_HAVE_DUPLICATE_VALUES = "A clause cannot have duplicate values, please check if each clause does not have duplicate values";
}
