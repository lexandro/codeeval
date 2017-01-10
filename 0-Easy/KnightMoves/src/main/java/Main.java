import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static Coords[] steps = {
            new Coords(-1, -2),
            new Coords(1, -2),
            new Coords(-2, -1),
            new Coords(2, -1),
            new Coords(-2, 1),
            new Coords(2, 1),
            new Coords(-1, 2),
            new Coords(1, 2)
    };

    public static void main(String[] args) throws Throwable {

        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::knightMoves).forEach(System.out::println);

    }

    static String knightMoves(String fileLine) {

        int x = fileLine.charAt(0) - 96;
        int y = fileLine.charAt(1) - 48;

        return Arrays.stream(steps)
                .filter(c -> x + c.xAdd > 0 && y + c.yAdd > 0 && x + c.xAdd <= 8 && y + c.yAdd <= 8)
                .map(c -> (new StringBuilder()).append(Character.toChars(x + c.xAdd + 96)).append(Character.toChars(y + c.yAdd + 48)).append(' ').toString())
                .sorted()
                .reduce("", String::concat).trim();
    }

    private static class Coords {
        int xAdd;
        int yAdd;

        Coords(int xAdd, int yAdd) {
            this.xAdd = xAdd;
            this.yAdd = yAdd;
        }

    }
}

