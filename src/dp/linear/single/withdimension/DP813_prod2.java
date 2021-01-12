package dp.linear.single.withdimension;

import java.util.Arrays;

public class DP813_prod2 {
    double[][] memo;
    public double largestSumOfAverages(int[] A, int K) {
        this.memo = new double[A.length][K];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return recursion(A ,0, K-1);
    }

    public double recursion(int[] A, int start, int k){
        if (memo[start][k] != Integer.MIN_VALUE)
            return memo[start][k];
        if (k==0){
            double sum = 0;
            for (int i = start; i < A.length; i++) {
                sum+=A[i];
            }
            memo[start][k] = sum/(A.length-start);
            return memo[start][k];
        }
        double sum = 0, avg;
        double innerMax = 0;
        for (int i = start; i < A.length-k; i++) {
            sum+=A[i];
            avg = sum/(i-start+1);
            innerMax = Math.max(innerMax,avg+recursion(A,i+1,k-1));
        }
        memo[start][k] = innerMax;
        return memo[start][k];
    }
}
