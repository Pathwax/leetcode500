package dp.linear.single.houserobber;

import java.util.TreeMap;

public class DP740_dev {

    public int deleteAndEarn(int[] nums) {
        if (nums.length==0) return 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int key0;
        int key1 = map.firstKey();
        int first = 0;
        int second = map.get(key1)*key1;
        int temp, money;
        while(map.higherKey(key1)!=null){
            key0 = key1;
            key1 = map.higherKey(key1);
            temp = second;
            money = map.get(key1)*key1;
            second = key1-key0==1?Math.max(second,first+money):second+money;
            first = temp;
        }
        return second;
    }
}
