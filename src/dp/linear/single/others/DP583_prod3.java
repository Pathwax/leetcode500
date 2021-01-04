package dp.linear.single.others;

public class DP583_prod3 {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            int[] temp = new int[word2.length() + 1];
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) temp[j] = i + j;
                else {
                    temp[j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[j - 1] : Math.min(dp[j], temp[j - 1]) + 1;
                }
            }
            dp = temp;
        }
        return dp[word2.length()];
    }
}
