package others;

public class LC81_prod {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, high = nums.length-1;
        int mid;
        while(low<=high){
            mid = low + (high - low) / 2;
            if (nums[mid]==target) return true;
            if (nums[low]==nums[mid] && nums[high]==nums[mid]){
                low++;
                continue;
            }
            if (nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid])
                    high = mid - 1;
                else low = mid + 1;
            }else{
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
