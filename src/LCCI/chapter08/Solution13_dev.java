package LCCI.chapter08;

import java.util.Arrays;

public class Solution13_dev {
    public int pileBox(int[][] box) {
        Arrays.sort(box,(a, b)->a[0]-b[0]);
        int[] dp = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
        }
        int res = 0;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[j][0]<box[i][0]&&box[j][1]<box[i][1]&&box[j][2]<box[i][2])
                    dp[i] = Math.max(dp[i],dp[j]+box[i][2]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
