package interview.asked;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TargetSumOfPairs {

    public static void main(String[] args) {
        int[] A = new int[]{2,5,6,4,1,9,11,7,1,3,5,6};
        int sum = 11;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Pair, Integer> result = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int diff = sum - A[i];
            if (map.containsKey(diff)) {
                //System.out.println(diff + ", " + A[i]);
                Pair pair = new Pair(diff, A[i]);
                //
                if (result.containsKey(pair)) {
                    result.put(pair, result.get(pair) + 1);
                } else {
                    result.put(pair, 1);
                }

            } else {
                map.put(A[i], i);
            }
        }
        System.out.println(result);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return getX() == pair.getX() && getY() == pair.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
}
