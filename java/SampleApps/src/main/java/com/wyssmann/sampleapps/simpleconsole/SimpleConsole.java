/**
 * I use the simple console to illustrate unit testing with Junit
 * I generally find it more handsome than a simple calculator
 */
package com.wyssmann.sampleapps.simpleconsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wyssmann.sampleapps.exceptions.InvalidCommandException;

/**
 * @author papanito
 * The SimpleConsole evaluates user input from the command line and runs any related 
 * action to the command or returns an appropriate error message on the consoler
 */
public class SimpleConsole {
	static int debug = 1;
	private static String EXIT = "exit";
	private static String ECHO = "echo";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s;
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to SimpleConsole");
		while (true) {
			System.out.print("> ");
			s = reader.nextLine();
			HashMap<String,String> command;
			try {
				command = parse_input(s);
				if (command.get("cmd").equals(EXIT)) {
					break;
				} else {
					System.out.println("'"+command.get("cmd")+"' unknown");
				}
			} catch (InvalidCommandException e) {
				// print stack trace on command line and then continue read next command
				e.printStackTrace();
			}
		}
		reader.close();
	    System.out.println("You are done, have a nice day!");
	}
	
	/**
	 * Parses an input and separates command and input parameters/options of the command using the following regexp
	 * (?:(?=['"].+)['"][^'"]+['"]|(?:(?=\-\S+ +['"].+)\-\S+ +['"][^'"]+['"]|\-\S+ *[^'"\n ]*))
	 * 
	 * @param input Arbitrary input string
	 * @return Map with command and arguments. The key is either "cmd" for command, 1...2 for arguments, a..z for options (e.g. -p test would add a key with value 'p' and 'test' as value
	 * @throws InvalidCommandException 
	 */
	public static HashMap<String, String> parse_input(String input) throws InvalidCommandException {
		String regexpOptions = "(?:(?=['\"].+)['\"][^'\"]+['\"]|(?:(?=\\-\\S+ +['\"].+)\\-\\S+ +['\"][^'\"]+['\"]|\\-\\S+ *[^'\"\\n ]*))";
		String regexpSpecialChars = "[^\\s\\w]+";
		String regexp = regexpOptions + "|\\S+";

		//split input in command and arguments (1st param is always the command)
		String[] arguments = input.split(" ", 2);
		
		HashMap<String, String> myMap = new HashMap<String, String>();
		myMap.put("cmd", arguments[0]);
    	
		/* Throw exception if 
    	 * - first word is not a command (e.g. '-p param command')
    	 * - command or parameter contains special characters (shall be only alphanumeric)
    	 */
    	if ((arguments[0].matches(regexpOptions) || arguments[0].matches(regexpSpecialChars))) {
    		throw new InvalidCommandException(arguments[0] + " is not a valid command");
    	}
		
		/*if (arguments.length > 1) {
			arguments[1].split(regexp);
		}*/
		Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(arguments[1]);
        
        System.out.println("String to parse: " + arguments[1]);
        
        int i = 0;
        matcher.reset();
        while(matcher.find()) {
        	String key;
        	String parameter = arguments[1].substring(matcher.start(), matcher.end());
        	if (debug > 0) {
        		System.out.println("Parameter (" + matcher.start() + "-"+matcher.end() +"): " +  parameter);
        	}
        	
        	if (parameter.matches("\\-\\S+")) {
        		System.out.println("Add string" +  parameter);
        	}
        	
        	key = Integer.toString(i);
        	
        	if (debug > 0) {
        		System.out.println("Add to map ( " +  key + ", " + parameter + ")");
        	}
        	myMap.put(key, parameter);
        	i++;
        }

		return myMap;
	}
	
	/**
	 * @param command command
	 * @param options parameters of the command
	 */
	public static void docommand(String command, String[] options) {
		/*if (!arguments[0].equals(ECHO)) {
			arguments = input.split(" ");
		}*/
	}
}