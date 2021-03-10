package hot100;

// 正则表达式匹配
public class Hot10_prod1 {
    public boolean isMatch(String s, String p) {
        int M = s.length();
        int N = p.length();
        boolean[][] dp = new boolean[M+1][N+1];
        // base case
        dp[0][0] = true;
        for(int j = 1; j < N+1; j++){
            if(p.charAt(j-1)=='*')
                dp[0][j] = dp[0][j-2];
        }
        // 迭代
        for(int i = 1; i < M+1; i++){
            for(int j = 1; j < N + 1; j++){
                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.')
                        dp[i][j] = dp[i-1][j] || dp[i][j-2] || dp[i-1][j-2];
                    else
                        dp[i][j] = dp[i][j-2];
                }
            }
        }
        return dp[M][N];
    }
}
