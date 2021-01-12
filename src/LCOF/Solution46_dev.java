package LCOF;

public class Solution46_dev {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len==0) return 0;
        int first = 1, second = 1;
        for (int i = 1; i < len; i++) {
            int temp = second;
            if (s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)<='5'&&s.charAt(i)>='0'))
                second = first+second;
            first = temp;
        }
        return second;
    }
}
