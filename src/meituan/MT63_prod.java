package meituan;

public class MT63_prod {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int start = 0;
        while(start<m && obstacleGrid[start][0]==0){
            dp[start++][0] = 1;
        }
        start = 0;
        while(start<n && obstacleGrid[0][start]==0){
            dp[0][start++] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
