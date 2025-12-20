package interview.asked;

import java.util.LinkedHashMap;
import java.util.Map;

public class DistinctCharacters {
    public static void main(String[] args) {
        String str = "manishkumar";

        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, true);
            } else {
                map.put(ch, false);
            }
        }
        String result = "";
        for (Map.Entry<Character, Boolean> e : map.entrySet()) {
            if (!e.getValue()) {
                result += e.getKey();
            }
        }

        System.out.println(result);
    }
}
