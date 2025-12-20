package interview.asked;

import java.util.Arrays;

public class ReverseWords {

    public static String[] reverseWord(String[] S) {
        int left = 0;
        int right = S.length - 1;
        while (left < right) {
            String leftStr = S[left];
            S[left++] = S[right];
            S[right--] = leftStr;
        }

        return S;
    }

    public static void main(String[] args) {
        String[] input = new String[] {"manish", "mani", "deepak", "push", "pop"};
        System.out.println(Arrays.toString(reverseWord(input)));
    }
}
