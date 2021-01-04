package dp.linear.single.others;

public class DP583_prod1 {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()+1][word2.length()+1];
        return word1.length() + word2.length() - 2 * lcs(word1, word2, word1.length(), word2.length(),memo);
    }

    public int lcs(String s1, String s2, int m, int n, int[][] memo){
        if (m == 0 || n == 0) return 0;
        if (memo[m][n]>0) return memo[m][n];
        if (s1.charAt(m-1) == s2.charAt(n-1))
            memo[m][n] = lcs(s1, s2, m - 1, n - 1, memo) + 1;
        else
            memo[m][n] = Math.max(lcs(s1, s2, m - 1, n, memo), lcs(s1, s2, m, n - 1, memo));
        return memo[m][n];
    }

}
