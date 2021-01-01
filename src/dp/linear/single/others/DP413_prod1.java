package dp.linear.single.others;

public class DP413_prod1 {
    // 子数组和子序列有显著区别
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
