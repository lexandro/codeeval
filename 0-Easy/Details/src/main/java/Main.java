import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).forEach(Main::cleanUpTheWords);
    }

    protected static void cleanUpTheWords(String fileLine) {
        String[] lines = fileLine.split(",");
        //
        System.out.println(
                Stream
                        .of(lines)
                        .filter(line -> !line.isEmpty())
                        .mapToInt(Main::getDistance)
                        .min()
                        .getAsInt());

    }

    private static int getDistance(String line) {
        int firstPos = line.indexOf('.');
        int lastPos = line.lastIndexOf('.');

        return isConnected(line, firstPos, lastPos) ? 0 : lastPos - firstPos + 1;

    }

    private static boolean isConnected(String line, int firstPos, int lastPos) {
        return firstPos == -1 || line.charAt(firstPos - 1) == 'Y' || line.charAt(lastPos + 1) == 'X';
    }
}