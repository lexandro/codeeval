import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static final Pattern DECIMAL_PATTERN = Pattern.compile("-?\\d+");

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        aPileOfBricks("[4,3] [3,-3]|(1 [10,9,4] [9,4,2])");
//        aPileOfBricks("[67,14] [93,8]|(1 [-29,-74,-87] [10,-83,90]);(2 [-90,-33,32] [43,22,26]);(3 [-3,92,-44] [-59,96,-74]);(4 [-40,-8,70] [49,-87,53]);(5 [59,-16,30] [46,42,40]);(6 [-31,-1,-23] [-74,97,-11]);(7 [28,74,-60] [-97,35,12]);(8 [9,76,41] [-80,-90,-13]);(9 [-14,42,-99] [0,-27,71]);(10 [-20,38,27] [-2,-12,-66])");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                aPileOfBricks(fileLine);

            }
        }
    }

    private static void aPileOfBricks(String fileLine) {
        String[] items = fileLine.split(Pattern.quote("|"));
        Hole hole = Hole.from(items[0]);
        String[] bricksData = items[1].split(";");
        for (String brickData : bricksData) {
            Brick brick = Brick.from(brickData);
            if (hole.isFits(brick)) {
                System.out.println(brick.index);
            }
        }
        //

    }


    private static class Hole {
        int x1;
        int x2;
        int y1;
        int y2;

        public static Hole from(String item) {
            Hole result = new Hole();
            MatcherReader.setMatcher(DECIMAL_PATTERN.matcher(item));
            result.x1 = MatcherReader.nextInt();
            result.y1 = MatcherReader.nextInt();
            result.x2 = MatcherReader.nextInt();
            result.y2 = MatcherReader.nextInt();

            return result;
        }

        public boolean isFits(Brick brick) {

            return true;
        }
    }

    private static class Brick {
        int index;
        int x1;
        int y1;
        int z1;
        int x2;
        int y2;
        int z2;

        public static Brick from(String brickData) {
            Brick result = new Brick();
            MatcherReader.setMatcher(DECIMAL_PATTERN.matcher(brickData));
            result.index = MatcherReader.nextInt();
            result.x1 = MatcherReader.nextInt();
            result.y1 = MatcherReader.nextInt();
            result.z1 = MatcherReader.nextInt();
            result.x2 = MatcherReader.nextInt();
            result.y2 = MatcherReader.nextInt();
            result.z2 = MatcherReader.nextInt();
            return result;
        }
    }


    private static class MatcherReader {
        private static Matcher matcher;

        public static void setMatcher(Matcher matcher) {
            MatcherReader.matcher = matcher;
        }

        public static int nextInt() {
            matcher.find();
            return Integer.parseInt(matcher.group(), 10);
        }
    }
}