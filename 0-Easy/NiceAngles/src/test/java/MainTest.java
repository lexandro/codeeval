import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testAll() throws Exception {
        assertEquals("330.23'59\"", Main.niceAngles("330.39991833"));
        assertEquals("0.00'03\"", Main.niceAngles("0.001"));
        assertEquals("14.38'43\"", Main.niceAngles("14.64530319"));
        assertEquals("0.15'00\"", Main.niceAngles("0.25"));
        assertEquals("254.10'11\"", Main.niceAngles("254.16991217"));
    }
}