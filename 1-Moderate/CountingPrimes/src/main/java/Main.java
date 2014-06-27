import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static final int PRIME_STORE_SIZE = 100;
    private static final int[] primes = new int[PRIME_STORE_SIZE];

    public static void main(String[] args) throws Throwable {
        System.gc();
        generatePrimes();
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                countingPrimes(fileLine);
            }
        }
    }

    private static void countingPrimes(String fileLine) {
        int start = Integer.valueOf(fileLine.substring(0, fileLine.indexOf(',')));
        int end = Integer.valueOf(fileLine.substring(fileLine.indexOf(',') + 1, fileLine.length()));
        int startIndex = primeIndex(start);
        if (primes[startIndex] < start) {
            startIndex++;
        }
        int endIndex = primeIndex(end);
        if (primes[endIndex] > end) {
            endIndex--;
        }
        System.out.println(endIndex - startIndex + 1);
    }

    // find the index of prime that close to the given number with interval halving.
    private static int primeIndex(int numberToTest) {
        int startIndex = 0;
        int endIndex = primes.length - 1;
        while (startIndex != endIndex) {
            int median = (endIndex + startIndex) / 2;
            // is it a prime?
            if (primes[median] == numberToTest) {
                return median;
            } else if (primes[median] > numberToTest) {
                if ((primes[median - 1] < numberToTest)) {
                    return median;
                } else {
                    endIndex = median;
                }
            } else if (primes[median] < numberToTest) {
                if ((primes[median + 1] > numberToTest)) {
                    return median;
                } else {
                    startIndex = median;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private static void generatePrimes() {
        int primeCounter = 1;
        primes[0] = 2;
        int number = 3;
        while (primeCounter < PRIME_STORE_SIZE) {
            if (isPrime(number)) {
                primes[primeCounter] = number;
                primeCounter++;
            }
            number += 2;
        }
    }

    // use the partially generated primelist ehe-ehe
    private static boolean isPrime(int theNumber) {
        int i = 0;
        int limit = (int) (Math.sqrt(theNumber) + 1);
        while (primes[i] < limit) {
            if (theNumber % primes[i++] == 0) {
                return false;
            }
        }
        return true;
    }
}
