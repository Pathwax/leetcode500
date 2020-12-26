package dp.linear.single.houserobber;

public class DP198_prod {
    public int rob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre+num,cur);
            pre = tmp;
        }
        return cur;
    }
}
