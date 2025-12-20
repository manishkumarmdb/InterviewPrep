package interview.asked;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = 50;
        getPrimeNumbers(n);
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        System.out.println("Math.sqrt of " + number + "->" + Math.sqrt(number));
        for (int i = 5; i <= Math.sqrt(number); i += 6) {
            System.out.println("i->" + i);
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void getPrimeNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime.");
            }
        }
    }
}
