import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::panacea).forEach(System.out::println);

    }

    static String panacea(String fileLine) {
        String[] items = fileLine.split("\\|");
        String[] virusHexes = items[0].split(" ");
        String[] avBins = items[1].split(" ");
        //
        int virSum = Arrays.stream(virusHexes).filter(virHex -> virHex.trim().length() > 0).mapToInt(virHex -> Integer.parseInt(virHex, 16)).sum();
        int avSum = Arrays.stream(avBins).filter(avBin -> avBin.trim().length() > 0).mapToInt(avBin -> Integer.parseInt(avBin, 2)).sum();
        return avSum >= virSum ? "True" : "False";
    }
}