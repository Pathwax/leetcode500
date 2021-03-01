package YFD;

public class YFD375_prod2 {
    public int getMoneyAmount(int n){
        return doit(1,n,new int[n+1][n+1]);
    }
    private int doit(int start, int end, int[][] dp){
        if (start>=end) return 0;
        if (start + 1 == end) return start;
        if (dp[start][end]!=0) return dp[start][end];
        int res = 0x7FFFFFFF;
        for (int i = end - 1; i >= (start+end)>>>1 ; i-=2) {
            res = Math.min(res,i+Math.max(doit(start,i-1,dp),doit(i+1,end,dp)));
        }
        dp[start][end] = res;
        return dp[start][end];
    }
}
