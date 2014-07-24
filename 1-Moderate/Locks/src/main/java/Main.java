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
//        locks("96 2");
//        locks("97 2");
//        locks("98 2");
//        locks("99 2");
//        locks("100 2");
//        locks("101 2");
//        locks("102 2");
//        locks("103 2");
//        locks("104 2");
//        locks("105 2");
//        locks("106 2");
//        locks("908 2");
//        locks("908 6");
//        locks("601 6");
//        locks("962 10");
    }


    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                locks(fileLine);
            }
        }
    }

    protected static void locks(String fileLine) {
//        System.out.println(fileLine);
        String[] items = fileLine.split(" ");
        int numberOfDoors = Integer.parseInt(items[0], 10);
        int requiredRepetitions = Integer.parseInt(items[1], 10);
        //
        boolean[] doors = new boolean[numberOfDoors];
        //

        //
        if (requiredRepetitions > 1) {
//            boolean isEvenAmountOfDoors = (numberOfDoors & 1) == 0;
//            boolean isEvenAmountOfRepetitions = (requiredRepetitions & 1) == 0;
//            int result = 0;
//            if (isEvenAmountOfRepetitions) {
//                result = numberOfDoors / 2;
//            } else {
//                result = (numberOfDoors * 2) / 3 + 1;
//            }
//            if (!isEvenAmountOfDoors) {
//
//                if (isEvenAmountOfRepetitions) {
//                    result--;
//                } else {
//                    result -= 2;
//                }
//
//            }
//            System.out.println("q " + result);

            boolean isEven = (requiredRepetitions & 1) == 0;
            for (int i = 1; i <= doors.length; i++) {
                if (i % 3 != 0 && i % 2 == 0) {
                    doors[i - 1] = true;
                } else if (i % 3 == 0 && i % 2 != 0) {
                    doors[i - 1] = isEven;
                }
            }
            doors[numberOfDoors - 1] = !doors[numberOfDoors - 1];
            int count = calculateOpenDoors(doors);
            System.out.println(count);
        } else {
            System.out.println(numberOfDoors - 1);
        }
    }

    private static int calculateOpenDoors(boolean[] doors) {
        int count = 0;
        for (boolean door : doors) {
            if (!door) {
                count++;
            }
        }
        return count;
    }
}