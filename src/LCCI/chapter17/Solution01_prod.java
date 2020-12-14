package LCCI.chapter17;

public class Solution01_prod {
    public int add(int a,int b){
        if (b==0) return a;
        int sum = a^b;// 两数相加,不进位
        int carry = (a&b)<<1; // 只进位,不相加
        return add(sum,carry); // 以sum和carry为参数进行递归
    }
}
