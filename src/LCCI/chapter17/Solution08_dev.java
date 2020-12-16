package LCCI.chapter17;

import java.util.Arrays;

public class Solution08_dev {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] array = new int[len][2];
        for(int i = 0;i<len;i++){
            array[i][0] = height[i];
            array[i][1] = weight[i];
        }
        Arrays.sort(array,(a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] tails = new int[len];
        int res = 0;
        for(int[] arr: array){
            int i = 0, j = res;
            while(i<j){
                int middle = (i+j)/2;
                if(tails[middle]<arr[1])
                    i = middle+1;
                else
                    j = middle;
            }
            tails[i] = arr[1];
            if(j==res) res++;
        }
        return res;
    }
}
