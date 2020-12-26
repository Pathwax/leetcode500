package dp.linear.single.houserobber;

import java.util.Arrays;

public class DP740_prod {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int[] helper = new int[nums[nums.length-1]+1];
        for(int num:nums){
            helper[num]++;
        }
        int first = 0, second = 0, temp;
        for(int i = 1; i<helper.length; i++){
            temp = second;
            second = Math.max(second,first+helper[i]*i);
            first = temp;
        }
        return second;
    }
}
