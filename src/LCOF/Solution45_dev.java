package LCOF;

import java.util.Arrays;

public class Solution45_dev {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings,(o1, o2)-> (o1+o2).compareTo(o2+o1));
        StringBuilder ans = new StringBuilder();
        for(String str : strings){
            ans.append(str);
        }
        return ans.toString();
    }
}
