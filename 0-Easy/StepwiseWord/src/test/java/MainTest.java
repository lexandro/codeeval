import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("h *e **l ***l ****o", Main.stepwiseWord("cat dog hello"));
        assertEquals("f *o **o ***t ****b *****a ******l *******l", Main.stepwiseWord("stop football play"));
        assertEquals("m *u **s ***i ****c", Main.stepwiseWord("music is my life"));
    }
}