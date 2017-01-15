import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("Merlot", Main.chardonnayOrCabernet("Cabernet Merlot Noir | ot"));
        assertEquals("Chardonnay Sauvignon", Main.chardonnayOrCabernet("Chardonnay Sauvignon | ann"));
        assertEquals("False", Main.chardonnayOrCabernet("Shiraz Grenache | o"));
    }
}