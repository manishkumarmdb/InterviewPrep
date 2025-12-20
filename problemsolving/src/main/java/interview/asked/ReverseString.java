package interview.asked;

public class ReverseString {

    public static String reverse(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char leftCh = str.charAt(left);
            char rightCh = str.charAt(right);
            str = str.substring(0, left)
                    + rightCh
                    + str.substring(left + 1, right)
                    + leftCh
                    + str.substring(right + 1);
            left++;
            right--;
        }

        return str;

    }

    public static void main(String[] args) {
        String input = "manisha";
        System.out.println(reverse(input));
    }
}
