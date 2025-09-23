class Solution {
    /**
     * Time: O(2^t * k)
     * Space: O(k)
     * where t is the target value and k is the average length of the combinations
     * Approach: Backtracking
     * @param candidates The array of candidate numbers
     * @param target The target sum
     * @return A list of all unique combinations of candidates where the chosen numbers sum to target
     * You may return the combinations in any order.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        getSubsetCombinationSum(candidates, target, 0, res, subset, 0);
        return res;
    }

    public void getSubsetCombinationSum(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> subset, int sum) {
        if (target == sum) {
            res.add(new ArrayList(subset));
            return;
        }
        if (index >= candidates.length || target<sum) return;
        subset.add(candidates[index]);
        getSubsetCombinationSum(candidates, target, index, res, subset, sum+candidates[index]);
        subset.remove(subset.size()-1);
        getSubsetCombinationSum(candidates, target, index+1, res, subset, sum);
    }
}