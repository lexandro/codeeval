import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("EXALTATION", Main.gronsfeldCipher("31415;HYEMYDUMPS"));
        assertEquals("I love challenges!", Main.gronsfeldCipher("45162;M%muxi%dncpqftiix\""));
        assertEquals("Test input.", Main.gronsfeldCipher("14586214;Uix!&kotvx3"));
    }


}