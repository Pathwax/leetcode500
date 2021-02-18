package meituan;

import java.util.Arrays;

public class MT56_prod {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置>结果数组中最后区间的终止位置
            // 则不合并，直接将当前区间加入结果数组
            if (index == -1 || interval[0] > res[index][1])
                res[++index] = interval;
            else
                res[index][1] = Math.max(res[index][1],interval[1]);
        }
        return Arrays.copyOf(res,index+1);
    }
}
