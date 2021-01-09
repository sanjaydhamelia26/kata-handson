package tdd.kata.handson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
					// below input for scenarios 2: Allow the Add method to handle an unknown amount of numbers, which was taken in considering by code refactor
					{"1,2,3,4,5",	 15}
		};
	}
	
	@Test
	@Parameters(method = "testDataFor_CommaSeperatedString")
	public void sumMustReturnAdditionOfGivenNumberInInputString(String input, int expectedSum) {
		int sum = calculator.add(input);
		assertEquals(expectedSum, sum);
	}
	
	public Object[][] testDataFor_CommaAndNewLineSeperatedString() {
		return new Object[][] {
			//Input			//expectedSum
			{"1\n2,3",	 	 6},
			// below input for scenarios 2: Allow the Add method to handle an unknown amount of numbers, which was taken in considering by code refactor
			{"1,2,3,4\n5",	 15}
		};
	}	

	@Test
	@Parameters(method = "testDataFor_CommaAndNewLineSeperatedString")
	public void sumMustBeCalculatedForTheInputContainsCommaAndNewLineAsADelimeter(String input, int expectedSum) {
		int sum = calculator.add(input);
		assertEquals(expectedSum, sum);
	}
	
	public Object[][] testDataFor_InputContainsDelimetersItSelf() {
		return new Object[][] {
			//Input			//expectedSum
			{"//;\n1;2",	 3},
			{"//,\n1,2,3",	 6}
		};
	}
	
	@Test
	@Parameters(method = "testDataFor_InputContainsDelimetersItSelf")
	public void sumMustBeCalculatedWhenInputHavingDelimeterDefinitaionItSelf(String input, int expectedSum) {
		int sum = calculator.add(input);
		assertEquals(expectedSum, sum);
	}
	
	@Test
	public void inputWithNegativeNumberMustThrowAnExceptionSayingNumberIsNegative() {
		try {
			calculator.add("1,-2");
			assertTrue(false);
		} catch (Exception e) {
			assertEquals("Negative Number: -2 not allowed", e.getMessage());
			assertTrue(true);
		}
		
		
		try {
			calculator.add("1,-2,-3,-4");
			assertTrue(false);
		} catch (Exception e) {
			assertEquals("Negative Number: -2,-3,-4 not allowed", e.getMessage());
			assertTrue(true);
		}
	}
}
