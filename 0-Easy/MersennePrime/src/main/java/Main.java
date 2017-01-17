import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static LinkedList<Long> mersenneCache = new LinkedList<>();
    private static LinkedList<Long> primeCache = new LinkedList<>();
    //

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::mersennePrime).forEach(System.out::println);

    }

    static String mersennePrime(String fileLine) {
        long limit = Long.parseLong(fileLine);
        checkCache(limit);
        return mersenneCache.stream().filter(p -> p <= limit).map(String::valueOf).reduce("", (a, b) -> "" + a + (a.length() > 0 ? ", " : "") + b);
    }

    private static void checkCache(long limit) {
        if (mersenneCache.isEmpty() || mersenneCache.peekLast() < limit) {
            populateCacheUntil(limit);
        }
    }

    private static void populateCacheUntil(long limit) {
        long lastMersennePrime = mersenneCache.isEmpty() ? 1 : mersenneCache.peekLast();
        long lastPrimePower = Double.valueOf(Math.ceil(Math.log(lastMersennePrime + 1) / Math.log(2))).longValue();

        long mersenne = lastMersennePrime;
        long primePower = lastPrimePower;
        while (mersenne < limit) {
            primePower = getNextPrime(primePower);
            mersenne = Double.valueOf(Math.pow(2d, (double) primePower) - 1).longValue();
            mersenneCache.add(mersenne);

        }

    }

    private static long getNextPrime(long lastPrime) {
        while (true) {
            lastPrime++;
            if (isPrime(lastPrime)) {
                return lastPrime;
            }
        }
    }

    // can be cached too...
    private static boolean isPrime(long number) {
        if (number == 2) {
            return true;
        }
        for (long i = 2; i < Math.ceil(Math.sqrt(number)) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


}