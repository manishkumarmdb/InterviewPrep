package interview.asked;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheSimple<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCacheSimple(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheSimple<Integer, String> cache = new LRUCacheSimple<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache);

        // Access key 2
        cache.get(2);
        System.out.println(cache);
        // Adding new entry evicts
        cache.put(4, "four");
        System.out.println(cache);
    }
}
