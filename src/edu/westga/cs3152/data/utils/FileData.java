package edu.westga.cs3152.data.utils;

import edu.westga.cs3152.errormessages.FileDataErrorMessages;

/**
 * Holds the data for the file
 * @author Alex DeCesare
 * @version 15-September-2021
 */
public class FileData {

	private int numberOfValues;
	private int numberOfClauses;
	
	private int[][] valueMatrix;
	private int[][] clauseMatrix;
	
	/**
	 * Holds the data for the file
	 * 
	 * @precondition numberOfValues >= 0 && numberOfClauses >= 0 && valueMatrix != null && clauseMatrix != null
	 * @postcondition this.numberOfValues == numberOfValues 
	 *  && this.numberOfClauses == numberOfClauses
	 *  && this.valueMatrix == valueMatrix
	 *  && this.clauseMatrix == clauseMatrix
	 *  
	 * @param numberOfValues the number of variables the file has
	 * @param numberOfClauses the number of clauses the file has
	 * @param valueMatrix the value matrix from the file
	 * @param clauseMatrix the clause matrix from the file
	 */
	
	public FileData(int numberOfValues, int numberOfClauses, int[][] valueMatrix, int[][] clauseMatrix) {
		if (numberOfValues < 0) {
			throw new IllegalArgumentException(FileDataErrorMessages.THE_NUMBER_OF_VALUES_CANNOT_BE_NEGATIVE);
		}
		if (numberOfClauses < 0) {
			throw new IllegalArgumentException(FileDataErrorMessages.THE_NUMBER_OF_CLAUSES_CANNOT_BE_NEGATIVE);
		}
		if (valueMatrix == null) {
			throw new IllegalArgumentException(FileDataErrorMessages.THE_VALUE_MATRIX_CANNOT_BE_NULL);
		}
		if (clauseMatrix == null) {
			throw new IllegalArgumentException(FileDataErrorMessages.THE_CLAUSE_MATRIX_CANNOT_BE_NULL);
		}
		
		this.numberOfValues = numberOfValues;
		this.numberOfClauses = numberOfClauses;
		this.valueMatrix = valueMatrix;
		this.clauseMatrix = clauseMatrix;
	}
	
	/**
	 * Gets the number of values
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of values
	 */
	public int getNumberOfValues() {
		return this.numberOfValues;
	}
	
	/**
	 * Gets the number of clauses
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of clauses
	 */
	
	public int getNumberOfClauses() {
		return this.numberOfClauses;
	}
	
	/**
	 * Gets the value matrix
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the value matrix
	 */
	public int[][] getValueMatrix() {
		return this.valueMatrix;
	}
	
	/**
	 * Sets the value matrix
	 * 
	 * @precondition matrixToSet != null
	 * @postcondition this.valueMatrix == matrixToSet
	 * 
	 * @param matrixToSet the matrix to set the value matrix to
	 */
	
	public void setValueMatrix(int[][] matrixToSet) {
		if (matrixToSet == null) {
			throw new IllegalArgumentException(FileDataErrorMessages.CANNOT_SET_A_NULL_MATRIX);
		}
		
		this.valueMatrix = matrixToSet;
	}
	
	/**
	 * Sets the value matrix sub group
	 * 
	 * @precondition matrixToSet != null
	 * @postcondition this.valueMatrix[indexToSet] == matrixToSet
	 * 
	 * @param subGroupToSet the sub matrix to set a sub group of the value matrix to
	 * @param indexToSet the index of the sub group to set the value matrix
	 */
	
	public void setValueMatrixSubGroup(int[] subGroupToSet, int indexToSet) {
		if (subGroupToSet == null) {
			throw new IllegalArgumentException(FileDataErrorMessages.CANNOT_SET_A_NULL_SUB_GROUP);
		}
		
		this.valueMatrix[indexToSet] = subGroupToSet;
	}
	
	/**
	 * Sets a value of the value matrix
	 * 
	 * @precondition none
	 * @postcondition this.valueMatrix[mainIndexToSet][subIndexToSet] == valueToSet
	 * 
	 * @param valueToSet the value to set 
	 * @param mainIndexToSet the index of the sub group to set
	 * @param subIndexToSet the index of the value to set
	 */
	
	public void setValueMatrixValue(int valueToSet, int mainIndexToSet, int subIndexToSet) {
		this.valueMatrix[mainIndexToSet][subIndexToSet] = valueToSet;
	}
	
	/**
	 * Gets the clause matrix
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the clause matrix
	 */
	
	public int[][] getClauseMatrix() {
		return this.clauseMatrix;
	}
	
	/**
	 * Sets the clause matrix
	 * 
	 * @precondition matrixToSet != null
	 * @postcondition this.clauseMatrix == matrixToSet
	 * 
	 * @param matrixToSet the matrix to set the clause matrix too
	 */
	
	public void setClauseMatrix(int[][] matrixToSet) {
		if (matrixToSet == null) {
			throw new IllegalArgumentException(FileDataErrorMessages.CANNOT_SET_A_NULL_MATRIX);
		}
		
		this.clauseMatrix = matrixToSet;
	}
	
	/**
	 * Sets the sub group for the clause matrix
	 * 
	 * @precondition subGroupToSet != null
	 * @postcondition clauseMatrix[indexToSet] == subGroupToSet
	 * 
	 * @param subGroupToSet the subgroup to set
	 * @param indexToSet the index to set the subgroup at
	 */
	public void setClauseMatrixSubGroup(int[] subGroupToSet, int indexToSet) {
		if (subGroupToSet == null) {
			throw new IllegalArgumentException(FileDataErrorMessages.CANNOT_SET_A_NULL_SUB_GROUP);
		}
		
		this.clauseMatrix[indexToSet] = subGroupToSet;
	}
}
