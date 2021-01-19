package dp.linear.single.withdimension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DP403_prod1 {
    public boolean canCross(int[] stones) {
        // key 表示当前石头的位置，value 是一个包含 step 的集合，
        // 其中每个 step 代表可以通过大小为 step 的一跳到达当前位置
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i],new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for(int k:map.get(stones[i])){
                for (int step = k+1; step >= k-1; step--) {
                    if (step>0&&map.containsKey(stones[i]+step))
                        map.get(stones[i] + step).add(step);
                }
            }
        }
        return map.get(stones[stones.length-1]).size()>0;
    }
}
