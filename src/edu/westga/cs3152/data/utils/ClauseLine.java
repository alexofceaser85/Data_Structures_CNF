package edu.westga.cs3152.data.utils;

import java.util.Arrays;

import edu.westga.cs3152.errormessages.FileReaderErrorMessages;

/**
 * Holds the representation of a clause from the file
 * 
 * @author Alex DeCesare
 * @version 15-September-2021
 */
public class ClauseLine {

	private int[] values;
	private int[] usedValues;
	private int currentIndex;
	private String[] lineData;
	private FileData fileData;
	
	/**
	 *  Creates a new clause line, to hold the clause variables
	 *  
	 * @precondition clauseData != null && fileData != null
	 * @postcondition 
	 * this.values == new int[clauseData.length - 1]
	 * && this.usedValues == new int[this.fileData.getNumberOfValues() + 1]
	 * && this.currentIndex == 0
	 * 
	 * @param clauseData the clause data
	 * @param fileData the file data
	 */
	
	public ClauseLine(String[] clauseData, FileData fileData) {
		this.fileData = fileData;
		this.lineData = clauseData;
		this.values = new int[clauseData.length - 1];
		this.usedValues = new int[this.fileData.getNumberOfValues() + 1];
		this.currentIndex = 0;
	}
	
	/**
	 * Populates the clause line with clause values
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param parsedClauseCounter the current parsed clause
	 */
	public void getClauseLineData(int parsedClauseCounter) {
		for (String value : this.lineData) {
			int parsedValue;
			
			try {
				parsedValue = Integer.parseInt(value);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(FileReaderErrorMessages.COULD_NOT_PARSE_TO_INTEGER);
			}
			if (parsedValue > this.fileData.getNumberOfValues()) {
				throw new IllegalArgumentException(FileReaderErrorMessages.THE_NUMBER_VALUES_CANNOT_BE_ABOVE_THE_NUMBER_OF_VARIABLES);
			} else if (parsedValue < -this.fileData.getNumberOfValues()) {
				throw new IllegalArgumentException(FileReaderErrorMessages.THE_NUMBER_VALUES_CANNOT_BE_BELOW_THE_NEGATIVE_OF_THE_NUMBER_OF_VARIABLES);
			}
			
			if (parsedValue == 0) {
				break;
			} else {
				this.addNewLineOfClauseData(parsedClauseCounter, parsedValue);
			}
		}
		
		this.fileData.setClauseMatrixSubGroup(this.values, parsedClauseCounter);
	}

	private void addNewLineOfClauseData(int parsedClauseCounter, int parsedValue) {
		if (parsedValue == this.usedValues[this.currentIndex]) {
			throw new IllegalArgumentException(FileReaderErrorMessages.A_CLAUSE_CANNOT_HAVE_DUPLICATE_VALUES);
		}
		
		int absoluteNumberValue = Math.abs(parsedValue);
		
		int[] newSubGroupValue = Arrays.copyOf(this.fileData.getValueMatrix()[absoluteNumberValue - 1], this.fileData.getValueMatrix()[absoluteNumberValue - 1].length + 1);
		this.fileData.setValueMatrixSubGroup(newSubGroupValue, absoluteNumberValue - 1);
		
		int newValue = (parsedClauseCounter + 1) * Integer.signum(parsedValue);
		this.fileData.setValueMatrixValue(newValue, absoluteNumberValue - 1, this.fileData.getValueMatrix()[absoluteNumberValue - 1].length - 1);

		this.values[this.currentIndex] = parsedValue;
		this.usedValues[absoluteNumberValue] = -1;
		this.currentIndex++;
	}
}
