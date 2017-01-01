import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void shouldProcessTheExamples() throws Exception {
        assertEquals("easy-peasy$", Main.reverseBurrowsWheelerTransform("yyeep$-aass|"));
        assertEquals("Buffalo buffalo Buffalo buffalo buffalo buffalo Buffalo buffalo$", Main.reverseBurrowsWheelerTransform("oooooooo$  ffffffff     ffffffffuuuuuuuuaaaaaaaallllllllbbBbbBBb|"));
        assertEquals("James while John had had had had had had had had had had had a better effect on the teacher$", Main.reverseBurrowsWheelerTransform("edarddddddddddntensr$  ehhhhhhhhhhhJ aeaaaaaaaaaaalhtf thmbfe           tcwohiahoJ eeec t e |"));
        assertEquals("Neko no ko koneko, shishi no ko kojishi$", Main.reverseBurrowsWheelerTransform("ooooio,io$Nnssshhhjo  ee  o  nnkkkkkkii |"));
    }


}