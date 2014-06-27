import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
                flaviusJosephus(fileLine);
            }
        }
    }

    private static void flaviusJosephus(String fileLine) {
        String[] items = fileLine.split(",");
        int size = Integer.valueOf(items[0]);
        int step = Integer.valueOf(items[1]);
        int amountOfLiving = size;
        boolean[] isDead = new boolean[size];
        //
        int index = -1;
        // go until everyone dies
        while (amountOfLiving-- > 0) {
            // find next living
            int i = 0;
            while (i < step) {
                index = index == size - 1 ? 0 : index + 1;
                if (!isDead[index]) {
                    i++;
                }
            }
            isDead[index] = true;
            System.out.print(index + " ");
        }
        System.out.println();
    }

}
