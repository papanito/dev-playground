import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)//import UnitTestExample;

public class UnitTestExampleTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { 4, 10, "do that"},
                 { 5, 10, "do this"},
                 { 4, 9, "do this"},
                 { 5, 9, "do this"},
           });
    }

    private int fx;
    private int fy;

    private String fExpected;

    public UnitTestExampleTest(int x, int y, String expected) {
        this.fx = x;
        this.fy = y;
        this.fExpected = expected;
    }

   @Test
    public void doThisReturnValueTest() {
        String  retval = new UnitTestExample().doThis(fx, fy);
        Assert.assertEquals("do this", retval);
    }

    @Test
    public void doThatReturnValueTest() {
        String  retval = new UnitTestExample().doThat(fx, fy);
        Assert.assertEquals("do that", retval);
    }

    @Test
    public void simpleFunctionTest() {
        String  retval = new UnitTestExample().simpleFunction(fx, fy);
        Assert.assertEquals(fExpected, retval);
    }
}
