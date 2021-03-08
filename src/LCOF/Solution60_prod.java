package LCOF;

// n个骰子的点数
public class Solution60_prod {
    public double[] dicesProbability(int n) {
        double[] pre = {1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for(int i = 2; i <= n; i++){
            double[] temp = new double[6*i - i + 1];
            for(int j = 0; j < pre.length; j++){
                for(int x = 0; x < 6; x++){
                    temp[j + x] += pre[j] / 6;
                }
            }
            pre = temp;
        }
        return pre;
    }
}
