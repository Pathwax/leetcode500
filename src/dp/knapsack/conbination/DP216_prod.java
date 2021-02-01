package dp.knapsack.conbination;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DP216_prod {
    int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
    boolean[] used = new boolean[9];
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.res = new ArrayList<>();
        dfs(0,n,k,new LinkedList<>());
        return res;
    }
    private void dfs(int index, int target, int count, Deque<Integer> path){
        if (count==0&&target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < 9; i++) {
            if (candidates[i] > target || used[i]) break;
            path.push(candidates[i]);
            used[i] = true;
            dfs(index + 1, target-candidates[i],count-1,path);
            used[i] = false;
            path.pop();
        }
    }
}
