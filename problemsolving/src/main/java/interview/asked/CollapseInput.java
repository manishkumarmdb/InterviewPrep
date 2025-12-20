package interview.asked;

public class CollapseInput {
    public static String collapseInput(String input) {
        if (input.isEmpty())
            return "";
        String result = "";
        int count = 1;
        char ch = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != ch) {
                result += count + Character.toString(ch);
                ch = input.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        result += count + Character.toString(ch);
        return result;
    }

    public static void main(String[] args) {
        String input = "AAABCCCddff";
        System.out.println(collapseInput(input));
    }
}
