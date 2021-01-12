package LCOF;

public class Solution67_prod {
    public int strToInt(String str) {
        int length = str.length();
        int i = 0;
        while(i<length&&str.charAt(i)==' ')
            i++;
        if (i==length)
            return 0;
        char c = str.charAt(i);
        int start = c == '-' ? -1 : 1;
        if (c=='-'||c=='+')
            i++;
        long res = 0;
        while(i<length){
            c = str.charAt(i++);
            if (Character.isDigit(c)){
                res = res * 10 + c - '0';
                if (start == -1){
                    if (-res<=Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                }else if (res>=Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }else break;
        }
        return start * (int) res;
    }
}
