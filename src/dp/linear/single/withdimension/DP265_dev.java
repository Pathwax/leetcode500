package dp.linear.single.withdimension;

public class DP265_dev {
    public int minCostII(int[][] costs) {
        if (costs.length==0) return 0;
        for (int i = costs.length-2; i >=0 ; i--) {
            int firstMinIndex, secondMinIndex;
            if (costs[i+1][0] < costs[i+1][1]) {
                firstMinIndex = 0;
                secondMinIndex = 1;
            }else{
                firstMinIndex = 1;
                secondMinIndex = 0;
            }
            for (int j = 2; j < costs[0].length; j++) {
                if (costs[i+1][j] < costs[i+1][firstMinIndex]){
                    secondMinIndex = firstMinIndex;
                    firstMinIndex = j;
                }else if (costs[i+1][j] < costs[i+1][secondMinIndex]){
                    secondMinIndex = j;
                }
            }
            for (int j = 0; j < costs[0].length; j++) {
                costs[i][j] += j==firstMinIndex?costs[i+1][secondMinIndex]:costs[i+1][firstMinIndex];
            }
        }
        int res = costs[0][0];
        for (int i = 1; i < costs[0].length; i++) {
            res = Math.min(res,costs[0][i]);
        }
        return res;
    }
}
