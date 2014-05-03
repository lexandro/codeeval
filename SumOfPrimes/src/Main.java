public class Main {
    public static void main(String[] args) {
        long primeSum = 2;
        long i = 3;
        int primeCounter = 1;
        while (primeCounter < 1000) {
            if (isPrime(i)) {
                primeSum += i;
                primeCounter++;
            }
            i++;
        }
        System.out.println(primeSum);
    }


    private static boolean isPrime(long theNumber) {
        long i = 2;
        while (i < Math.sqrt(theNumber) + 1) {
            if (theNumber % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
