package com.string_calculator.test;

public class Calculator {
	
	public int add(String string) {
		if(string.isEmpty()) return 0;
		
		String[] str = string.split(",");
		for(String s : str) {
			if(Character.isLetter(s.charAt(0))) {
				return -1;
			}
		}
		return 1;
	}
}
