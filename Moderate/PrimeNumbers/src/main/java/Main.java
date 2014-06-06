import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    // some caching wouldn't hurt ;)
    private static final LinkedList<Long> primeCache = new LinkedList<>();
    private static long maxPrime = 0;

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            if (!fileLine.isEmpty()) {
                primeNumbers(fileLine);
            }
        }
    }

    private static void primeNumbers(String fileLine) {
        long expectedMax = Long.valueOf(fileLine);
        if (expectedMax > 1) {
            // extend cache if necessary
            ensurePrimesAreCalculatedUntil(expectedMax);
            // then list the primes...
            Iterator<Long> iterator = primeCache.iterator();
            // a little trick to avoid cutting the last character ;)
            StringBuilder result = new StringBuilder(iterator.next().toString());
            while (iterator.hasNext()) {
                long prime = iterator.next();
                if (prime < expectedMax) {
                    result.append(',').append(prime);
                } else {
                    break;
                }
            }
            System.out.println(result.toString());
        }

    }

    private static void ensurePrimesAreCalculatedUntil(long maxValue) {
        if (primeCache.isEmpty()) {
            primeCache.add(2l);
            primeCache.add(3l);
            maxPrime = 3l;
        }

        if (maxPrime <= maxValue) {
            long number = maxPrime + 2;
            while (number <= maxValue) {
                if (isPrime(number)) {
                    primeCache.add(number);
                    maxPrime = number;
                }
                number += 2;

            }
        }
    }

    // use the partially generated primelist ehe-ehe, here's a risk to running over the capacity
    // but this is faster...
    private static boolean isPrime(long theNumber) {
        long limit = (int) (Math.sqrt(theNumber));
        for (long prime : primeCache) {
            if (theNumber % prime == 0) {
                return false;
            } else if (prime > limit) {
                return true;
            }
        }
        return true;
    }
}
