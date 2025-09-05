class Solution {
    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container
     * contains the most water.
     * Note: You may not slant the container and n is at least 2.
     * This method runs in O(n) time and uses O(1) additional space.
     * @param height an array of non-negative integers representing the heights of the lines
     * @return the maximum amount of water a container can store
     */
    public static int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max = Integer.MIN_VALUE;
        while(i<j) {
            int x = Math.min(height[i],height[j]);
            int y = j-i;
            max = Math.max(max, x*y);
            if(height[i]<height[j])
                i++;
            else 
                j--;
        }
        return max;
    }
}