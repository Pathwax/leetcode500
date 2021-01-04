package dp.linear.single.others;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DP871_prod1 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stations.length,(o1, o2) -> o2 - o1);
        int maxDistance = startFuel;
        int currentDistance = 0;
        int res = 0;
        for (int[] station : stations) {
            currentDistance += station[0];
            if (currentDistance > maxDistance) {
                while (currentDistance > maxDistance && !queue.isEmpty()) {
                    maxDistance += queue.remove();
                    res++;
                }
                if (currentDistance > maxDistance)
                    return -1;
            }
            queue.offer(station[1]);
        }
        if (maxDistance<target){
            while(target>maxDistance&&!queue.isEmpty()){
                maxDistance += queue.remove();
                res++;
            }
            if (target>maxDistance)
                return -1;
        }
        return res;
    }
}