package com.cognizant.week2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

	 Calculator calc = new Calculator();

	    @Test
	    void testAddition() {
	        assertEquals(5, calc.add(2, 3), "Addition failed");
	    }

	    @Test
	    void testDivision() {
	        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0), "Division by zero should throw exception");
	    }

	    @Test
	    void testIsEven() {
	        assertTrue(calc.isEven(4), "4 should be even");
	        assertFalse(calc.isEven(5), "5 should be odd");
	    }

	    @Test
	    void testGreeting() {
	        assertEquals("Hello, John", calc.greet("John"), "Greeting message not as expected");
	        assertNotEquals("Hi, John", calc.greet("John"), "Greeting message incorrect");
	    }

	    @Test
	    void testNotNull() {
	        assertNotNull(calc.greet("Alice"), "Greeting should not be null");
	    }
}
