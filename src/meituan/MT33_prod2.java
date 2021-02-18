package meituan;

public class MT33_prod2 {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0) return -1;
        int start = 0, end = nums.length-1;
        int mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;

            // 前半部分有序
            if (nums[start]<=nums[mid]){
                // target在前半部分
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else start = mid + 1;
            }else{
                // target在后半部分
                if (target>nums[mid] && target <= nums[end])
                    start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
