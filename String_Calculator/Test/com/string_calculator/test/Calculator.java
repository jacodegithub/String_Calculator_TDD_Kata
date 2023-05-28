package com.string_calculator.test;

import java.util.List;
import java.util.ArrayList;

public class Calculator {
	
	public int add(String string) {
		boolean comma = string.contains(",");
		boolean newLineTag = string.contains("\n");
		boolean doubleSlash = string.contains("//");
		
		List<Integer> list = new ArrayList<>();
		
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
				if(Character.isLetter(s)) {
					return -1;
				}
				if(Integer.parseInt(String.valueOf(s)) < 0) {
					list.add(Integer.parseInt(String.valueOf(s)));
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
			if(list.size() == 1) throw new NumberFormatException("Negatives are not allowed");
			else if(list.size() > 1) throw new NumberFormatException("Negatives are not allowed :"+list);
		}
		else if(comma && newLineTag) {
			string = string.replace("\n", "").replace(",", "");
			for(char s : string.toCharArray()) {
				if(Character.isLetter(s)) {
					return -1;
				}
				if(Integer.parseInt(String.valueOf(s)) < 0) {
					list.add(Integer.parseInt(String.valueOf(s)));
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
			if(list.size() == 1) throw new NumberFormatException("Negatives are not allowed");
			else if(list.size() > 1) throw new NumberFormatException("Negatives are not allowed :"+list);
		}
		else if(newLineTag) {
			string = string.replace("\n", "");
			for(char s : string.toCharArray()) {
				if(Character.isLetter(s)) {
					return -1;
				}
				if(Integer.parseInt(String.valueOf(s)) < 0) {
					list.add(Integer.parseInt(String.valueOf(s)));
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
			if(list.size() == 1) throw new NumberFormatException("Negatives are not allowed");
			else if(list.size() > 1) throw new NumberFormatException("Negatives are not allowed :"+list);
		}
		else if(comma) {
			String[] str = string.split(",");
			for(String s : str) {
				if(Character.isLetter(s.charAt(0))) {
					return -1;
				}
				if(Integer.parseInt(String.valueOf(s)) < 0) {
					list.add(Integer.parseInt(String.valueOf(s)));
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
			if(list.size() == 1) throw new NumberFormatException("Negatives are not allowed");
			else if(list.size() > 1) throw new NumberFormatException("Negatives are not allowed :"+list);
		}
		return sum;
	}
	
	public List<Integer> getNegativeNumbers(NumberFormatException exception) {
		List<Integer> list = new ArrayList<>();
		String message = exception.getMessage();
		String[] parts = message.split(" :");
		String negativeNumberList = parts[1].replaceAll("[^-,0-9]", "");
		for(String num : negativeNumberList.split(",")) {
			list.add(Integer.parseInt(num));
		}
		return list;
	}
}
