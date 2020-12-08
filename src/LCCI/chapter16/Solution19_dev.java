package LCCI.chapter16;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution19_dev {
    boolean[][] tag;
    int sum;
    public int[] pondSizes(int[][] land) {
        this.tag = new boolean[land.length][land[0].length];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j]==0&&!tag[i][j]){
                    int sumTemp = this.sum;
                    dfs(land,i,j);
                    int count = this.sum-sumTemp;
                    result.add(count);
                }
            }
        }
        int[] res = result.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(res);
        return res;
    }
    private void dfs(int[][] land,int i, int j){
        if (i<0||i>= land.length||j<0||j>=land[0].length)
            return;
        if(land[i][j]==0&&!tag[i][j]){
            tag[i][j] = true;
            sum++;
            dfs(land,i+1,j);
            dfs(land,i-1,j);
            dfs(land,i,j+1);
            dfs(land,i,j-1);
            dfs(land,i+1,j-1);
            dfs(land,i-1,j+1);
            dfs(land,i+1,j+1);
            dfs(land,i-1,j-1);
        }
    }
}
