package dp;

import java.util.Arrays;

public class DP887_test1 {
    int[][] memo;
    public int superEggDrop(int K, int N) {
        if (K==1&&N==0) return 0;
        this.memo = new int[K+1][N+1];
        for (int i = 0; i < K + 1; i++) {
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        int res = recursion(K, N);
        return res;
    }
    private int recursion(int K, int N){
        if (N==0)
            return 0;
        if (K==1)
            return N;
        if (memo[K][N]!=Integer.MAX_VALUE)
            return memo[K][N];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N + 1; i++) {
            res = Math.min(res,Math.max(recursion(K-1,i-1),recursion(K,N-i))+1);
        }
        memo[K][N] = res;
        return res;
    }
    public static void main(String[] args) {
        DP887_test1 test = new DP887_test1();
        test.superEggDrop(2,6);
    }
}
