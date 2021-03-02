package LCOF;

import java.util.Arrays;

/**
 * 树状数组是一种可以动态维护序列前缀和的数据结构
 * 支持 单点更新、区间查询 代价均为O(log n)
 * 桶若太大内存不一定装得下，需要离散化树状数组
 * 离散化一个序列的前提是我们只关心这个序列里面元素的相对大小，而不关心绝对大小
 */
public class Solution51_prod2 {
    public int reversePairs(int[] nums) {
        int N = nums.length;
        int[] tmp = new int[N];
        System.arraycopy(nums,0,tmp,0,N);
        // 离散化
        Arrays.sort(tmp);
        for (int i = 0; i < N; i++) {
            nums[i] = Arrays.binarySearch(tmp,nums[i]) + 1;
        }
        // 树状数组统计逆序对
        BIT bit = new BIT(N);
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            res += bit.query(nums[i] - 1);
            bit.update(nums[i]);
        }
        return res;
    }

}

class BIT {
    private int[] tree;
    private int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n+1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public int query(int x){
        int ret = 0;
        while (x != 0) {
            ret += tree[x];
            x -= lowbit(x);
        }
        return ret;
    }

    public void update(int x){
        while(x <= n){
            ++tree[x];
            x += lowbit(x);
        }
    }
}
