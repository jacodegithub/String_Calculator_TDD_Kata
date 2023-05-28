package com.string_calculator.test;

import static org.junit.jupiter.api.Assertions.*;
 
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class StringCalculator {

	private static final String MESSAGE = "Negatives are not allowed";
	private static final int NUMBER_SUM_IF_NEWLINETAG = 6;
	private static final int NUMBER_SUM_IF_DBLSTASH_NEWLINETAG = 6;
	private static final int NUMBER_SUM_IF_COMMA = 6;
	private static final int NUMBER_SUM_IF_NEWLINETAG_COMMA = 6;
	private static final int INVALID_SINGLE_DIGIT = -1;
	private static final int SINGLE_DIGIT = 1;
	private static final int ZERO = 0;

	@Test
	public void checkForEmptyString() {
		Calculator obj = new Calculator();
		long result = obj.add("");
		assertEquals(ZERO, result);
	}
	
	@Test
	public void checkForTheSingleDigitString() {
		Calculator obj = new Calculator();
		long result = obj.add("1");
		assertEquals(SINGLE_DIGIT, result);
	}
	
	@Test
	public void checkForInValidSingleLengthString() {
		Calculator obj = new Calculator();
		long result = obj.add("a");
		assertEquals(INVALID_SINGLE_DIGIT, result);
	}
	
	@Test
	public void checkForTheSumOfNumbersInStringWithComma() {
		Calculator obj = new Calculator();
		long result = obj.add("1,2,3");
		assertEquals(NUMBER_SUM_IF_COMMA, result);
	}
	
	@Test
	public void checkForInvalidStringWithComma() {
		Calculator obj = new Calculator();
		long result = obj.add("a,b");
		assertEquals(INVALID_SINGLE_DIGIT, result);
	}
	
	@Test
	public void checkForTheSumOfNumbersInStringNewLineTag() {
		Calculator obj = new Calculator();
		long result = obj.add("1\n2,3");
		assertEquals(NUMBER_SUM_IF_NEWLINETAG_COMMA, result);
		result = obj.add("1\n2\n3");
		assertEquals(NUMBER_SUM_IF_NEWLINETAG, result);
	}
	
	@Test
	public void checkForDoubleSlashInTheStringWithSemiColon() {
		Calculator obj = new Calculator();
		long result = obj.add("//;1\n2;3");
		assertEquals(NUMBER_SUM_IF_DBLSTASH_NEWLINETAG, result);
	}
	
	@Test
	public void checkForSingleNegativeNumberInTheString() {
		Calculator obj = new Calculator();
		
		NumberFormatException exception = assertThrows(NumberFormatException.class, 
				() -> {
					obj.add("1,-2,4");
				});
		assertEquals(MESSAGE, exception.getMessage());
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
