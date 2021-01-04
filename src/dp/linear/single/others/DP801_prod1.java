package dp.linear.single.others;

import java.util.Arrays;

public class DP801_prod1 {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        // 不交换i的情况
        int[] keep = new int[n];
        // 交换i的情况
        int[] swap = new int[n];
        Arrays.fill(keep,n);
        Arrays.fill(swap,n);
        // 初始条件，第0个位置不交换，次数为0，第0个位置交换，次数为1。
        keep[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < n; i++) {
            /**
             * 如果满足两种情况
             * i交换的情况下，可以有i-1不交换和i-1交换，选择最优情况
             * i不交换的情况下，可以有i-1交换和i-1不交换，选择最优情况
             */
            if((A[i]>A[i-1]&&B[i]>B[i-1])&&(A[i]>B[i-1]&&B[i]>A[i-1])){
                // i 不交换
                keep[i] = Math.min(keep[i-1],swap[i-1]);
                // i 交换
                swap[i] = Math.min(swap[i-1],keep[i-1])+1;
                continue;
            }
            /**
             * 只满足第一种情况
             */
            if (A[i]>A[i-1]&&B[i]>B[i-1]){
                // i 不交换
                keep[i] = keep[i-1];
                // i 交换，意味着i-1也交换
                swap[i] = swap[i-1]+1;
            }

            if (A[i]>B[i-1]&&B[i]>A[i-1]){
                // i 不交换，那么就是交换i-1
                keep[i] = swap[i-1];
                // i 交换，那么就是i-1不交换
                swap[i] = keep[i-1]+1;
            }
        }
        return Math.min(keep[n-1],swap[n-1]);
    }
}
