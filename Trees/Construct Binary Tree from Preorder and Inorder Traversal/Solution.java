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
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * Where N is the number of nodes in the binary tree
     * @input preorder: Preorder traversal of the binary tree
     * @input inorder: Inorder traversal of the binary tree
     * @return root of the constructed binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=preorder.length-1; i>=0; i--)
            st.push(preorder[i]);
        for (int i=0; i<inorder.length; i++)
            mp.put(inorder[i], i);

        return contructTree(st, mp, inorder, 0, inorder.length-1);
    }
    private TreeNode contructTree(Stack<Integer> st, Map<Integer, Integer> mp, int[] inorder, int start, int end) {
        if (start > end) return null;
        
        int rootVal = st.pop();
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = mp.get(rootVal);
        
        root.left = contructTree(st, mp, inorder, start, rootIdx-1);
        root.right = contructTree(st, mp, inorder, rootIdx+1, end);
        return root;
    }
}