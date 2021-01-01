package dp.linear.single.others;

public class DP32_prod2 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int leftNum = 0, rightNum = 0, maxLen = 0;
        for (char c : chars) {
            if (c=='(')
                leftNum++;
            else
                rightNum++;
            if (leftNum==rightNum)
                maxLen = Math.max(maxLen,leftNum+rightNum);
            else if (rightNum>leftNum){
                leftNum = 0;
                rightNum = 0;
            }
        }
        leftNum = 0;
        rightNum = 0;
        for (int i = chars.length-1; i >=0 ; i--) {
            if (chars[i]==')')
                rightNum++;
            else
                leftNum++;
            if (leftNum==rightNum)
                maxLen = Math.max(maxLen,leftNum+rightNum);
            else if (leftNum>rightNum){
                leftNum = 0;
                rightNum = 0;
            }
        }
        return maxLen;
    }
}
