package interview.asked;

import java.util.*;

public class WordsOccurrence {

    static class Word {
        private String name;
        private int value;
        public Word(String name, int value) {
            this.name = name;
            this.value = value;
        }
        //Getter methods
        public String getName() {
            return name;
        }
        public int getValue() {
            return value;
        }

        public String toString() {
            return "Word -> Name: " + this.name + ", Occurrence: " + this.getValue();
        }
    }

    public static void topMostOccurrence(String str, int k) {
        if (str == null || str.isEmpty()) {
            System.out.println("Please provide valid input...");
            return;
        }
        String[] S = str.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String s : S) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }
        List<Word> wordObjList = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Word word = new Word(e.getKey(), e.getValue());
            wordObjList.add(word);
        }
        wordObjList.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        // print the list
        wordObjList.stream().forEach(System.out::println);
    }
    public static void main(String[] args) {
        String str = "Returns a Set view of the mappings contained in this map The set is backed by the map so changes to the map are reflected in the set and vice-versa If the map is modified while an iteration over the set is in progress";
        topMostOccurrence(str, 4);
    }
}
