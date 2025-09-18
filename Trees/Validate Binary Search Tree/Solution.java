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
     * Time Complexity: O(n) n is the number of nodes in the tree
     * Space Complexity: O(h) h is the height of the tree
     * @input: root of the binary tree
     * @return: true if it is a valid binary search tree, otherwise false.
     */
    public boolean isValidBST(TreeNode root) {
        return minMaxFromBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean minMaxFromBST(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return minMaxFromBST(root.left, min, (long)root.val-1) 
        && minMaxFromBST(root.right, (long)root.val+1, max);
    }
}