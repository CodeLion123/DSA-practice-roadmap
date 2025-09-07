class Solution {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param prices: an array of prices
     * @return: the maximum profit
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}