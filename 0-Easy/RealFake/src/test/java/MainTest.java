import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("Real", Main.realFake("9999 9999 9999 9993"));
        assertEquals("Fake", Main.realFake("9999 9999 9999 9999"));
    }
}