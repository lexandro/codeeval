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

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                pointInCircle(fileLine);
            }
        }
    }

    private static void pointInCircle(String fileLine) {
        Pattern signedFloat = Pattern.compile("[-]?([0-9]*\\.[0-9]+|[0-9]+)");
        Matcher matcher = signedFloat.matcher(fileLine);
        //
        double centerX = getNextDouble(matcher);
        double centerY = getNextDouble(matcher);
        double radius = getNextDouble(matcher);
        double pointX = getNextDouble(matcher);
        double pointY = getNextDouble(matcher);
        System.out.println(Math.pow((pointX - centerX), 2) + Math.pow((pointY - centerY), 2) < radius * radius);

    }

    private static Double getNextDouble(Matcher matcher) {
        matcher.find();
        return Double.valueOf(matcher.group());
    }
}
