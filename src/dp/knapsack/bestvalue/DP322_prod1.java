package dp.knapsack.bestvalue;

import java.util.Arrays;

// 贪心+dfs
public class DP322_prod1 {

    private int minCount;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        this.minCount = Integer.MAX_VALUE;
        Arrays.sort(coins);
        this.coins = coins;
        dfs(coins.length-1,amount,0);
        return minCount == Integer.MAX_VALUE?-1:minCount;
    }

    private void dfs(int index, int amount, int count){
        if (amount==0){
            minCount = Math.min(minCount, count);
            return;
        }
        if (index<0) return;
        for (int k = amount/coins[index]; k >=0 && k+count<minCount ; k--) {
            dfs(index-1,amount-k*coins[index],count+k);
        }
    }

}
