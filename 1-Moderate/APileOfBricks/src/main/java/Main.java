import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available createFrom https://github.com/lexandro/codeeval
 */
public class Main {

    private static final Pattern DECIMAL_PATTERN = Pattern.compile("-?\\d+");

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
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
        Hole hole = Hole.createFrom(items[0]);
        String[] bricksData = items[1].split(";");
        //
        boolean[] brickFits = listSmallBricks(hole, bricksData);
        //
        StringBuilder result = createSortedListTextOfSmallBricks(brickFits);
        System.out.println(result.length() == 0 ? '-' : result.toString());
    }

    private static boolean[] listSmallBricks(Main.Hole hole, String[] bricksData) {
        boolean[] brickFits = new boolean[bricksData.length];
        for (int i = 0; i < bricksData.length; i++) {
            Main.Brick brick = Main.Brick.createFrom(bricksData[i]);
            if (hole.isBiggerThan(brick)) {
                brickFits[i] = true;
            }
        }
        return brickFits;
    }

    private static StringBuilder createSortedListTextOfSmallBricks(boolean[] brickFits) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < brickFits.length; i++) {
            if (brickFits[i]) {
                result.append(i + 1).append(',');
            }
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result;
    }


    private static class Hole extends Rectangle {

        private Hole(int x1, int y1, int x2, int y2) {
            super(x1, y1, x2, y2);
        }

        public static Hole createFrom(String holeString) {
            MatcherReader matcherReader = MatcherReader.fromMatcher(DECIMAL_PATTERN.matcher(holeString));
            //
            int x1 = matcherReader.nextInt();
            int y1 = matcherReader.nextInt();
            int x2 = matcherReader.nextInt();
            int y2 = matcherReader.nextInt();
            //
            return new Hole(x1, y1, x2, y2);
        }

        public boolean isBiggerThan(Brick brick) {
            for (Rectangle side : brick.brickSides) {
                if (side.width <= width && side.height <= height) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Brick {
        int index;
        Rectangle[] brickSides;

        private static Brick createFrom(String brickData) {
            MatcherReader matcherReader = MatcherReader.fromMatcher(DECIMAL_PATTERN.matcher(brickData));
            //
            Brick result = new Brick();
            result.index = matcherReader.nextInt();
            int x1 = matcherReader.nextInt();
            int y1 = matcherReader.nextInt();
            int z1 = matcherReader.nextInt();
            int x2 = matcherReader.nextInt();
            int y2 = matcherReader.nextInt();
            int z2 = matcherReader.nextInt();
            //
            result.brickSides = new Rectangle[3];
            result.brickSides[0] = new Rectangle(x1, y1, x2, y2);
            result.brickSides[1] = new Rectangle(x1, z1, x2, z2);
            result.brickSides[2] = new Rectangle(y1, z1, y2, z2);

            return result;
        }
    }

    private static class Rectangle {

        protected int width;
        protected int height;

        private Rectangle(int x1, int y1, int x2, int y2) {
            int sideA = max(Math.abs(x1 - x2), Math.abs(x2 - x1));
            int sideB = max(Math.abs(y1 - y2), Math.abs(y2 - y1));
            //
            width = max(sideA, sideB);
            height = min(sideA, sideB);
        }
    }

    private static class MatcherReader {
        private Matcher matcher;

        public MatcherReader(Matcher matcher) {
            this.matcher = matcher;
        }

        public static MatcherReader fromMatcher(Matcher matcher) {
            return new MatcherReader(matcher);
        }

        public int nextInt() {
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(), 10);
            } else {
                throw new IllegalArgumentException("No more matching item left!");
            }

        }
    }

}