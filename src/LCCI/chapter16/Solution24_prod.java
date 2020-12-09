package LCCI.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution24_prod {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while(i<j){
            int sum = nums[i] + nums[j];
            if (sum>target){
                j--;
            }else if (sum<target){
                i++;
            }else{
                res.add(Arrays.asList(nums[i],nums[j]));
                i++;
                j--;
            }
        }
        return res;
        // Map<Integer, Integer> map = new HashMap<>();
        //
        // List<List<Integer>> ans = new ArrayList<>();
        // for (int num : nums) {
        //     Integer count = map.get(target - num);
        //     if (count != null) {
        //         ans.add(Arrays.asList(num, target - num));
        //         if (count == 1)
        //             map.remove(target - num);
        //         else
        //             map.put(target - num, --count);
        //     } else
        //         map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        //
        // return ans;
    }
}
