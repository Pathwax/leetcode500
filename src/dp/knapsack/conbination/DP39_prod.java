package dp.knapsack.conbination;

import java.util.*;

/**
 * 什么时候使用 used 数组，什么时候使用 begin 变量
 *
 * 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
 * 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
 */
public class DP39_prod {
    List<List<Integer>> res;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.candidates = candidates;
        dfs(0,target,new ArrayDeque<>());
        return res;
    }

    private void dfs(int index, int target, Deque<Integer> temp) {
        if (target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 遍历，index为本分支上一节点的减数的下标
        for (int i = index; i < candidates.length; i++) {
            //如果减数大于目标值，则差为负数，不符合结果
            if (candidates[i]<=target){
                temp.push(candidates[i]);
                dfs(i, target - candidates[i], temp);
                temp.pop();
            }
        }
    }
}
