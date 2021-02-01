package dp.knapsack.bestvalue;

/**
 * 为何要倒序访问背包空间？
 * 因为原状态方程中 dp[i][j][k]=max( dp[i-1][j][k],dp[i-1][j-num0][k-num1]+1 );
 * 我们每次更新dp[i][j][k]时，都要借助上一层的dp[i-1][j- zeros][k- ones]。
 * 很显然，[j][k]要比[j- zeros][k- ones]大，如果我们顺序访问，则先修改[j- zeros][k- ones]后修改[j][k]。
 * 这里思考下，我们修改dp[i][j][k]之前，[j- zeros][k- ones]已经被改过了，那他还是不是dp[i-1][j- zeros][k- ones]呢？
 * 答案是：否！他已经变成了dp[i][j- zeros][k- ones]，所以正确做法，需要倒序访问。
 *
 * 倒序访问，dp[i - zeros][j - ones] 这个会不会还没有来得及赋值呀？
 * 答：不会，已经赋值了。我们每次更新dp[i][j][k]，借助的都是上一层dp[i-1]。
 * 也就是说在你进入第i层前，已经在i-1层为他们赋过值了。（就算是i=1,也没问题，因为你已经把i=0那一层全部置为0了）。
 */
public class DP474_prod {
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            int zeros = 0, ones = 0;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='0') zeros++;
                else ones++;
            }
            for(int i = m; i >= zeros; i--){
                for(int j = n; j >= ones; j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}
