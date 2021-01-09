package tdd.kata.handson.util;

public class StringUtils {
	
	public static String decideSplitPattern(String input) {
		String splitPattern = ",|\\n";
		if (input.startsWith("//")) {
			int indexOf = input.indexOf("\n");
			String substring = input.substring(0, indexOf);
			splitPattern = String.valueOf(substring.charAt(substring.length()-1));
		}
		
		return splitPattern;
	}
	
	public static String decideInputString(String input) {
		if (input.startsWith("//")) {
			String[] inputs = input.split("\n");
			// TODO Length Check
			input = inputs[1];
		}
		return input;
	}
}
