package meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MT15_prod {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i]>0) return res;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int L = i + 1, R = len-1;
            while(L<R){
                int temp = nums[i] + nums[L] + nums[R];
                if (temp == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[L], nums[R]);
                    res.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while(L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if (temp < 0) ++L;
                else --R;
            }
        }
        return res;
    }
}
