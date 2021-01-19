package dp.linear.single.withdimension;

import java.util.HashMap;
import java.util.Map;

public class DP256_prod1 {
    private int[][] costs;
    private Map<String, Integer> memo;
    public int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
        this.costs = costs;
        this.memo = new HashMap<>();
        return Math.min(printCost(0,0),Math.min(printCost(0,1),printCost(0,2)));
    }
    private int printCost(int n, int color){
        if (memo.containsKey(getKey(n,color)))
            return memo.get(getKey(n,color));
        int totalCost = costs[n][color];
        if (n==costs.length-1){

        }else if (color==0){// red
            totalCost += Math.min(printCost(n+1, 1),printCost(n+1,2));
        }else if (color==1){// green
            totalCost += Math.min(printCost(n+1,0),printCost(n+1,2));
        }else{// blue
            totalCost +=Math.min(printCost(n+1,0),printCost(n+1,1));
        }
        memo.put(getKey(n,color),totalCost);
        return totalCost;
    }
    private String getKey(int n, int color){
        return String.valueOf(n)+String.valueOf(color);
    }
}
