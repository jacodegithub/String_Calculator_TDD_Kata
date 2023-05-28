package com.string_calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

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
	
	@Test
	public void checkForSingleNegativeNumberInTheString() {
		Calculator obj = new Calculator();
		
		NumberFormatException exception = assertThrows(NumberFormatException.class, 
				() -> {
					obj.add("1,-2,4");
				});
		assertEquals("Negatives are not allowed", exception.getMessage());
	}
	
	@Test 
	public void checkForMultipleNegativeNumberInTheString() {
		Calculator obj = new Calculator();
		
		NumberFormatException exception = assertThrows(NumberFormatException.class, 
				() -> {
					obj.add("1,-2,-2,-3,-6,4");
				});
		List<Integer> list = obj.getNegativeNumbers(exception);
		List<Integer> negNumbers = Arrays.asList(-2,-2,-3,-6);
		assertEquals(list, negNumbers);
	}
}
