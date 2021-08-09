package com.wyssmann.sampleapps.simpleconsole;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.wyssmann.sampleapps.exceptions.InvalidArgumentsException;
import com.wyssmann.sampleapps.exceptions.InvalidCommandException;


@RunWith(Parameterized.class)
public class SimpleConsoleParseTests {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
             { "command test", 									"command", 2},
             { "command 'test'",								"command", 2},
             { "command test ddd", 								"command", 3},
             { "command \"testtest\"", 							"command", 2},
             { "command 'testtest'", 							"command", 2},
             { "command \"test test\"",							"command", 2},
             { "command 'test test'",							"command", 2},
             { "command -p test test",							"command", 3},
             { "command '-p test test'",						"command", 2},
             { "command -p test \"testtest\"",	 				"command", 3},
             { "command -p test 'testtest'",					"command", 3},
             { "command -p test1 \"testtest1\"",				"command", 3},
             { "command -p  test2 'test test2'",				"command", 3},
             { "command '-p test3 test3'",						"command", 2},
             { "command \"-p  test4 test4.1\"",					"command", 2},
             { "command -p 'test5 test5-1'",					"command", 2},
             { "command -p \"test6 test\"",						"command", 2},
             { "command -p test7 \"testtest\" -c Test",			"command", 4},
             { "command -p  test8 'test test' -q \"test ste\"",	"command", 4},
             { "command '-p test3 test' -q test",				"command", 3},
             { "command -p \"test6 test\" -q \"test \"",		"command", 3},
             { "command -p 'test5 test' -q",					"command", 3}
        });
    }

    private String fInputCommand;
    private String fExpectedCommand;
    private int fExpectedCount;

    public SimpleConsoleParseTests(String input, String expectedCmd, int expectedCount) {
    	fInputCommand= input;
    	fExpectedCommand= expectedCmd;
    	fExpectedCount = expectedCount;
    }
    
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


	@Test
	public void retrunCommandAndParameters() throws InvalidCommandException, InvalidArgumentsException {
		HashMap<String,String> retval = SimpleConsole.parse_input(fInputCommand);
		Assert.assertEquals(fExpectedCommand, retval.get("cmd"));
		Assert.assertEquals(fExpectedCount, retval.size());
	}
	
    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
	
}
