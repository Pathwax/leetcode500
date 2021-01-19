package dp.linear.single.withdimension;

import java.util.Arrays;

public class DP403_prod2 {
    // Binary Search
    public boolean canCross(int[] stones) {
        for (int i = 1; i < stones.length; i++) {
            if (stones[i] - stones[i - 1] > i) return false;
        }

        return dfs(stones, 1, 1);
    }

    private boolean dfs(int[] stones, int start, int k) {
        if (start == stones.length - 1)
            return true;

        for (int step = k + 1; step >= k - 1; step--) {
            if (step < 1) continue;
            int index = Arrays.binarySearch(stones, stones[start] + step);
            if (index < 0) continue;
            if (dfs(stones, index, step)) return true;
        }
        return false;
    }
}
