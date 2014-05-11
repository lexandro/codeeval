import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    public static final int I = 1;
    public static final int V = 5;
    public static final int X = 10;
    public static final int L = 50;
    public static final int C = 100;
    public static final int D = 500;
    public static final int M = 1000;


    public static void main(String[] args) throws IOException {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(romanNumerals(fileLine));
        }
    }

    // optimized for speed, not for readibility. I was in the speedy mood :)
    private static String romanNumerals(String csvLine) {
        int number = Integer.valueOf(csvLine);
        return toRomanNumber(number);
    }

    private static String toRomanNumber(int number) {
        StringBuilder result = new StringBuilder();

        while (number > 0) {
            if (number > M) {
                result.append("M");
                number -= M;
            } else if (number >= D && number < M - C) {
                result.append('D');
                number -= D;
            } else {
                if (number >= C) {
                    result.append('C');
                    if (number >= D - C) number += C;
                    else {
                        number -= C;
                    }
                } else {
                    if (number >= L && number < C - X) {
                        result.append('L');
                        number -= L;
                    } else {
                        if (number >= X) {
                            result.append('X');
                            if (number >= L - X) number += X;
                            else {
                                number -= X;
                            }
                        } else {
                            if (number >= V && number < X - I) {
                                result.append('V');
                                number -= V;
                            } else {
                                result.append('I');
                                if (number >= V - I) number++;
                                else {
                                    number--;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result.toString();
    }
}