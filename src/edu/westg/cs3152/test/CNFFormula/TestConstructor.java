package edu.westg.cs3152.test.CNFFormula;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.westga.cs3152.model.CNF;

class TestConstructor {

	@Test
	void testFileNotFound() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/filedoesnotexist"));
	}

	@Test
	void testInvalidFileFormat() {
		assertThrows(IllegalArgumentException.class, () -> new CNF("Input/invalid.cnf"));
	}

	@Test
	void testCorrectFormula() {
		CNF formula = new CNF("Input/small1.cnf");
		assertAll(() -> assertEquals(2, formula.numberVariables()), () -> assertEquals(3, formula.numberClauses()),
				() -> assertEquals(0, formula.getValue()));
	}

}
