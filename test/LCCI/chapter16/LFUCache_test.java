package LCCI.chapter16;

public class LFUCache_test {
    public static void main(String[] args) {
        LFUCache_dev dev = new LFUCache_dev(2);
        dev.put(1,1);
        dev.put(2,2);
        dev.get(1);
        dev.put(3,3);
        dev.get(2);
        dev.get(3);
        dev.put(4,4);
        dev.get(1);
        dev.get(3);
        dev.get(4);
    }

}
