package dp;

import dp.linear.single.others.DP871_prod1;

public class DP871_test {
    public static void main(String[] args) {
        DP871_prod1 dev = new DP871_prod1();
        dev.minRefuelStops(100,10,new int[][]{{10,60},{20,30},{30,30},{60,40}});
    }
}
