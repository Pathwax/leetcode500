package douyu;

import java.util.Arrays;

public class DY179_dev {
    public String largestNumber(int[] nums) {
        int N = nums.length;
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array,(o1,o2)->(o2+o1).compareTo(o1+o2));
        StringBuilder res = new StringBuilder();
        int index = 0;
        int n = array.length;
        while(index < n && array[index].equals("0"))
            index++;
        if (index==n) return "0";
        for (int i = index; i < n; i++) {
            res.append(array[i]);
        }
        return res.toString();
    }
}
