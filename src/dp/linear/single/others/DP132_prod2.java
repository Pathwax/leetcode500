package dp.linear.single.others;

public class DP132_prod2 {
    public int minCut(String s){
        int n = s.length();
        int[] min_s = new int[n];
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            min_s[j] = j;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1])){
                    dp[i][j] = true;
                    min_s[j] = i==0?0:Math.min(min_s[j],min_s[i-1]+1);
                }
            }
        }
        return min_s[n-1];
    }
}
