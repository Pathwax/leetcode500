package meituan;

// 接雨水
public class MT42_prod1 {
    public int trap(int[] height) {
        int sum = 0;
        // 最两端的两列不用考虑，因为一定不会有水。所以下标从1到length-2
        for (int i = 1; i < height.length - 1; i++) {
            // 找出左边最高
            int max_left = 0;
            for (int j = i-1; j >= 0; j--) {
                if (height[j]>max_left)
                    max_left = height[j];
            }
            // 找出右边最高
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right)
                    max_right = height[j];
            }
            // 找出两端较小的
            int min = Math.min(max_left,max_right);
            if (min>height[i]){
                sum += (min-height[i]);
            }
        }
        return sum;
    }
}
