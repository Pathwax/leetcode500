package dp.knapsack.bestvalue;

import java.util.Arrays;

public class DP1046_prod {
    public int lastStoneWeight(int[] stones) {
        int index = stones.length - 1;
        for (int i = 0; i < stones.length - 1; i++){     //最多比较length-1次
            Arrays.sort(stones);
            if (stones[index - 1] == 0) break;           //说明最多只剩一块石头
            stones[index] -= stones[index - 1];          //两种不同情况使用同一表达式处理
            stones[index - 1] = 0;                       //每次比较后肯定会有一块石头被destroyed
        }
        return stones[index];
    }
}
