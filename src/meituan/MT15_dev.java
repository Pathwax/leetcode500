package meituan;

import java.util.*;

// 回溯法+优化 超时
public class MT15_dev {
    List<List<Integer>> res;
    int[] nums;
    boolean changed = false;
    public List<List<Integer>> threeSum(int[] nums) {
        this.res = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0,0,0,new LinkedList<>());
        return res;
    }

    private void dfs(int index,int count, int target, Deque<Integer> path){
        if(count == 3 && target == 0){
            this.changed = true;
            res.add(new ArrayList<>(path));
            return;
        }
        if(count==3) return;
        for(int i = index; i < nums.length; i++){
            if(count==0 && nums[i]>0) break;
            if(count==2 && nums[i]<0) continue;
            if(count==2 && this.changed == true) break;
            if(i>index&&nums[i]==nums[i-1]) continue;
            path.push(nums[i]);
            dfs(i+1,count+1,target-nums[i],path);
            path.pop();
        }
        this.changed = false;
    }
}
