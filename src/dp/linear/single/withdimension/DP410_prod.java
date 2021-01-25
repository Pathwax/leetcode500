package dp.linear.single.withdimension;

public class DP410_prod {
    /**
     * 先猜一个mid值，然后遍历数组划分，使每个子数组和都最接近mid（贪心地逼近mid），这样我得到的子数组数一定最少;
     * 如果即使这样子数组数量仍旧多于m个，那么明显说明我mid猜小了，因此 lo = mid + 1;
     * 而如果得到的子数组数量小于等于m个，那么我可能会想，mid是不是有可能更小？值得一试。因此 hi = mid;
     */
    public int splitArray(int[] nums, int m) {
        int l = nums[0], h = 0;
        for (int num : nums) {
            h+=num;
            l = Math.max(l,num);
        }
        while(l<h){
            int mid = l+(h-l)/2;
            int temp = 0;
            int count = 1;
            for (int num : nums) {
                temp += num;
                if (temp>mid){
                    temp = num;
                    ++count;
                }
            }
            if (count>m) l = mid+1;
            else h = mid;
        }
        return l;
    }
}
