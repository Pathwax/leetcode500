package dp.linear.single.others;

/**
 * dp[i] 为s[0...i]的译码方法总数
 * 分情况讨论：
 *      1. 若s[i] = '0' , 那么 若 s[i-1] = '1' 或 '2' , dp[i] = dp[i-2] ; 否则 return 0 ;
 *      2. 若s[i-1] = '1' , 那么dp[i] = dp[i-1] + dp[i-2];
 *      3. 若s[i-1] = '2' , 那么 若 1 <= s[i] <= 6 , dp[i] = dp[i-1] + d[i-2] ;
 */
public class DP91_prod {
    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        int first = 1, second = 1; // dp[-1] = dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = second;
            if (s.charAt(i)=='0'){
                if (s.charAt(i-1)=='1'||s.charAt(i-1)=='2') second = first;
                else return 0;
            } else if (s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)>='1'&&s.charAt(i)<='6'))
                second = first + second;
            first = temp;
        }
        return second;
    }
}
