package LCCI.chapter16;

import java.util.Arrays;

public class Solution10_dev {
    public int maxAliveYear(int[] birth, int[] death) {
        Arrays.sort(birth);
        Arrays.sort(death);
        int birthNum = 0;
        int deathNum = 0;
        int max = birthNum - deathNum;
        int deathIndex = 0;
        int result = birth[0];
        for (int i = 0; i < birth.length; ) {
            int j = i+1;
            while(j<birth.length&&birth[j]==birth[i])
                j++;
            birthNum += j-i;
            while (death[deathIndex]<birth[i]){
                deathNum++;
                deathIndex++;
            }
            int temp = birthNum-deathNum;
            if (max<temp){
                max=temp;
                result = birth[i];
            }
            i=j;
        }
        return result;
    }
}
