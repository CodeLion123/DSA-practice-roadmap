class Solution {
    /**
     * Finds two numbers in the array that add up to the target sum.
     *
     * This method uses a HashMap to store the indices of the numbers
     * as we iterate through the array. For each number, we check if
     * the complement (target - current number) exists in the map.
     *
     * @param nums the input array of integers
     * @param target the target sum
     * @return an array containing the indices of the two numbers, or [-1, -1] if no solution is found
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int j=target-nums[i];
            if(numIndMap.containsKey(j)) {
                return new int[]{i,numIndMap.get(j)};
            }
            numIndMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}