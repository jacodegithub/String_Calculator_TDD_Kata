package com.string_calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.packageforTDD.testing.verifySum;

class StringCalculator {

	@Test
	public void checkForEmptyString() {
		Calculator obj = new Calculator();
		int result = obj.add("");
		assertEquals(0, result);
	}
	
	@Test
	public void checkForValidString() {
		Calculator obj = new Calculator();
		int result = obj.add("a,b");
		assertEquals(-1, result);
	}
	
	@Test
	public void checkForTheSingleDigitString() {
		Calculator obj = new Calculator();
		int result = obj.add("1");
		assertEquals(1, result);
	}
	
	@Test
	public void checkForValidSingleLengthString() {
		Calculator obj = new Calculator();
		int result = obj.add("a");
		assertEquals(-1, result);
	}

}
