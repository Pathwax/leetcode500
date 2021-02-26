package meituan;

public class MT69_prod2 {
    // x的平方根 牛顿迭代法
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double x0 = x;
        while(true){
            double xi = 0.5 * (x0+ (double) x /x0);
            if (Math.abs(x0-xi) < 1e-7)
                break;
            x0 = xi;
        }
        return (int) x0;
    }
}
