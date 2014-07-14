import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            ageDestribution(fileLine);
        }
    }

    private static void ageDestribution(String fileLine) {
        int age = Integer.valueOf(fileLine, 10);
        String result = null;
        if (inBetween(age, 0, 2)) {
            result = "Home";
        } else if (inBetween(age, 3, 4)) {
            result = "Preschool";
        } else if (inBetween(age, 5, 11)) {
            result = "Elementary school";
        } else if (inBetween(age, 12, 14)) {
            result = "Middle school";
        } else if (inBetween(age, 15, 18)) {
            result = "High school";
        } else if (inBetween(age, 19, 22)) {
            result = "College";
        } else if (inBetween(age, 23, 65)) {
            result = "Work";
        } else if (inBetween(age, 66, 100)) {
            result = "Retirement";
        }
        System.out.println(result == null ? "This program is for humans" : result);
    }

    private static boolean inBetween(int age, int minAge, int maxAge) {
        return age >= minAge && age <= maxAge;
    }
}