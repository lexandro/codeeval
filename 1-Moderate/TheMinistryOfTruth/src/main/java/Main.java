import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws Throwable {
//        solveChallenge(args);
        theMinistryOfTruth("Higher meaning;Hi mean");
        theMinistryOfTruth("this is impossible;im possible");
        theMinistryOfTruth("twenty   two minutes;two minutes");
        theMinistryOfTruth("Higher meaning;e");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                theMinistryOfTruth(fileLine);
            }
        }
    }

    private static void theMinistryOfTruth(String fileLine) {


    }
}