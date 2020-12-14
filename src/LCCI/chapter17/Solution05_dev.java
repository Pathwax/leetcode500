package LCCI.chapter17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution05_dev {
    public String[] findLongestSubarray(String[] array) {
        // key: 前缀和，value: 第一次出现该前缀和的索引。
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefixSum = 0;
        int left = 0;
        int longest = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i].charAt(0);
            prefixSum += Character.isDigit(c)?-1:1;
            if (!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }else{
                // i-map.get(prefixSum) == i-left+1
                if (i-map.get(prefixSum)>longest){
                    longest = i-map.get(prefixSum);
                    left = map.get(prefixSum)+1;
                }
            }
        }
        if (longest==0) return new String[0];
        return Arrays.copyOfRange(array,left,left+longest);
    }
}
