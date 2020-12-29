package dp.linear.single.last2pos;

import java.util.HashMap;
import java.util.Map;

// 与斐波那契数列解法的区别在于，有重复元素，只能一边遍历一边给hash字典添加。
public class DP1027_dev {
    public int longestArithSeqLength(int[] A) {
        int N = A.length;
        int[][] dp = new int[N-1][N];
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 2;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int diff = A[j] - A[i];
                if (map.containsKey(A[i]-diff)){
                    int k = map.get(A[i]-diff);
                    dp[i][j] = dp[k][i] + 1;
                    maxLen = Math.max(maxLen,dp[i][j]+2);
                }
            }
            map.put(A[i],i);
        }
        return maxLen;
    }
}
