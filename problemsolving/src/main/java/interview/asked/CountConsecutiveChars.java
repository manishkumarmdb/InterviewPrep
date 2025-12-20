package interview.asked;

public class CountConsecutiveChars {

    //AABBAACC -> A2B2A2C2
    //AAABCCC - A3B1C3

    public static void main(String[] args) {
        String input = "AAABCCC";
        String result = "";
        int count = 1;
        char ch = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != ch) {
                result += Character.toString(ch) + count;
                ch = input.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        result += Character.toString(ch) + count;
        System.out.println(result);
    }
}
