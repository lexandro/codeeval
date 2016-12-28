import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {


    @Test
    public void testWithOneCharacter() throws Exception {
        assertEquals("A", Main.longestCommonSubsequence("A;A"));
    }
}