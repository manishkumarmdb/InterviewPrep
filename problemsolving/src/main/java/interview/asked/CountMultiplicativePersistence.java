package interview.asked;

public class CountMultiplicativePersistence {

    public static int persistence(long num) {
        if (num < 10) {
            return 0;
        }

        int count = 0;
        System.out.println("number : " + num);
        while (num > 9) {
            num = digitsProduct(num);
            System.out.println("digitsProduct : " + num);
            count++;
        }

        return count;
    }

    private static long digitsProduct(long num) {
        long product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }

    public static void main(String[] args) {
        int input = 39;
        System.out.println(persistence(input));
    }
}
