package meituan;

import java.util.Arrays;

// 排序法或者利用hashmap
public class MT169_dev {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
