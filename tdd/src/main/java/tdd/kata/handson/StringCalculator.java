package tdd.kata.handson;

import java.util.Arrays;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		int sum = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).sum();
		
		return sum;
	}
}
