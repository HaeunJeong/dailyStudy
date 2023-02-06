import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /*public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }*/

    static class LRUCache {
        Map<Integer, Integer> cache = new HashMap<>();
        Stack<Integer> used = new Stack<>();
        int capacity;

        public LRUCache(int capacity) {
            cache = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            used.push(key);
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {

            if(cache.size()==capacity) {
                cache.remove(used.pop());
            }
            cache.put(key, value);
        }
    }

}
