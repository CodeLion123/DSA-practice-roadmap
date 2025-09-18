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
     * @input: root of the binary search tree and an integer k
     * @return: the kth smallest element in the given BST
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<Integer> st = new Stack<Integer>();
        getNthMinNode(root, k, st);
        return st.peek();
    }
    private void getNthMinNode(TreeNode root, int k, Stack<Integer> st) {
        if(root != null) {
            getNthMinNode(root.left, k, st);
            if(st.size() < k)
                st.push(root.val);
            else return;
            getNthMinNode(root.right, k, st);
        }
    }
}