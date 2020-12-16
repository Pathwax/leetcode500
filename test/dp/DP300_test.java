package dp;

import dp.linear.single.LIS.DP300_dev;

public class DP300_test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        DP300_dev dp = new DP300_dev();
        dp.lengthOfLIS(nums);
    }
}
