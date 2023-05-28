package com.string_calculator.test;

public class Calculator {
	
	public int add(String string) {
		boolean comma = string.contains(",");
		boolean newLineTag = string.contains("\n");
		boolean doubleSlash = string.contains("//");
		
		if(string.isEmpty()) return 0;
		
		if(string.length() == 1) {
			if(Character.isDigit(string.charAt(0))) return 1;
			else return -1;
		}
		
		int sum = 0;
		if(doubleSlash) {
			if(newLineTag) {
				string = string.replace("\n", ";");
			}
			string = string.replace("//", "").replace(";", "");
			for(char s : string.toCharArray()) {
				//if(s.startsWith(",")) continue;
				System.out.println("t");
				if(Character.isLetter(s)) {
					return -1;
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
		}
		else if(comma && newLineTag) {
			string = string.replace("\n", "").replace(",", "");
			for(char s : string.toCharArray()) {
				if(Character.isLetter(s)) {
					return -1;
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
		}
		else if(newLineTag) {
			string = string.replace("\n", "");
			for(char s : string.toCharArray()) {
				if(Character.isLetter(s)) {
					return -1;
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
		}
		else if(comma) {
			String[] str = string.split(",");
			for(String s : str) {
				if(Character.isLetter(s.charAt(0))) {
					return -1;
				}
				sum += Integer.parseInt(s);
			}
		}
		return sum;
	}
}
