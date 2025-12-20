package interview.asked;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        String input = "232";
        List<String> result = obj.letterCombinations(input);
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] S = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinations(digits, S, result, 0, "");

        return result;
    }

    public void letterCombinations(String digits, String[] S, List<String> result, int currIndex, String ans) {
        if (currIndex == digits.length()) {
            result.add(ans);
        }
        String temp = currIndex < digits.length() ? S[Integer.parseInt(digits.charAt(currIndex) + "")] : "";
        for (int i = 0; i < temp.length(); i++) {
            letterCombinations(digits, S, result, currIndex + 1, ans + temp.charAt(i));
        }
    }
}
