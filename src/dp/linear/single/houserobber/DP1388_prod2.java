package dp.linear.single.houserobber;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DP1388_prod2 {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[] linkL = new int[n];
        int[] linkR = new int[n];
        boolean[] valid = new boolean[n];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(n, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        Arrays.fill(valid, true);
        for (int i = 0; i < n; i++) {
            linkL[i] = i == 0 ? n - 1 : i - 1;
            linkR[i] = i == n - 1 ? 0 : i + 1;
            queue.offer(new int[]{slices[i], i});
        }
        int ans = 0;
        for (int i = 0; i < n / 3; i++) {
            while (!valid[queue.peek()[1]]) {
                queue.poll();
            }
            int pos = queue.poll()[1];
            ans += slices[pos];
            slices[pos] = slices[linkL[pos]] + slices[linkR[pos]] - slices[pos];
            queue.offer(new int[]{slices[pos], pos});
            valid[linkL[pos]] = false;
            valid[linkR[pos]] = false;
            linkL[linkR[linkR[pos]]] = pos;
            linkR[linkL[linkL[pos]]] = pos;
            linkL[pos] = linkL[linkL[pos]];
            linkR[pos] = linkR[linkR[pos]];
        }
        return ans;
    }
}
