import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("6", Main.minimumDistance("4 3 3 5 7"));
        assertEquals("20", Main.minimumDistance("3 20 30 40"));
    }
}