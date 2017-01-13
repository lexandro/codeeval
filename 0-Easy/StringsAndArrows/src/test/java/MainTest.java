import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("4", Main.stringsAndArrows("<<>>--><--<<--<<>>>--><"));
        assertEquals("2", Main.stringsAndArrows("<--<<--<<"));
        assertEquals("0", Main.stringsAndArrows("<-->>"));
    }
}