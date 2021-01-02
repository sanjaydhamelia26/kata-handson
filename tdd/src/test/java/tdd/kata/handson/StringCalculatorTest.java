package tdd.kata.handson;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;
	
	/**
	 * Setup method block will be called before running of every test case.
	 * i.e before @Test annotated method @Before will be called  
	 */
	@Before
	public void setup() {
		calculator = new StringCalculator();
	}
	
	@Test
	public void sumMustBeZeroForEmptyString() {
		int sum = calculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void sumMustReturnSameNumberForNonEmptySingleValueString() {
		int sum = calculator.add("10");
		assertEquals(10, sum);
		
		sum = calculator.add("5");
		assertEquals(5, sum);
	}
	
	@Test
	public void sumMustReturnAdditionOfGivenNumberInInputString() {
		int sum = calculator.add("10,5");
		assertEquals(15, sum);
			
		sum = calculator.add("1,2,3,4,5");
		assertEquals(15, sum);
	}
}
