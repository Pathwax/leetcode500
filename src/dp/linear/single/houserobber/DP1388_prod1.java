package dp.linear.single.houserobber;

public class DP1388_prod1 {
    public int maxSizeSlices(int[] slices) {
        int[] slices1 = new int[slices.length-1];
        int[] slices2 = new int[slices.length-1];
        System.arraycopy(slices,0,slices1,0,slices.length-1);
        System.arraycopy(slices,1,slices2,0,slices.length-1);
        return Math.max(helper(slices1),helper(slices2));
    }
    private int helper(int[] slices){
        int chooseNum = (slices.length+1)/3;
        int[][] dp = new int[slices.length+1][chooseNum+1];
        for (int i = 1; i <= slices.length; i++) {
            for (int j = 1; j <= chooseNum; j++) {
                dp[i][j] = Math.max(dp[i-1][j],(i<2?0:dp[i-2][j-1])+slices[i-1]);
            }
        }
        return dp[slices.length][chooseNum];
    }
}
