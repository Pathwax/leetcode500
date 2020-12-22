package LCCI.chapter17;

public class Solution24_prod {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] res = new int[4];
        int M = matrix.length;
        int N = matrix[0].length;
        int[] b = new int[N];
        int temp;
        int max = matrix[0][0];
        int beginX = 0;
        int beginY = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                b[j] = 0;
            }
            for (int i1 = i; i1 < M; i1++) {
                temp = 0;
                for (int j = 0; j < N; j++) {
                    b[j] += matrix[i1][j];
                    if (temp>0)
                        temp+=b[j];
                    else{
                        temp = b[j];
                        beginX = i;
                        beginY = j;
                    }
                    if (temp>max){
                        max = temp;
                        res[0] = beginX;
                        res[1] = beginY;
                        res[2] = i1;
                        res[3] = j;
                    }
                }
            }
        }
        return res;
    }
}
