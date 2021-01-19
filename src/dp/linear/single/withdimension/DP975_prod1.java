package dp.linear.single.withdimension;

import java.util.TreeMap;

public class DP975_prod1 {
    public int oddEvenJumps(int[] A) {
        int N = A.length;
        if (N<=1) return N;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N-1] = even[N-1] = true;

        TreeMap<Integer,Integer> vals = new TreeMap<>();
        vals.put(A[N-1],N-1);
        for (int i = N-2; i >=0 ; i--) {
            int v = A[i];
            if (vals.containsKey(v)) {
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            } else {
                Integer lowerKey = vals.lowerKey(v);
                Integer higherKey = vals.higherKey(v);

                if (lowerKey!=null)
                    even[i] = odd[vals.get(lowerKey)];
                if (higherKey!=null)
                    odd[i] = even[vals.get(higherKey)];
            }
            vals.put(v,i);
        }
        int res = 0;
        for (boolean b : odd) {
            if (b) res++;
        }
        return res;
    }
}
