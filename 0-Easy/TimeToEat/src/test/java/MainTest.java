import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("14:44:45 09:53:27 02:26:31", Main.timeToEat("02:26:31 14:44:45 09:53:27"));
        assertEquals("21:25:41 05:33:44", Main.timeToEat("05:33:44 21:25:41"));
    }
}