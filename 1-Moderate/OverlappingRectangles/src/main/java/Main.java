import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                overlappingRectangles(fileLine);
            }
        }
    }

    private static void overlappingRectangles(String fileLine) {
        String[] digits = fileLine.split(",");
        Rect first = getRectangle(Arrays.copyOfRange(digits, 0, 4));
        Rect second = getRectangle(Arrays.copyOfRange(digits, 4, 8));
        //
        if (isInside(first, second) || isInside(second, first)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean isInside(Rect first, Rect second) {
        return isInside(first, second.topLeft.x, second.topLeft.y) ||
                isInside(first, second.topLeft.x, second.bottomRight.y) ||
                isInside(first, second.bottomRight.x, second.topLeft.y) ||
                isInside(first, second.bottomRight.x, second.bottomRight.y);
    }

    private static boolean isInside(Rect rect, int x, int y) {
        return x >= rect.topLeft.x && x <= rect.bottomRight.x && y <= rect.topLeft.y && y >= rect.bottomRight.y;
    }

    private static Rect getRectangle(String... digits) {
        int topLeftX = Integer.parseInt(digits[0], 10);
        int topLeftY = Integer.parseInt(digits[1], 10);
        int bottomRightX = Integer.parseInt(digits[2], 10);
        int bottomRightY = Integer.parseInt(digits[3], 10);
        //
        Point topLeft = new Point(topLeftX, topLeftY);
        Point bottomRight = new Point(bottomRightX, bottomRightY);
        return new Rect(topLeft, bottomRight);
    }

    public static class Rect {
        public Point topLeft;
        public Point bottomRight;

        public Rect(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }
    }
}