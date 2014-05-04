//============================================================================
// LRU Cache 
// 
// Design and implement a data structure for Least Recently Used (LRU) cache.
// It should support the following operations: get and set.
//
// get(key) - Get the value (will always be positive) of the key if the key 
// exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. 
// When the cache reached its capacity, it should invalidate the least 
// recently used item before inserting a new item.
//
//============================================================================

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static public class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int k, int v){
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    private final Node head;
    private final Node tail;
    private int size;
    private final int capacity;
    private final Map<Integer, Node> map;

    public LRUCache(int c) {
        capacity = c;
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.next = head;
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        if (head.next != node) {
            remove(node);
            insert(node);
        }
        return node.val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        else if (size == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        map.put(node.key, node);
        size++;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
        size--;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.set(1, 2);
        cache.set(2, 3);
        cache.set(3, 4);
        cache.set(4, 5);
        System.out.println(cache.get(5) + ",-1");
        System.out.println(cache.get(4) + ",5");
        System.out.println(cache.get(3) + ",4");
        System.out.println(cache.get(2) + ",3");
        System.out.println(cache.get(1) + ",2");
        cache.set(5, 6);
        System.out.println(cache.get(5) + ",6");
        System.out.println(cache.get(4) + ",-1");
        System.out.println(cache.get(3) + ",4");
        System.out.println(cache.get(2) + ",3");
        System.out.println(cache.get(1) + ",2");
    }
}
