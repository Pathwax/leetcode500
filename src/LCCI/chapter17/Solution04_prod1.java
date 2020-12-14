package LCCI.chapter17;

public class Solution04_prod1 {
    public int missingNumber(int[] nums) {
        int high = 0, low = 0;
        for (int i = 0; i < nums.length; i++) {
            high+=i;
            low+=nums[i];
        }
        high+=nums.length;
        return high-low;
    }
}
