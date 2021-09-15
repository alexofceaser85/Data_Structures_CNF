package edu.westga.cs3152.test.CNFFormula;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.westga.cs3152.model.CNF;

class TestConstructor {

	@Test
	void testNullFileName() {
		assertThrows(IllegalArgumentException.class, () -> new CNF(null));
	}
	
	@Test
	void testEmptyFileName() {
		assertThrows(IllegalArgumentException.class, () -> new CNF(""));
	}
	
	@Test
	void testFileNotFound() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/filedoesnotexist"));
	}

	@Test
	void testInvalidFileFormat() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/invalid.cnf"));
	}
	
	@Test
	void testFileWithComments() {
		CNF formula = new CNF("Input/file_with_comments.cnf");
		assertAll(() -> assertEquals(5, formula.numberVariables()), () -> assertEquals(5, formula.numberClauses()),
				() -> assertEquals(0, formula.getValue()));
	}
	
	@Test
	void testFileWithoutP() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/file_without_p.cnf"));
	}
	
	@Test
	void testFileWithoutCNF() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/file_without_cnf.cnf"));
	}
	
	@Test
	void testFileWithLetterAndNotNumber() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/file_with_letter_and_not_number.cnf"));
	}
	
	@Test
	void fileWithLetterInHeader() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/file_with_letter_in_header.cnf"));
	}

	@Test
	void testCorrectFormulaForSmallOne() {
		CNF formula = new CNF("Input/small1.cnf");
		assertAll(() -> assertEquals(2, formula.numberVariables()), () -> assertEquals(3, formula.numberClauses()),
				() -> assertEquals(0, formula.getValue()));
	}
	
	@Test
	void testCorrectFormulaForSmallTwo() {
		CNF formula = new CNF("Input/small2.cnf");
		assertAll(() -> assertEquals(3, formula.numberVariables()), () -> assertEquals(2, formula.numberClauses()),
				() -> assertEquals(0, formula.getValue()));
	}
	
	@Test
	void testCorrectFormulaForSmallThree() {
		CNF formula = new CNF("Input/small3.cnf");
		assertAll(() -> assertEquals(3, formula.numberVariables()), () -> assertEquals(4, formula.numberClauses()),
				() -> assertEquals(0, formula.getValue()));
	}
}
