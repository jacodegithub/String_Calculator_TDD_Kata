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

}
