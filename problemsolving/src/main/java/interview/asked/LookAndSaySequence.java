package interview.asked;

/*
* Write a program that takes as input an integer n and returns the nth integer in the look-and-say sequence.
* Return the result as a string.
* O/P : "1,11,21,1211,111221,312211,1311221,1113213211"
* */
public class LookAndSaySequence {

    public static void main(String[] args) {
        int n = 8;
        String result = "1";

        for (int i = 2; i <= n; i++) {
            System.out.println(result);
            char currDigit = result.charAt(0);
            String _result = "";
            int occur = 0;
            for (int j = result.length() - 1 ; j >= 0 && result.charAt(j) != ','; j--) {
                if (currDigit == result.charAt(j)) {
                    occur++;
                } else {
                    _result = occur + "" + currDigit + _result;
                    currDigit = result.charAt(j);
                    occur = 1;
                }
                if (j - 1 <= 0 || result.charAt(j - 1) == ',') {
                    _result = "," + occur + "" + currDigit + _result;
                    break;
                }
            }
            result += _result;
        }
        System.out.println("Final result : " + result);
    }
}
