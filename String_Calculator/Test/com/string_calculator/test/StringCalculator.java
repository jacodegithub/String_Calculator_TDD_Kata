package com.string_calculator.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringCalculator {

	@Test
	public void checkForEmptyString() {
		Calculator obj = new Calculator();
		int result = obj.add("");
		assertEquals(0, result);
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
	
	@Test
	public void checkForTheSumOfNumbersInStringWithComma() {
		Calculator obj = new Calculator();
		long result = obj.add("1,2,3");
		assertEquals(6, result);
	}
	
	@Test
	public void checkForInvalidStringWithComma() {
		Calculator obj = new Calculator();
		int result = obj.add("a,b");
		assertEquals(-1, result);
	}
	
	@Test
	public void checkForTheSumOfNumbersInStringNewLineTag() {
		Calculator obj = new Calculator();
		long result = obj.add("1\n2,3");
		assertEquals(6, result);
		result = obj.add("2\n4\n1");
		assertEquals(7, result);
	}
	
	@Test
	public void checkForCoubleSlashInTheStringWithSemiColon() {
		Calculator obj = new Calculator();
		int result = obj.add("//;1;2;3");
		assertEquals(6, result);
		result = obj.add("//;1\n2;3");
		assertEquals(6, result);
	}
}
