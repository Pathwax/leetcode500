package douyu;

import java.util.ArrayList;
import java.util.List;

public class DY22_dev {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0, n);
        return res;
    }

    private void dfs(StringBuilder sb ,int leftCount, int rightCount, int n){
        if(rightCount > leftCount || leftCount > n || rightCount > n) return;
        if(leftCount == n && rightCount == n) {res.add(sb.toString()); return;}
        sb.append('(');
        dfs(sb, leftCount+1, rightCount, n);
        sb.delete(sb.length()-1,sb.length());
        sb.append(')');
        dfs(sb, leftCount, rightCount+1, n);
        sb.delete(sb.length()-1,sb.length());
    }
}
