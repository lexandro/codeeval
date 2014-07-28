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
        batsChallenge("22 2 2 9 11");
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                batsChallenge(fileLine);
            }
        }
    }

    private static void batsChallenge(String fileLine) {
        String[] elements = fileLine.split(" ");
        int length = Integer.parseInt(elements[0], 10);
        int distance = Integer.parseInt(elements[1], 10);
        int batsAmount = Integer.parseInt(elements[2], 10);
        //

    }
}

class LinkedListNode<T> {

    public T value;
    public LinkedListNode<T> next;


}
