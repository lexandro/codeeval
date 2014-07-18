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
        BrickSide a = null;
        //

    }


    private static class Hole {
        int x1;
        int x2;
        int y1;
        int y2;

        public static Hole from(String item) {
            Hole result = new Hole();
            MatcherReader matcherReader = MatcherReader.fromMatcher(DECIMAL_PATTERN.matcher(item));
            result.x1 = matcherReader.nextInt();
            result.y1 = matcherReader.nextInt();
            result.x2 = matcherReader.nextInt();
            result.y2 = matcherReader.nextInt();

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
        BrickSide[] brickSides;

        public static Brick from(String brickData) {
            Brick result = new Brick();
            MatcherReader matcherReader = MatcherReader.fromMatcher(DECIMAL_PATTERN.matcher(brickData));
            result.index = matcherReader.nextInt();
            result.x1 = matcherReader.nextInt();
            result.y1 = matcherReader.nextInt();
            result.z1 = matcherReader.nextInt();
            result.x2 = matcherReader.nextInt();
            result.y2 = matcherReader.nextInt();
            result.z2 = matcherReader.nextInt();
            //
            result.brickSides = new BrickSide[3];
            BrickSide brickSide = new BrickSide(result.x1, result.y1, result.x2, result.y2);
            result.brickSides[0] = brickSide;
            brickSide = new BrickSide(result.x1, result.z1, result.x2, result.z2);
            result.brickSides[1] = brickSide;
            brickSide = new BrickSide(result.y1, result.z1, result.y2, result.z2);
            result.brickSides[2] = brickSide;

            return result;
        }
    }

    private static class BrickSide {
        int x1;
        int y1;
        int x2;
        int y2;

        private BrickSide(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private static class MatcherReader {
        private Matcher matcher;

        public MatcherReader(Matcher matcher) {
            this.matcher = matcher;
        }

        public static MatcherReader fromMatcher(Matcher matcher) {
            MatcherReader result = new MatcherReader(matcher);
            return result;
        }

        public int nextInt() {
            matcher.find();
            return Integer.parseInt(matcher.group(), 10);
        }
    }


}