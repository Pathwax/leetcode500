package douyu;

public class DY200_dev {
    boolean[][] tag;
    int count;
    public int numIslands(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        this.tag = new boolean[M][N];
        this.count = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == '1' && !tag[i][j]){
                    dfs(grid , i , j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i == grid.length || j == grid[0].length || i < 0 || j < 0 || grid[i][j] == '0' || tag[i][j])
            return;
        tag[i][j] = true;
        dfs(grid,i - 1, j);
        dfs(grid,i + 1, j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
