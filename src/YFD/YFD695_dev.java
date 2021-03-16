package YFD;

public class YFD695_dev {
    int maxArea;
    int tempArea;
    boolean[][] tag;
    public int maxAreaOfIsland(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        this.tag = new boolean[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 1 && !tag[i][j]){
                    this.tempArea = 0;
                    dfs(grid , i , j);
                    if(tempArea > maxArea) maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || tag[i][j]){
            return;
        }
        tag[i][j]=true;
        tempArea++;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
