package com.coderbyte;

import java.math.BigInteger;
import java.util.Scanner;

public class BracketCombinations {

    public static int BracketCombinations(int num) {
        // code goes here
        // https://en.wikipedia.org/wiki/Catalan_number
        BigInteger factorial_2num = factorial(2 * num);
        BigInteger factorial_num1 = factorial(num + 1);
        BigInteger factorial_num = factorial(num);
        BigInteger result = factorial_2num.divide(factorial_num1.multiply(factorial_num));

        return result.intValue();
    }

    private static BigInteger factorial(int num) {
        if (num <= 1)
            return BigInteger.ONE;
        return BigInteger.valueOf(num).multiply(factorial(num - 1));
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        //System.out.print(BracketCombinations(Integer.valueOf(s.nextLine())));

        // factorial test
        System.out.println("Factorial: " + factorial(20));
    }
}
