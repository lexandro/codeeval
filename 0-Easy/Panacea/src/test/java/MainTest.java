import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("True", Main.panacea("64 6e 78 | 100101100 11110"));
        assertEquals("True", Main.panacea("5e 7d 59 | 1101100 10010101 1100111"));
        assertEquals("False", Main.panacea("93 75 | 1000111 1011010 1100010"));
    }


}