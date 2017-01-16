import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("2H", Main.simpleOrTrump("AD 2H | H"));
        assertEquals("KD KH", Main.simpleOrTrump("KD KH | C"));
        assertEquals("JH", Main.simpleOrTrump("JH 10S | C"));
    }
}