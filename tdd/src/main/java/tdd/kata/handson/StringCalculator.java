package tdd.kata.handson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		String actulaInput = decideInputString(input);
		
		List<Integer> inputNumbers = Arrays.stream(actulaInput.split(decideSplitPattern(input)))
										.map(Integer::parseInt).collect(Collectors.toList());
		
		validateNumbers(inputNumbers);
		
		return addNumbers(inputNumbers);
	}
	
	private int addNumbers(List<Integer> inputNumbers) {
		int sum = 0;
		for (Integer number : inputNumbers) {
			sum += number;
		}
		return sum;
	}

	private void validateNumbers(List<Integer> inputNumbers) {
		List<Integer> negativeNumberList = inputNumbers.stream().filter(n -> n < 0).collect(Collectors.toList());
		if (negativeNumberList.size() > 0) {
			String negativeNumber = negativeNumberList.stream().map(String::valueOf).collect(Collectors.joining(","));
			throw new IllegalArgumentException("Negative Number: " + negativeNumber + " not allowed");
		}
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
