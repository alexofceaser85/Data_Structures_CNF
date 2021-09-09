package edu.westg.cs3152.test.CNFFormula;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.model.CNF;

/**
 * Incomplete set of tests
 */
class TestSet {

	@Test
	void testInvalidVariable() {
		CNF formula = new CNF("Input/small2.cnf");
		assertThrows(IllegalArgumentException.class, () -> formula.set(4, 1));
	}
	
	@Test
	void testInvalidValue() {
		CNF formula = new CNF("Input/small2.cnf");
		assertThrows(IllegalArgumentException.class, () -> formula.set(2, 0));
	}
	
	@Test
	void testSetAlreadSetVariable() {
		CNF formula = new CNF("Input/small2.cnf");
		formula.set(2, 1);
		assertThrows(IllegalArgumentException.class, () -> formula.set(2, 1));
	}
	
	@Test
	void testSetTwoVars() {
		CNF formula = new CNF("Input/small2.cnf");
		formula.set(2, 1);
		formula.set(3, -1);
		assertAll(() -> assertEquals(0, formula.getValue(1)), () -> assertEquals(1, formula.getValue(2)),
				() -> assertEquals(-1, formula.getValue(3)));
	}

	@Test
	void testSetOneVarUndecidedFormula() {
		CNF formula = new CNF("Input/small1.cnf");
		assertEquals(0, formula.set(1, 1));
	}

	@Test
	void testSetOneVarFalseFormula() {
		CNF formula = new CNF("Input/small1.cnf");
		assertEquals(-1, formula.set(2, -1));
	}

	@Test
	void testSetOneVarTrueFormula() {
		CNF formula = new CNF("Input/small1.cnf");
		assertEquals(1, formula.set(2, 1));
	}
}
