package dp.linear.single.maxsubarray;

public class DP918_prod {
    public int maxSubarraySumCircular(int[] A){
        if (A.length==0) return 0;
        if (A.length==1) return A[0];
        int temp1 = 0;
        int res1 = A[0];
        int sum = 0;
        for(int num:A){
            sum+=num;
            temp1 = temp1>0?temp1+num:num;
            res1 = Math.max(res1,temp1);
        }
        int temp2 = 0;
        int res2 = A[1];
        for (int i = 1; i < A.length-1; i++) {
            temp2 = temp2<0?temp2+A[i]:A[i];
            res2 = Math.min(res2,temp2);
        }
        return Math.max(res1,sum-res2);
    }
}
