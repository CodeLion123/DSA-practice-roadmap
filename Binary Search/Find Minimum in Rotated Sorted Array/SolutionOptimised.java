class SolutionOptimised {
    /**
     * Find Minimum in Rotated Sorted Array
     * This function finds the minimum element in a rotated sorted array.
     * @param nums: a rotated sorted array
     * @return: the minimum element in the array
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}