package dp.knapsack.conbination;

import java.util.*;

/**
 * 去重剪枝发生在：同一层数值相同的结点第 2、3 ... 个结点，因为数值相同的第 1 个结点已经搜索出了包含了这个数值的全部结果
 */
public class DP40_prod {
    List<List<Integer>> res;
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,target,new LinkedList<>());
        return res;
    }

    private void dfs(int index, int target, Deque<Integer> path){
        if(target==0){
            res.add(new ArrayList(path));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }

            // 在一个for循环中，所有被遍历到的数都是属于一个层级的。
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.push(candidates[i]);
            dfs(i+1,target-candidates[i],path);
            path.pop();
        }
    }
}
