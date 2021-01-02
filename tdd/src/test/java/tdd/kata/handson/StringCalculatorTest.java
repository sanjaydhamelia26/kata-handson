package tdd.kata.handson;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	
	@Test
	public void sumMustBeZeroForEmptyString() {
		StringCalculator calculator = new StringCalculator();
		int sum = calculator.add("1,2");
		assertEquals(0, sum);
	}
}
