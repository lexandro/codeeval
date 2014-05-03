import java.lang.Math;import java.lang.String;import java.lang.System;public class Main {

    public static void main(String[] args) {
        int counter = 1000;
        while (counter > 0) {
            counter--;
            if (isPrime(counter) && isPalindrome(counter)) {
                System.out.println(counter);
                break;
            }
        }
    }

    private static boolean isPalindrome(int theNumber) {
        String numberString = String.valueOf(theNumber);
        int i = 0;
        int numberLength = numberString.length();
        while (i <= numberLength / 2) {
            if (numberString.charAt(i) != numberString.charAt(numberLength - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean isPrime(int theNumber) {
        int i = 2;
        while (i < Math.sqrt(theNumber) + 1) {
            if (theNumber % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
