package LCCI.chapter16;

import java.util.HashSet;
import java.util.Set;

public class Solution21_prod {
    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        int diff = 0;
        for (int i : array1) {
            diff += i;
        }
        for (int i : array2) {
            set.add(i);
            diff -= i;
        }
        if (diff%2!=0)
            return new int[0];
        for (int i : array1) {
            if (set.contains(i-diff/2))
                return new int[]{i,i-diff/2};
        }
        return new int[0];
    }


}
