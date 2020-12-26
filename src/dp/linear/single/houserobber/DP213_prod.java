package dp.linear.single.houserobber;

import java.util.Arrays;

public class DP213_prod {
    public int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        DP198_prod prod = new DP198_prod();
        return Math.max(prod.rob(Arrays.copyOfRange(nums,0,nums.length-1)),
                prod.rob(Arrays.copyOfRange(nums,1,nums.length)));
    }
}
