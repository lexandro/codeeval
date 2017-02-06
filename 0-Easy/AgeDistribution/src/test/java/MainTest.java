import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        Main.init();
        assertEquals("Still in Mama's arms", Main.ageDistribution("0"));
        assertEquals("College", Main.ageDistribution("19"));
        assertEquals("This program is for humans", Main.ageDistribution("111"));
        assertEquals("This program is for humans", Main.ageDistribution("-1"));
    }
}
