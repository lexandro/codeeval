import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("e1 e3 f4 h4", Main.knightMoves("g2"));
        assertEquals("b3 c2", Main.knightMoves("a1"));
        assertEquals("b5 b7 c4 c8 e4 e8 f5 f7", Main.knightMoves("d6"));
        assertEquals("c4 c6 d3 d7 f3 f7 g4 g6", Main.knightMoves("e5"));
        assertEquals("a3 c3 d2", Main.knightMoves("b1"));
    }
}