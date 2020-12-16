package dp.linear.single.LIS;

public class DP300_prod2 {
    public int lengthOfLIS(int[] nums) {
        // tails[i]表示长度为i+1的所有上升子序列的结尾的最小值
        // 数组tails也是一个严格上升的数组
        // 有序数组tail的长度，就是所求的最长上升子序列的长度
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums){
            int i = 0, j = res;
            while(i<j){
                int middle = (i+j)/2;
                if (tails[middle]<num)
                    i = middle+1;
                else
                    j = middle;
            }
            tails[i] = num;
            if (res==j) res++;
        }
        return res;
    }
}
