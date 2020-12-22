package dp.linear.single.maxsubarray;

public class DP1074_dev {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] b = new int[N];
        int count = 0;
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
                    for (int k = j; k < N; k++) {
                        temp += b[k];
                        if (temp == target)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
