package edu.westg.cs3152.test.CNFFormula;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.model.CNF;

/**
 * Incomplete set of tests
 */
class TestUnset {

	@Test
	void shouldNotAllowVariableLessThanOne() {
		CNF formula = new CNF("Input/small2.cnf");
		assertThrows(IllegalArgumentException.class, () -> formula.unset(0));
	}
	
	@Test
	void testInvalidVariable() {
		CNF formula = new CNF("Input/small2.cnf");
		assertThrows(IllegalArgumentException.class, () -> formula.unset(4));
	}
	
	@Test
	void testUnsetAlreadyUnsetVariable() {
		CNF formula = new CNF("Input/small2.cnf");
		assertThrows(IllegalArgumentException.class, () -> formula.unset(2));
	}
	
	@Test
	void testUnsetVar() {
		CNF formula = new CNF("Input/small2.cnf");
		formula.set(2, 1);
		formula.set(3, -1);
		formula.unset(2);
		assertAll(() -> assertEquals(0, formula.getValue(1)), () -> assertEquals(0, formula.getValue(2)),
				() -> assertEquals(-1, formula.getValue(3)));
	}
	
	@Test
	void testUnsetOneVarInUndecidedFormula() {
		CNF formula = new CNF("Input/small1.cnf");
		formula.set(1, 1);
		assertEquals(0, formula.unset(1));
	}

	@Test
	void testUnsetOneVarInFalseFormula() {
		CNF formula = new CNF("Input/small1.cnf");
		formula.set(2, -1);
		assertEquals(0, formula.unset(2));
	}
	
	@Test
	void testUnsetOneVarInTrueFormula() {
		CNF formula = new CNF("Input/small1.cnf");
		formula.set(2, 1);
		assertEquals(0, formula.unset(2));
	}

}
