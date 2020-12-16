package dp.linear.single.LIS;

import java.util.Arrays;

public class DP673_dev {
    public int findNumberOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        for(int num:nums){
            int i = 0, j = res;
            while(i<j){
                int middle = (i+j)/2;
                if (tails[middle]<num)
                    i = middle+1;
                else
                    j = middle;
            }
            tails[i] = num;
            if (j==res) {
                res++;
            }else{
                result[i]++;
            }
        }
        return result[nums.length-1];
    }
}
