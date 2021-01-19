package dp.linear.single.withdimension;

import java.util.Arrays;

public class DP975_prod2 {
    public int oddEvenJumps(int[] A) {
        int N = A.length;
        if (N<=1) return N;
        boolean[][] dp = new boolean[N][2];
        dp[N-1][0] = true;
        dp[N-1][1] = true;
        int res = 1;
        int[] pos = new int[100001];
        Arrays.fill(pos,-1);
        int max = A[N-1], min = A[N-1];
        pos[A[N-1]] = N-1;
        for (int i = N-2; i >= 0; i++) {
            int val = A[i];
            if (pos[val]!=-1){
                dp[i][0] = dp[pos[val]][1];
                dp[i][1] = dp[pos[val]][0];
            }else if (val>max){
                dp[i][1] = dp[pos[max]][0];
                max = val;
            }else if (val<max){
                dp[i][0] = dp[pos[min]][1];
                min = val;
            }else{
                int tmp = val + 1;
                while(pos[tmp] == -1) {
                    tmp++;
                }
                dp[i][0] = dp[pos[tmp]][1];
                tmp = val - 1;
                while(pos[tmp] == -1) {
                    tmp--;
                }
                dp[i][1] = dp[pos[tmp]][0];
            }
            pos[val] = i;
            if (dp[i][0]) {
                res++;
            }
        }
        return res;
    }
}
