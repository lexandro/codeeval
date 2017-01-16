import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("3", Main.mersennePrime("4"));
        assertEquals("3, 7, 31, 127", Main.mersennePrime("308"));
        assertEquals("3, 7, 31, 127, 2047", Main.mersennePrime("3000"));
    }
}