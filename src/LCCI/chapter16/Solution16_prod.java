package LCCI.chapter16;

public class Solution16_prod {
    public int[] subSort(int[] array) {
        if (array == null || array.length <= 2)
            return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < max)
                last = i;
            else
                max = Math.max(max, array[i]);
            if (array[len - 1 - i] > min)
                first = len - 1 - i;
            else
                min = Math.min(min, array[len - 1 - i]);
        }
        return new int[]{first, last};
    }
}
