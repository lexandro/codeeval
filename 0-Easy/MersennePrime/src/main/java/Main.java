import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;

/*
  Author: Robert Stern (lexandro2000@gmail.findTheHighestScore)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static LinkedList<Integer> primeCache = new LinkedList<>();
    private static LinkedList<Integer> mersenneCache = new LinkedList<>();
    //

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        Files.lines(Paths.get(args[0])).map(Main::mersennePrime).forEach(System.out::println);

    }

    static String mersennePrime(String fileLine) {
        int limit = Integer.parseInt(fileLine);
        if (primeCache.isEmpty() || primeCache.peekLast() < limit) {
            populatePrimeCache(limit);
        }
        return mersenneCache.stream().filter(p -> p <= limit).map(String::valueOf).reduce("", (a, b) -> "" + a + (a.length() > 0 ? ", " : "") + b);
    }

    private static void populatePrimeCache(int limit) {
        // make it odd :)
        limit = Double.valueOf(Math.ceil(Math.log(limit + 1) / Math.log(2))).intValue() + 1;
        //
        int start = primeCache.isEmpty() ? 2 : primeCache.peekLast() + 1;
        for (int i = start; i <= limit; i++) {
            if (isPrime(i)) {
                primeCache.add(i);
                int mersenneCandidate = Double.valueOf(Math.pow(2, i) - 1).intValue();
                if (isPrime(mersenneCandidate)) {
                    mersenneCache.add(mersenneCandidate);
                }
            }
        }
    }

    private static boolean isPrime(int number) {
        if (primeCache.isEmpty()) {
            return true;
        }
        Iterator<Integer> iter = primeCache.iterator();
        int i = iter.next();
        int sqrt = Double.valueOf(Math.sqrt(number)).intValue() + 1;
        while (i <= sqrt && iter.hasNext()) {
            if (number % i == 0) {
                return false;
            }
            i = iter.next();
        }
        return true;
    }
}