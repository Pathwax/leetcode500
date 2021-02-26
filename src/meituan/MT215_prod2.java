package meituan;

public class MT215_prod2 {
    public int findKthLargest(int[] nums, int k) {
        int res = quick_sort(nums, 0, nums.length - 1, k);
        return res;
    }

    public int quick_sort(int[] nums, int l, int r, int k) {
        if (l >= r) {
            return nums[l];
        }
        int i = l - 1, j = r + 1, x = nums[l + r >> 1];
        while (i < j) {
            while (nums[++i] > x);
            while (nums[--j] < x);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        if (k <= j - l + 1) {
            return quick_sort(nums, l, j, k);
        } else {
            return quick_sort(nums, j + 1, r, k - j + l - 1);
        }
    }
}
