package meituan;

/**
 * 合并两个有序数组 从后往前遍历
 */
public class MT88_prod {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        int index1 = m-1, index2 = n-1;
        while(index1>=0&&index2>=0){
            if(nums1[index1]>nums2[index2])
                nums1[i--] = nums1[index1--];
            else nums1[i--] = nums2[index2--];
        }
        // while(index1>=0) nums1[i--] = nums1[index1--];
        while(index2>=0) nums1[i--] = nums2[index2--];
        // System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
    }
}
