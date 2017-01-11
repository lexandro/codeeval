import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("here", Main.comparePoints("12 13 12 13"));
        assertEquals("NE", Main.comparePoints("0 0 1 5"));
        assertEquals("N", Main.comparePoints("0 1 0 5"));
    }
}