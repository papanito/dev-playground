package com.wyssmann.sampleapps.simpleconsole;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.wyssmann.sampleapps.exceptions.InvalidCommandException;

@RunWith(Parameterized.class)
public class SimpleConsoleParseExceptionTests {
		
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
            { "-p test test"},
            { "-echo test"},
            { "&echo test"},
            { ".echo test ddd"},
            { "te&st command -p 123 -qe master12 command2 | tests command" },
            { "&test command -p 123 -qe master12 command2" },
            { "-test dc -p23 " },
            { "test@ test -p123 "},
            { "test@ -p 123 test "}
        });
    }

    private String fInputCommand;

    public SimpleConsoleParseExceptionTests(String input) {
    	fInputCommand= input;
    }

	@Test(expected = InvalidCommandException.class) 
	public void throwInvalidCommandException() throws InvalidCommandException {
		SimpleConsole.parse_input(fInputCommand);
	}
}
