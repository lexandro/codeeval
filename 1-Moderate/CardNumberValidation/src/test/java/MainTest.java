import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldReturn1For1() throws Exception {
        assertEquals("0", Main.cardNumberValidation("1"));
    }

    @Test
    public void shouldIgnoreSpaces() throws Exception {
        assertEquals("1", Main.cardNumberValidation("1 0 4 0"));
    }

    @Test
    public void shouldTestProvidedExamples() throws Exception {
        assertEquals("1", Main.cardNumberValidation("1556 9144 6285 339"));
        assertEquals("0", Main.cardNumberValidation("6363 1811 2857 7650"));
        //
        assertEquals("0", Main.cardNumberValidation("6011 5940 0319 9511"));
        assertEquals("1", Main.cardNumberValidation("5537 0213 6797 6815"));
        assertEquals("0", Main.cardNumberValidation("5574 8363 8022 9735"));
        assertEquals("0", Main.cardNumberValidation("3044 8507 9391 30"));
        assertEquals("1", Main.cardNumberValidation("6370 1675 9034 6211 774"));
    }

    @Test
    public void shouldSumDigitsSummarizeSingleOrDoubleDigits() throws Exception {
        assertEquals(5, Main.sumDigits(5));
        assertEquals(6, Main.sumDigits(15));
    }

    @Test
    public void shouldChar2IntConvertDigitCharToInt() throws Exception {
        assertEquals(5, Main.char2Int('5'));
        assertEquals(0, Main.char2Int('0'));
    }
}