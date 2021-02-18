package meituan;

import java.util.List;

public class MT15_test {
    public static void main(String[] args) {
        MT15_dev dev = new MT15_dev();
        List<List<Integer>> lists = dev.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
