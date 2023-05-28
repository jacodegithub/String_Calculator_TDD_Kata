package com.string_calculator.test;

import static org.junit.jupiter.api.Assertions.*;
 
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class StringCalculator {

	private static final String INPUT_MULTI_NEG_STRING = "1,-2,-2,-3,-6,4";
	private static final String INPUT_SINGLE_NEG_STRING = "1,-2,4";
	private static final String INPUT_DOUBLE_SLASH = "//;1\n2;3";
	private static final String INPUT_WITH_ONLY_NEWLINETAG = "1\n2\n3";
	private static final String INPUT_WITH_NEW_LINETAG = "1\n2,3";
	private static final String INPUT_STRING_WITH_NODIGIT = "a,b";
	private static final String INPUT_WITH_ONLY_COMMA = "1,2,3";
	private static final String INVALID_SINGLE_LENGTH_STRING = "a";
	private static final String INPUT_SINGLE_DIGIT = "1";
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
		long result = obj.add(INPUT_SINGLE_DIGIT);
		assertEquals(SINGLE_DIGIT, result);
	}
	
	@Test
	public void checkForInValidSingleLengthString() {
		Calculator obj = new Calculator();
		long result = obj.add(INVALID_SINGLE_LENGTH_STRING);
		assertEquals(INVALID_SINGLE_DIGIT, result);
	}
	
	@Test
	public void checkForTheSumOfNumbersInStringWithComma() {
		Calculator obj = new Calculator();
		long result = obj.add(INPUT_WITH_ONLY_COMMA);
		assertEquals(NUMBER_SUM_IF_COMMA, result);
	}
	
	@Test
	public void checkForInvalidStringWithComma() {
		Calculator obj = new Calculator();
		long result = obj.add(INPUT_STRING_WITH_NODIGIT);
		assertEquals(INVALID_SINGLE_DIGIT, result);
	}
	
	@Test
	public void checkForTheSumOfNumbersInStringNewLineTag() {
		Calculator obj = new Calculator();
		long result = obj.add(INPUT_WITH_NEW_LINETAG);
		assertEquals(NUMBER_SUM_IF_NEWLINETAG_COMMA, result);
		result = obj.add(INPUT_WITH_ONLY_NEWLINETAG);
		assertEquals(NUMBER_SUM_IF_NEWLINETAG, result);
	}
	 
	@Test
	public void checkForDoubleSlashInTheStringWithSemiColon() {
		Calculator obj = new Calculator();
		long result = obj.add(INPUT_DOUBLE_SLASH);
		assertEquals(NUMBER_SUM_IF_DBLSTASH_NEWLINETAG, result);
	}
	
	@Test
	public void checkForSingleNegativeNumberInTheString() {
		Calculator obj = new Calculator();
		
		NumberFormatException exception = assertThrows(NumberFormatException.class, 
				() -> {
					obj.add(INPUT_SINGLE_NEG_STRING);
				});
		assertEquals(MESSAGE, exception.getMessage());
	}
	
	@Test 
	public void checkForMultipleNegativeNumberInTheString() {
		Calculator obj = new Calculator();
		
		NumberFormatException exception = assertThrows(NumberFormatException.class, 
				() -> {
					obj.add(INPUT_MULTI_NEG_STRING);
				});
		List<Integer> list = obj.getNegativeNumbers(exception);
		List<Integer> negNumbers = Arrays.asList(-2,-2,-3,-6);
		assertEquals(list, negNumbers);
	}
}
