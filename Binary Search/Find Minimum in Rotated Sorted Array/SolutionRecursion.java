class SolutionRecursion {
    /**
     * Find Minimum in Rotated Sorted Array
     * This function finds the minimum element in a rotated sorted array.
     * @param nums An array of integers representing the rotated sorted array.
     * @return The minimum element in the array.
     */
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length-1, Integer.MAX_VALUE);
    }

    private int binarySearch(int[] nums,int left,int right,int min) {
        if (left == right) {
             return Math.min(min,nums[left]);
        }

        if (left+1 == right) {
            return Math.min(min,Math.min(nums[left], nums[right]));
        }

        int mid = (left+right)/2;
        
        if (nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])
        {
            return Math.min(min, nums[mid]);
        } else if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
        {
            return Math.min(min, nums[mid+1]);
        } else
            {
                min = Math.min(min, nums[mid-1]);
                return Math.min(
                    binarySearch(nums, left, mid-1, min),
                    binarySearch(nums, mid+1, right, min)
                );
            }
    }
}