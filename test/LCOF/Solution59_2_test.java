package LCOF;

public class Solution59_2_test {
    public static void main(String[] args) {
        Solution59_2_dev dev = new Solution59_2_dev();
        dev.max_value();
        dev.pop_front();
        dev.max_value();
        dev.push_back(46);
        dev.max_value();
        dev.pop_front();
        dev.max_value();
        dev.pop_front();
        dev.push_back(868);
        dev.pop_front();
        dev.pop_front();
        dev.pop_front();
        dev.push_back(525);
        dev.pop_front();
        System.out.println(dev.max_value());
    }
}
