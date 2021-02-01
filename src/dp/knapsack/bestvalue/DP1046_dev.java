package dp.knapsack.bestvalue;

import java.util.PriorityQueue;

public class DP1046_dev {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for(int stone: stones)
            pq.offer(stone);
        while(pq.size()>1){
            Integer p1 = pq.poll();
            Integer p2 = pq.poll();
            if (p1==p2)
                continue;
            else
                pq.offer(p1-p2);
        }
        if (pq.size()==1)
            return pq.poll();
        else return 0;
    }
}
