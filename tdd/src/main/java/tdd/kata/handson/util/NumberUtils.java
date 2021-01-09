package tdd.kata.handson.util;

import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {

	public static int addNumbers(List<Integer> inputNumbers) {
		int sum = 0;
		for (Integer number : inputNumbers) {
			sum += number;
		}
		return sum;
	}

	public static void validateNumbers(List<Integer> inputNumbers) {
		List<Integer> negativeNumberList = inputNumbers.stream().filter(n -> n < 0).collect(Collectors.toList());
		
		if (negativeNumberList.size() > 0) {
			String negativeNumber = negativeNumberList.stream().map(String::valueOf).collect(Collectors.joining(","));
			throw new IllegalArgumentException("Negative Number: " + negativeNumber + " not allowed");
		}
	}
}
