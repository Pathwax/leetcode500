package meituan;

// x的平方根 二分法
public class MT69_prod1 {
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while(left < right){
            int mid = left + (right-left)/2;
            if ((long)mid*mid <= x){
                ans = mid;
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return ans;
    }
}
