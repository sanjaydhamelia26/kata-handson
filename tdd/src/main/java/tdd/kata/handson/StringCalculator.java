package tdd.kata.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		String actulaInput = decideInputString(input);
		String splitPattern = decideSplitPattern(input);
				
		List<Integer> inputNumbers = Arrays.stream(actulaInput.split(splitPattern))
										.map(Integer::parseInt).collect(Collectors.toList());
		
		validateNumbers(inputNumbers);
		
		return addNumbers(inputNumbers);
	}
	
	public int addNumbers(List<Integer> inputNumbers) {
		int sum = 0;
		for (Integer number : inputNumbers) {
			sum += number < 1000 ? number : 0;
		}
		return sum;
	}

	public void validateNumbers(List<Integer> inputNumbers) {
		List<Integer> negativeNumberList = inputNumbers.stream().filter(n -> n < 0).collect(Collectors.toList());
		
		if (negativeNumberList.size() > 0) {
			String negativeNumber = negativeNumberList.stream().map(String::valueOf).collect(Collectors.joining(","));
			throw new IllegalArgumentException("Negative Number: " + negativeNumber + " not allowed");
		}
	}
	
	public String decideSplitPattern(String input) {
		String splitPattern = ",|\\n";
		if (input.startsWith("//")) {
			String[] inputs = input.split("\n");
			if (inputs.length > 1) {
				splitPattern = identifyDelimeter(inputs[0]);
			}
		}
		
		return splitPattern;
	}

	private String identifyDelimeter(String input) {
		int delimeterStartPosition = input.indexOf("//")+2;
		
		List<String> listOfDelimeters = new ArrayList<>();
		int startPosOfMutipleDelimeter = 0;
		
		for (int i = delimeterStartPosition; i < input.length(); i++) {
			if (input.charAt(i) == '[') {
				startPosOfMutipleDelimeter = i + 1;
				while(input.charAt(++i) != ']');
				listOfDelimeters.add(input.substring(startPosOfMutipleDelimeter,i));
			} else {
				listOfDelimeters.add(String.valueOf(input.charAt(i)));
			}
		}
		
		StringBuilder regex = new StringBuilder();
		for(int i= 0; i < listOfDelimeters.size(); i++) {
			regex.append(Pattern.quote(listOfDelimeters.get(i)));
			if(i<listOfDelimeters.size()-1) {
				regex.append("|");
			}
		}
		
		return regex.toString();
	}
	
	public String decideInputString(String input) {
		if (input.startsWith("//")) {
			String[] inputs = input.split("\n");
			// TODO Length Check
			input = inputs[1];
		}
		return input;
	}
}
