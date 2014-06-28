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
                prefixExpressions(fileLine);
            }
        }
    }

    // java implementation of http://en.wikipedia.org/wiki/Polish_notation solution
    private static void prefixExpressions(String fileLine) {
        String[] elements = fileLine.split(" ");
        Stack<Double> operands = new Stack<>();
        //
        for (int i = elements.length - 1; i >= 0; i--) {
            if (!isOperand(elements[i])) {
                operands.push(Double.valueOf(elements[i]));
            } else {
                double operand1 = operands.pop();
                double operand2 = operands.pop();
                switch (elements[i]) {
                    case "+":
                        operand1 += operand2;
                        break;
                    case "*":
                        operand1 *= operand2;
                        break;
                    default:
                        operand1 /= operand2;
                        break;
                }
                operands.push(operand1);
            }
        }
        System.out.println(operands.pop().intValue());

    }

    private static boolean isOperand(String element) {
        return "+".equals(element) || "*".equals(element) || "/".equals(element);
    }


}