package dp.linear.matrix.other;

// 深度优先遍历 超时，考虑记录重复解
public class DP62_dev {
    int res;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dfs(0,0);
        return res;
    }
    private void dfs(int row, int col){
        if(row>=m||col>=n) return;
        if(row == m-1 && col == n-1){
            res++;
            return;
        }
        dfs(row+1,col);
        dfs(row,col+1);
    }
}
