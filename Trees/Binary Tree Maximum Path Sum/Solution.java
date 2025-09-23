/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(h)
     * where n is the number of nodes in the tree and h is the height of the tree
     * Approach: DFS
     * @param root The root of the binary tree
     * @return The maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        int[] pre = {root.val};
        getMaxPathSum(root, pre);
        return pre[0];
    }
    private int getMaxPathSum(TreeNode root, int[] pre) {
        if (root == null) return 0;
        int left = Math.max(0, getMaxPathSum(root.left, pre));
        int right = Math.max(0, getMaxPathSum(root.right, pre));
        pre[0] = Math.max(pre[0], root.val+left+right);
        return root.val + Math.max(left, right);
    }
}