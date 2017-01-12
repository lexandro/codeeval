import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("HEllO", Main.stringMask("hello 11001"));
        assertEquals("World", Main.stringMask("world 10000"));
        assertEquals("CBA", Main.stringMask("cba 111"));
    }
}