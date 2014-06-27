import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static Stack stack = new ArrayStack(100);

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                stackImplementation(fileLine);
            }
        }
    }

    public static void stackImplementation(String fileLine) {
        String[] elements = fileLine.split(" ");
        // fill the stack
        for (String element : elements) {
            stack.push(Integer.valueOf(element));
        }
        // read integer;
        Integer stackItem = 0;
        while (stackItem != null) {
            stackItem = stack.pop();
            if (stackItem != null) {
                System.out.print(stackItem + " ");
            }
            stackItem = stack.pop();
        }
        System.out.println();
    }

    public static interface Stack {
        void push(int number);

        Integer pop();
    }

    public static class ArrayStack implements Stack {

        private int[] stackStore;
        private int stackPosition;

        public ArrayStack(int size) {
            stackStore = new int[size];
        }

        @Override
        public void push(int number) {
            // not necessary in this case, but you can't be prepared enough ;)
            if (stackPosition == stackStore.length) {
                int[] newStackStore = new int[stackStore.length * 2];
                System.arraycopy(stackStore, 0, newStackStore, 0, stackStore.length);
                stackStore = newStackStore;
            }
            stackStore[stackPosition++] = number;
        }

        @Override
        public Integer pop() {
            if (stackPosition > 0) {
                return stackStore[--stackPosition];
            }
            return null;
        }
    }
}
