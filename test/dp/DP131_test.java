package dp;

public class DP131_test {
    public static void main(String[] args) {
        boolean[][] dp = new boolean[5][5];
        String s = "abbab";
        int len = 5;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len; i++) {
                if (s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1]))
                    dp[i][j] = true;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
