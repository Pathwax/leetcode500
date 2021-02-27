package YFD;

import java.util.Arrays;

public class YFD253_prod {
    public int minMeetingRooms(int[][] intervals) {
        Integer[] helper = new Integer[intervals.length * intervals[0].length];
        int cur = 0, res = 0, i = 0;
        for (int[] interval : intervals) {
            helper[i++] = interval[0];
            helper[i++] = -interval[1];
        }
        Arrays.sort(helper, (o1,o2)->Math.abs(o1)==Math.abs(o2)?o1-o2:Math.abs(o1)-Math.abs(o2));
        for (int time : helper) {
            if (time>=0) cur++;
            else cur--;
            res = Math.max(res,cur);
        }
        return res;
    }
}
