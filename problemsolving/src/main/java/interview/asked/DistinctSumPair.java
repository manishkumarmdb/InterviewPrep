package interview.asked;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctSumPair {

    private static class Pair {
        int key;
        long val;

        public Pair(int key, long val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public long getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(
                Arrays.asList(new Integer[]{6,6,3,5,4,3,4,7,9,9})
        );
        int target = 12;
        // Ist approach
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

        List<Pair> pairs = new ArrayList<>();

        for (Map.Entry<Integer, Long> e : map.entrySet()) {
            long diff = target - e.getKey();
            if (map.containsKey((int) diff) && map.get(e.getKey()) > 0) {
                Pair p = new Pair(e.getKey(), diff);
                pairs.add(p);
                map.put(e.getKey(), (long) 0);
                map.put((int) diff, (long) 0);
            }
        }

        System.out.println(pairs);

        // IInd Approach
        map = new HashMap<>();
        int pairCount = 0;
        for (Integer i : list) {
            Integer diff = target - i;
            if (map.containsKey(diff) && map.get(diff) != 0) {
                pairCount++;
                map.put(i, 0L);
                map.put(diff, 0L);
            } else {
                map.put(i, 1L);
            }
        }
        System.out.println("Distinct pair is : " + pairCount);
    }
}
