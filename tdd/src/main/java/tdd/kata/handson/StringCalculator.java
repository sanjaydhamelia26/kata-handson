package tdd.kata.handson;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		int sum = 0;
		String[] inputArray = input.split(",");
		for (String number : inputArray) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
