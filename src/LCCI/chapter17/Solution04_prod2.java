package LCCI.chapter17;

/**
 * 利用异或的性质,res=res^x^x;
 * 1. 0和任何值的异或都等于本身,即:A^0=A;
 * 2. 异或本身等于0,即A^A=0;
 * 3. 异或满足结合律,即A^B^C=A^(B^C).
 */
public class Solution04_prod2 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res^=i;
            res^=nums[i];
        }
        return res;
    }
}
