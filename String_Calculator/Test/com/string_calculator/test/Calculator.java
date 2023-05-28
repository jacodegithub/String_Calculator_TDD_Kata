package com.string_calculator.test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
 
public class Calculator {
	private static final String DOUBLE_SLASH = "//";
	private static final String NEW_LINE_TAG = "\n";
	private static final String COMMA = ",";
	private static final String MORE = "more";
	private static final String ONE = "one";
	private static final String MESSAGE = "Negatives are not allowed";
	private static final int SINGLE_LENGTH = 1;
	private static final int ERROR = -1;
	private static final int EMPTY = 0;
	private List<Integer> list = new ArrayList<>();
	
	public int add(String string) {
		boolean comma = string.contains(COMMA);
		boolean newLineTag = string.contains(NEW_LINE_TAG);
		boolean doubleSlash = string.contains(DOUBLE_SLASH);		
		
		if(string.isEmpty()) return EMPTY;
		
		if(string.length() == SINGLE_LENGTH) {
			if(Character.isDigit(string.charAt(0))) return SINGLE_LENGTH;
			else return ERROR;
		}
		
		int sum = 0;
		String check = checkForNegative(string);
		if(doubleSlash) {
			sum = engine(string, check, sum);
		}
		else if(comma && newLineTag) {
			sum = engine(string, check, sum);
		}
		else if(newLineTag) {
			sum = engine(string, check, sum);
		}
		else if(comma) {
			sum = engine(string, check, sum);
		}
		return sum;
	}
	
	public int engine(String string, String check, int sum) {
		if(check == ONE) throw new NumberFormatException(MESSAGE);
		else if(check == MORE) throw new NumberFormatException("Negatives are not allowed :"+list);
		else {
			string = string.replaceAll("[^-0-9]", "");
			if(string.isEmpty()) return ERROR;
			for(char s : string.toCharArray()) {
				if(Character.isLetter(s)) {
					return ERROR;
				}
				sum += Integer.parseInt(String.valueOf(s));
			}
		}
		return sum;
	}
	
	public String checkForNegative(String string) {
		
		Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(string);
        
        while(matcher.find()) {
        	int num = Integer.parseInt(matcher.group());
        	list.add(num);
        }
        
        if(list.size() == 1) return ONE;
        else if(list.size() > 1) return  MORE;
        else return "NA";
	}
	
	public List<Integer> getNegativeNumbers(NumberFormatException exception) {
		List<Integer> list = new ArrayList<>();
		String message = exception.getMessage();
		String[] parts = message.split(" :");
		String negativeNumberList = parts[1].replaceAll("[^-,0-9]", "");
		for(String num : negativeNumberList.split(COMMA)) {
			list.add(Integer.parseInt(num));
		}
		return list;
	}
}
