package meituan;

import java.util.*;

// 回溯法 超时
public class MT15_dev {
    List<List<Integer>> res;
    int[] nums;
    boolean[] used;
    public List<List<Integer>> threeSum(int[] nums) {
        this.res = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        dfs(0,0,0,new LinkedList<>());
        return res;
    }

    private void dfs(int index,int count, int target, Deque<Integer> path){
        if(count == 3 && target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(count==3) return;
        for(int i = index; i < nums.length; i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            path.push(nums[i]);
            used[i] = true;
            dfs(i+1,count+1,target-nums[i],path);
            used[i] = false;
            path.pop();
        }
    }
}
