package dp.linear.single.others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DP131_prod {
    String s;
    int len;
    List<List<String>> res;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.len = s.length();
        this.res = new ArrayList<>();
        this.dp = new boolean[len][len];

        // 动态规划判断回文串预处理, dp[i][j]表示s[i][j]是否回文
        // 状态转移方程：在s[i] = s[j]的时候，dp[i][j]参考dp[i+1][j-1]
        // j在前，先按列排，因为元素依赖于左下角元素。
        for(int j = 0; j < len; j ++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1]))
                    dp[i][j] = true;
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(0, stack);
        return res;
    }

    /**
     *
     * @param start 起始字符的索引
     * @param path 记录从根节点到叶子节点的路径
     */
    private void dfs(int start, Deque<String> path){
        if(start==len) res.add(new ArrayList<>(path));
        for(int i = start; i < len; i++){
            // 因为截取字符串是消耗性能的，因此采用动态规划的方式获取一个子串是否是回文串，不是的话，剪枝。
            if(dp[start][i]){
                path.addLast(s.substring(start,i+1));
                dfs(i+1,path);
                path.removeLast();
            }
        }
    }
}
