import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                deltaTime(fileLine);
            }
        }
    }

    private static void deltaTime(String fileLine) throws ParseException {
        int spaceIndex = fileLine.indexOf(' ');
        String time1 = fileLine.substring(0, spaceIndex);
        String time2 = fileLine.substring(spaceIndex + 1);
        Long t1 = sdf.parse(time1).getTime();
        Long t2 = sdf.parse(time2).getTime();
        Date diffDate = new Date(max(t1, t2) - min(t1, t2));
        System.out.println(sdf.format(diffDate));


    }
}