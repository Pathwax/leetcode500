package meituan;

public class MT56_test {
    public static void main(String[] args) {
        MT56_dev dev = new MT56_dev();
        int[][] test = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        dev.merge(test);
    }
}
