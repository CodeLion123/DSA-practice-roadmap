class SolutionWithoutDivision {
    /**
     * Returns an array where each element at index i is the product of all elements in the input array except nums[i].
     * This method does not use division and runs in O(n) time with O(1) extra space (excluding the output array).
     *
     * @param nums the input array of integers
     * @return an array where each element is the product of all elements in nums except the one at the same index
     */
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] arrOut = new int[nums.length];
        arrOut[0]=1;
        for(int i=1; i<nums.length; i++) {
            arrOut[i] = arrOut[i-1]*nums[i-1];            
        }
        for(int i=nums.length-1; i>=0; i--) {
            arrOut[i] *= product;            
            product *= nums[i];
        }
        return arrOut;
    }
}