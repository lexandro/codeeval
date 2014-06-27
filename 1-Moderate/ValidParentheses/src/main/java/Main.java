import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;


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
                validParentheses(fileLine);
            }
        }
    }

    private static void validParentheses(String fileLine) {
        boolean result = true;
        Stack<Character> openingBracketsStack = new Stack<>();
        //
        for (char character : fileLine.toCharArray()) {
            if (isLeftBracket(character)) {
                openingBracketsStack.push(character);
            } else if (isRightBracket(character)) {
                if (openingBracketsStack.isEmpty() || !isClosingTheLastBracket(openingBracketsStack.pop(), character)) {
                    result = false;
                    break;
                }
            }
        }
        //
        if (!openingBracketsStack.isEmpty()) {
            result = false;
        }
        System.out.println(result ? "True" : "False");
    }

    private static boolean isLeftBracket(char character) {
        return character == '(' || character == '{' || character == '[';
    }

    private static boolean isRightBracket(char character) {
        return character == ')' || character == '}' || character == ']';
    }

    private static boolean isClosingTheLastBracket(Character lastBracket, char character) {
        return (lastBracket == '(' && character == ')') ||
                (lastBracket == '{' && character == '}') ||
                (lastBracket == '[' && character == ']');
    }
}