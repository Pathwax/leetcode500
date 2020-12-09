package LCCI.chapter16;

import java.util.*;

public class Solution24_dev {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int num:nums){
            map.merge(num,1,Integer::sum);
        }
        while(true){
            int before = res.size();
            map.forEach((k,v)->{
                if (map.containsKey(target-k)){
                    if (k!=target-k || v>=2){
                        if (v!=0&&map.get(target-k)!=0) {
                            map.put(k,v-1);
                            map.put(target-k,map.get(target-k)-1);
                            res.add(new ArrayList<Integer>() {{
                                add(k);
                                add(target-k);
                            }});
                        }
                    }
                }
            });
            int after = res.size();
            if (before==after)
                break;
        }
        return res;
    }
}
