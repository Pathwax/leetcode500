package LCOF;

import java.util.Arrays;

public class Solution51_prod3 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        return merge(nums, copy, 0, nums.length - 1);
        // 左闭右闭
    }

    public int merge(int[] nums, int[] copy, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) >>> 1;
        int count = 0;
        count += merge(copy, nums, start, mid);
        count += merge(copy, nums, mid + 1, end);
        int i = mid, j = end, index = end;
        while (i >= start && j >= mid + 1) {
            if (copy[i] > copy[j]) { // 逆序对
                nums[index--] = copy[i--];
                count += j - mid;
            } else {
                nums[index--] = copy[j--];
            }
        }
        while (i >= start) nums[index--] = copy[i--];
        while (j >= mid + 1) nums[index--] = copy[j--];
        return count;
    }
}
