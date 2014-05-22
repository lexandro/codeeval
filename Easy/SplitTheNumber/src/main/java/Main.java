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
            System.out.println(splitTheNumber(fileLine));
        }
    }

    private static int splitTheNumber(String fileLine) {
        String[] items = fileLine.split(" ");
        //
        int number1 = 0;
        int number2 = 0;
        char operand = ' ';
        int count = 0;
        //
        for (char item : items[1].toCharArray()) {
            if (item > 96 && item < 123) {
                count++;
            } else {
                number1 = Integer.valueOf(items[0].substring(0, count));
                number2 = Integer.valueOf(items[0].substring(count));
                operand = item;
                break;
            }
        }
        switch (operand) {
            case '-':
                return number1 - number2;
            case '+':
                return number1 + number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
        }
        return 0;

    }
}