package interview.asked;

import java.util.HashMap;

public class LRUCache<K, V> {

    // Node class representing each element in the cache
    private class Node {
        K key;
        V value;
        Node prev, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private HashMap<K, Node> cacheMap;  // Map to store key-node pairs
    private Node head, tail;  // Head and tail of the doubly linked list

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        head = new Node(null, null);  // Dummy head node
        tail = new Node(null, null);  // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    // Helper method to add a node to the front (most recent) of the list
    private void addNodeToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper method to remove a node from the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move an existing node to the front of the list (most recent)
    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToFront(node);
    }

    // Remove the least recently used node (from the end of the list)
    private Node removeTail() {
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }

    // Get a value from the cache
    public V get(K key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return null;  // Cache miss
        }
        // Move accessed node to the front of the list
        moveToHead(node);
        return node.value;  // Cache hit
    }

    // Put a value in the cache
    public void put(K key, V value) {
        Node node = cacheMap.get(key);

        if (node == null) {
            // New entry, insert into cache
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addNodeToFront(newNode);

            // If the cache exceeds capacity, remove the LRU item
            if (cacheMap.size() > capacity) {
                Node lruNode = removeTail();
                cacheMap.remove(lruNode.key);
            }
        } else {
            // Update the value and move it to the front
            node.value = value;
            moveToHead(node);
        }
    }

    // For debugging: Print the cache contents
    public void printCache() {
        Node current = head.next;
        while (current != tail) {
            System.out.print("[" + current.key + ":" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");
        lruCache.printCache();  // Output: [3:three] [2:two] [1:one]

        lruCache.get(2);  // Access the key 2
        lruCache.printCache();  // Output: [2:two] [3:three] [1:one]

        lruCache.put(4, "four");  // Adding new entry will evict key 1
        lruCache.printCache();  // Output: [4:four] [2:two] [3:three]
    }
}

