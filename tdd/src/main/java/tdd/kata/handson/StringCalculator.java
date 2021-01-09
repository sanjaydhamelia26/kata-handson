package tdd.kata.handson;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tdd.kata.handson.util.NumberUtils;
import tdd.kata.handson.util.StringUtils;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		String actulaInput = StringUtils.decideInputString(input);
		String splitPattern = StringUtils.decideSplitPattern(input);
		
		List<Integer> inputNumbers = Arrays.stream(actulaInput.split(splitPattern))
										.map(Integer::parseInt).collect(Collectors.toList());
		
		NumberUtils.validateNumbers(inputNumbers);
		
		return NumberUtils.addNumbers(inputNumbers);
	}
}
