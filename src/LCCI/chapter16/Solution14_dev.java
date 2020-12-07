package LCCI.chapter16;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution14_dev {
    public int[] bestLine(int[][] points) {
        HashMap<Line, Integer> map = new HashMap<>();
        int max = 0;
        Line tagLine = null;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line temp = new Line(points[i], points[j]);
                int newValue = map.getOrDefault(temp, 0) + 1;
                map.put(temp, newValue);
                if (newValue > max) {
                    max = newValue;
                    tagLine = temp;
                }
            }
        }
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] point : points) {
            // if (list.size()==2)
            //     break;
            if (tagLine.isInline(point))
                list.add(index);
            index++;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private class Line {
        public double k;
        public double b;

        public Line(int[] point1, int[] point2) {
            if (point1[0] - point2[0] == 0) {
                k = Integer.MAX_VALUE;
                b = point1[0];
            } else if(point1[1]-point2[1] == 0){
                k = 0;
                b = point1[1];
            }else{
                k = (point1[1] - point2[1]) / (double) (point1[0] - point2[0]);
                b = point1[1] - k * point1[0];
            }
        }

        public boolean isInline(int[] point) {
            if (Math.abs(this.k - Integer.MAX_VALUE) < 10e-6) {
                if (Math.abs(point[0] - this.b) < 10e-6)
                    return true;
                else return false;
            }
            if (Math.abs(point[0] * this.k + this.b - point[1]) < 10e-6)
                return true;
            else
                return false;
        }

        @Override
        public int hashCode() {
            String format = String.format("%.6f", this.k)+String.format("%.6f", this.b);
            return format.hashCode();
        }

        @Override
        public boolean equals(Object otherLine) {
            Line otherLine1 = (Line) otherLine;
            if (Math.abs(this.k - otherLine1.k) < 10e-6 && Math.abs(this.b - otherLine1.b) < 10e-6)
                return true;
            else
                return false;
        }
    }
}
