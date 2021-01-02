package tdd.kata.handson;

import org.junit.Test;

public class StringCalculatorTest {

	
	@Test
	public void sumMustBeZeroForEmptyString() {
		StringCalculator calculator = new StringCalculator();
		calculator.add("");
	}
}
