package LCCI.chapter16;

import java.util.Arrays;

public class Solution13_dev {
    public double[] cutSquares(int[] square1, int[] square2) {
        double[] center1 = center(square1);
        double[] center2 = center(square2);
        if (Math.abs(center1[0]-center2[0])<10e-6){
            double up = (center1[1]+(double)square1[2]/2>center2[1]+(double)square2[2]/2)?center1[1]+(double)square1[2]/2:center2[1]+(double)square2[2]/2;
            double down = (center1[1]-(double)square1[2]/2<center2[1]-(double)square2[2]/2)?center1[1]-(double)square1[2]/2:center2[1]-(double)square2[2]/2;
            return new double[]{center1[0],down,center2[0],up};
        }else{
            double k = center1[0]>center2[0]? (center1[1]-center2[1])/(center1[0]-center2[0]):(center2[1]-center1[1])/(center2[0]-center1[0]);
            double b = center1[1]-k*center1[0];
            double[][] collect = new double[4][2];
            if (k>1||k<-1){
                collect[0][1] = square1[1]+square1[2];
                collect[1][1] = square1[1];
                collect[2][1] = square2[1]+square2[2];
                collect[3][1] = square2[1];
                collect[0][0] = (collect[0][1]-b)/k;
                collect[1][0] = (collect[1][1]-b)/k;
                collect[2][0] = (collect[2][1]-b)/k;
                collect[3][0] = (collect[3][1]-b)/k;
            }else{
                collect[0][0] = square1[0]+square1[2];
                collect[1][0] = square1[0];
                collect[2][0] = square2[0]+square2[2];
                collect[3][0] = square2[0];
                collect[0][1] = k*collect[0][0]+b;
                collect[1][1] = k*collect[1][0]+b;
                collect[2][1] = k*collect[2][0]+b;
                collect[3][1] = k*collect[3][0]+b;
            }
            Arrays.sort(collect,(first, second)->first[0]<second[0]?-1:1);
            double[] res = new double[]{collect[0][0],collect[0][1],collect[3][0],collect[3][1]};
            return res;
        }
    }
    private double[] center(int[] square){
        return new double[]{square[0]+(double)square[2]/2,square[1]+(double)square[2]/2};
    }
}
