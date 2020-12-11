package LCCI.chapter16;

public class LRUCache_test {
    public static void main(String[] args) {
        // LRUCache_dev lruCacheDev = new LRUCache_dev(2);
        // lruCacheDev.put(2,1);
        // lruCacheDev.put(1,1);
        // lruCacheDev.put(2,3);
        // lruCacheDev.put(4,1);
        // lruCacheDev.get(1);
        // lruCacheDev.get(2);
        LRUCache_prod2 cache = new LRUCache_prod2(2);
        // System.out.println(cache.head.key+" "+cache.head.value+" "+cache.tail.key+" "+cache.tail.value);
    }

}
