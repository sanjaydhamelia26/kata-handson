package tdd.kata.handson;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
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
	
	
	public Object[][] testDataFor_NonEmptySingleValueString() {
		return new Object[][] {
					//Input	 //expectedSum
					{"1",	 	1},
					{"2",		2}
		};
	}

	@Test
	@Parameters(method = "testDataFor_NonEmptySingleValueString")
	public void sumMustReturnSameNumberForNonEmptySingleValueString(String input, int expectedSum) {
		int sum = calculator.add(input);
		assertEquals(expectedSum, sum);
	}
	
	public Object[][] testDataFor_CommaSeperatedString() {
		return new Object[][] {
					//Input			//expectedSum
					{"10,5",	 	 15},
					{"1,2,3,4,5",	 15}
		};
	}
	
	@Test
	@Parameters(method = "testDataFor_CommaSeperatedString")
	public void sumMustReturnAdditionOfGivenNumberInInputString(String input, int expectedSum) {
		int sum = calculator.add(input);
		assertEquals(expectedSum, sum);
	}
}
