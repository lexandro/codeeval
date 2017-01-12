import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("0Always4 8look5 9on4 2the7 8bright4 7side9 8of3 5life5", Main.swapNumbers("4Always0 5look8 4on9 7the2 4bright8 9side7 3of8 5life5"));
        assertEquals("5Nobody5 3expects7 4the5 4Spanish6 0inquisition9", Main.swapNumbers("5Nobody5 7expects3 5the4 6Spanish4 9inquisition0"));
    }
}