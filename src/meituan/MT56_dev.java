package meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MT56_dev {
    public int[][] merge(int[][] intervals) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; ) {
            res.add(intervals[i][0]);
            int range = intervals[i][1];
            int j = i+1;
            for (; j < intervals.length; j++) {
                if (intervals[j][0] > range){
                    res.add(range);
                    break;
                }else{
                    if (intervals[j][1] <= range){
                        continue;
                    }else{
                        range = intervals[j][1];
                    }
                }
            }
            if (j==intervals.length){
                res.add(range);
                break;
            }else{
                i = j;
            }
        }
        int[][] result = new int[res.size()/2][2];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            result[i][0] = res.get(index++);
            result[i][1] = res.get(index++);
        }
        return result;
    }
}
