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
     * Time Complexity: O(n)
     * Space Complexity: O(h) h is the height of the tree
     * @input: root of the binary tree
     * @return: root of the inverted binary tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        traverseTree(root);
        return root;
    }
    private void traverseTree(TreeNode root) {
        if(root == null) return;
        if (root.left == null && root.right == null) return;
        traverseTree(root.left);
        traverseTree(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

}