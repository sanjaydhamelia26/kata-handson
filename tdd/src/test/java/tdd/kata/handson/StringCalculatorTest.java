package tdd.kata.handson;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	
	@Test
	public void sumMustBeZeroForEmptyString() {
		StringCalculator calculator = new StringCalculator();
		int sum = calculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void sumMustReturnSameNumberForNonEmptySingleValueString() {
		StringCalculator calculator = new StringCalculator();
		
		int sum = calculator.add("10");
		assertEquals(10, sum);
		
		sum = calculator.add("5");
		assertEquals(5, sum);
	}
	
	@Test
	public void sumMustReturnAdditionOfGivenNumberInInputString() {
		StringCalculator calculator = new StringCalculator();
		
		int sum = calculator.add("10, 5");
		assertEquals(15, sum);
	}
}
