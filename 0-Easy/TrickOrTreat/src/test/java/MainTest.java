import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("4", Main.trickOrTreat("Vampires: 1, Zombies: 1, Witches: 1, Houses: 1"));
        assertEquals("36", Main.trickOrTreat("Vampires: 3, Zombies: 2, Witches: 1, Houses: 10"));
    }
}