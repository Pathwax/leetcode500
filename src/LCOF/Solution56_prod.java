package LCOF;

public class Solution56_prod {
    public int singleNumber(int[] nums) {
// 哈希表 13 ms	39.7 MB
/*        int[] res = new int[2];
        int index = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, !map.containsKey(n));
        }
        for(Map.Entry<Integer, Boolean> d : map.entrySet()) {
            if(d.getValue()) return d.getKey();
        }
        return 0;*/

// 位运算 5 ms	39.3 MB
/*        int[] count = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                count[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            // 只需要修改m=3，就可解决所有某个数字出现一次，其余都出现m次的问题。
            res |= count[i] % 3;
        }
        return res;*/

// 有限状态机
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
