package tdd.kata.handson;

import java.util.Arrays;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		String actulaInput = decideInputString(input);
		int sum = Arrays.stream(actulaInput.split(decideSplitPattern(input))).mapToInt(Integer::parseInt).sum();
		
		return sum;
	}
	
	private String decideSplitPattern(String input) {
		String splitPattern = ",|\\n";
		if (input.startsWith("//")) {
			int indexOf = input.indexOf("\n");
			String substring = input.substring(0, indexOf);
			splitPattern = String.valueOf(substring.charAt(substring.length()-1));
		}
		
		return splitPattern;
	}
	
	private String decideInputString(String input) {
		if (input.startsWith("//")) {
			String[] inputs = input.split("\n");
			// TODO Length Check
			input = inputs[1];
		}
		return input;
	}
}
