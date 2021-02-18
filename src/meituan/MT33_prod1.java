package meituan;

public class MT33_prod1 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<high){
            int mid = (low + high)/2;
            if((nums[0]>target)^(nums[0]>nums[mid])^(target>nums[mid]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low==high && nums[low] == target ? low : -1;
    }
}
