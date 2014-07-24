import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private ByteArrayOutputStream outStream;

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testWith3_1() throws Exception {
        // when
        Main.locks("3 1");
        // then
        assertEquals("2", outStream.toString().trim());
    }

    @Test
    public void testWith100_100() throws Exception {
        // when
        Main.locks("100 100");
        // then
        assertEquals("50", outStream.toString().trim());
    }
}