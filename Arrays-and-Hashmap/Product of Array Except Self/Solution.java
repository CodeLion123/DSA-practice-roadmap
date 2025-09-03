// using Division
class Solution {
    /**
     * Calculates the product of array elements except self.
     * <p>
     * Handles cases where the input array contains zero(s):
     * <ul>
     *   <li>If there is one zero, all elements except the zero position will be zero, and the zero position will be the product of all non-zero elements.</li>
     *   <li>If there are more than one zero, all elements will be zero.</li>
     *   <li>If there are no zeros, each element is replaced by the product of all other elements.</li>
     * </ul>
     * @param nums: an array of integers
     * @return: the product of array except self
     */
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int num:nums) {
            if (num == 0) {
                zeroCount++;
            } else
                product *= num;

        }
        for(int i=0; i<nums.length; i++) {
            if(zeroCount == 1 && nums[i] == 0) {
                nums[i] = product;
            } else if(zeroCount == 1 && nums[i] != 0) {
                nums[i] = 0;
            } else if(zeroCount > 1) {
                nums[i] = 0;
            } else {
                nums[i] = product/nums[i];
            }
            
        }
        return nums;
    }
}