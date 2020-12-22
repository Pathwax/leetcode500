package dp.linear.single.maxsubarray;

public class DP363_dev {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] b = new int[N];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                b[j] = 0;
            }
            for (int i1 = i; i1 < M; i1++) {
                for (int j = 0; j < N; j++) {
                    b[j] += matrix[i1][j];
                }

                for (int j = 0; j < N; j++) {
                    int temp = 0;
                    for (int j1 = j; j1 < N; j1++) {
                        temp += b[j1];
                        if (temp==k)
                            return k;
                        else if (temp>res&&temp<k)
                            res = temp;
                    }
                }
            }
        }
        return res;
    }
}
