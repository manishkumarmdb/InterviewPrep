package interview.asked;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSubstring {

    private String getLongestDistinctSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

    public static void main(String[] args) {
        LongestDistinctSubstring obj = new LongestDistinctSubstring();
        String str = "aabcddd";
        // output = abcd;
        System.out.println("Substrings are : " + obj.getLongestDistinctSubstring(str));
    }
}
