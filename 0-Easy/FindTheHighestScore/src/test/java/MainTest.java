import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("100 250 150", Main.findTheHighestScore("72 64 150 | 100 18 33 | 13 250 -6"));
        assertEquals("13 25 70 44", Main.findTheHighestScore("10 25 -30 44 | 5 16 70 8 | 13 1 31 12"));
        assertEquals("100 200 300 400 500", Main.findTheHighestScore("100 6 300 20 10 | 5 200 6 9 500 | 1 10 3 400 143"));
    }
}