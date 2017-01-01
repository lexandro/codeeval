import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldReturnAllIfBothSimilar() throws Exception {
        assertEquals("AbCdE123", Main.longestCommonSubSequence("AbCdE123;AbCdE123"));
    }

    @Test
    public void shouldReturnTheCommonCharacter() throws Exception {
//        assertEquals("1", Main.longestCommonSubSequence("AbCdE123;FgHiJkL345"));
    }
}