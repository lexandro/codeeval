import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("3", Main.oneZerosTwoZeros("1 8"));
        assertEquals("1", Main.oneZerosTwoZeros("2 4"));
    }
}