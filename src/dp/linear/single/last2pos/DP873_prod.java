package dp.linear.single.last2pos;

import java.util.HashMap;
import java.util.Map;

public class DP873_prod {
    public int lenLongestFibSubseq(int[] arr) {
        int N = arr.length;
        int[][] dp = new int[N-1][N];
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int diff = arr[j]-arr[i];
                if (map.containsKey(diff)&&map.get(diff)<i){
                    int k = map.get(diff);
                    dp[i][j] = dp[k][i] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]+2);
                }
            }
            map.put(arr[i],i);
        }
        return maxLen;
    }
}
