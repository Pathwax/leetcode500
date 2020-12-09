package LCCI.chapter16;

public class Solution21_dev {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array1.length; i++) {
            sum1+=array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            sum2+=array2[i];
        }
        int diff = sum1 - sum2;
        if (diff%2!=0)
            return new int[0];
        int[] res = new int[2];
        boolean tag = false;
        found:
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                int temp = array1[i]-array2[j];
                if (temp == diff/2){
                    tag = true;
                    res[0] = array1[i];
                    res[1] = array2[j];
                    break found;
                }
            }
        }
        return tag?res:new int[0];
    }
}
