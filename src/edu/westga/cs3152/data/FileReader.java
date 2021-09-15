package edu.westga.cs3152.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.westga.cs3152.data.utils.ClauseLine;
import edu.westga.cs3152.data.utils.FileData;
import edu.westga.cs3152.errormessages.FileReaderErrorMessages;

/**
 * Reads from the input files
 * 
 * @author Alex DeCesare
 * @version 11-September-2021
 */
public class FileReader {

	private String fileName;
	private int parsedClausesCounter;
	private FileData fileData;

	/**
	 * Creates a new file reader
	 * 
	 * @precondition fileName != null && fileName.isEmpty == false
	 * @postcondition 
	 * 	this.fileName == fileName;
	 * 	this.numberOfClauses == 0;
	 * 	this.numberOfValues == 0;
	 * 	this.parsedClausesCounter == 0;
	 * 	this.clauseMatrix == null
	 * 	this.valueMatrix == null
	 * 
	 * @param fileName the name of the file to read
	 */
	public FileReader(String fileName) {
		
		if (fileName == null) {
			throw new IllegalArgumentException("file name cannot be null");
		}
		
		if (fileName.isEmpty()) {
			throw new IllegalArgumentException("file name cannot be empty");
		}
		
		this.fileName = fileName;
		this.parsedClausesCounter = 0;
	}
	
	/**
	 * Gets the file data
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the file data
	 */
	
	public FileData getFileData() {
		return this.fileData;
	}
	
	/**
	 * Reads the input file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the clause matrix
	 */
	public boolean readFromInputFile() {
		try {
			boolean isOnHeaderLine = true;
			File inputFile = new File(this.fileName);
			Scanner reader = new Scanner(inputFile);
			
			int lineIndex = 0;
			
			while (reader.hasNextLine()) {
				String currentLine = reader.nextLine();
				String[] currentLineData = currentLine.split(" ");
				
				if (isOnHeaderLine) {
					this.updateHeaderLine(currentLineData);
					isOnHeaderLine = false;
				} else if (currentLineData[0].equals("c")) {
					continue;
				}  else {
					ClauseLine clause = new ClauseLine(currentLineData, this.fileData);
					clause.getClauseLineData(this.parsedClausesCounter);
					this.parsedClausesCounter++;
					lineIndex++;
				}
			}
			
			reader.close();
			if (lineIndex != this.fileData.getNumberOfClauses()) {
				throw new IllegalArgumentException("The number of clauses listed in the file do not match the number of actual clauses");
			}
			
			return true;
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("The file cannot be found");
		}
	}
	
	private void updateHeaderLine(String[] currentLineData) {
		if (!currentLineData[0].equals("p")) {
			throw new IllegalArgumentException("Invalid header format, lacking the p in the header");
		} else if (!currentLineData[1].equals("cnf")) {
			throw new IllegalArgumentException("Invalid header format, lacking the cnf in the header");
		} else {
			this.updateFileInformationFromHeader(currentLineData);
		}
	}

	private void updateFileInformationFromHeader(String[] currentLineData) {
		try {
			int numberOfValuesFromHeader = Integer.parseInt(currentLineData[2]);
			int numberOfClausesFromHeader = Integer.parseInt(currentLineData[3]);
			
			this.fileData = new FileData(numberOfValuesFromHeader, numberOfClausesFromHeader, new int[numberOfValuesFromHeader][0], new int[numberOfClausesFromHeader][]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(FileReaderErrorMessages.COULD_NOT_PARSE_TO_INTEGER);
		}
	}	
}
