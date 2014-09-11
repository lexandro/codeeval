import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

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
            System.out.println(niceAngles(fileLine));
        }
    }

    protected static String niceAngles(String fileLine) throws ParseException {
        double angle = Double.valueOf(fileLine);
        int hour = (int) angle;
        angle = angle % 1;
        angle *= 3600;
        int minute = (int) angle / 60;
        int second = (int) (angle % 60);
        return String.format("%d.%02d'%02d\"", hour, minute, second);
    }
}