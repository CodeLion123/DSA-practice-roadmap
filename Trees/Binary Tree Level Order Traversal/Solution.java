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
     * Space Complexity: O(n) n is the number of nodes in the tree
     * @input: root of the binary tree
     * @return: level order traversal of its nodes' values. (ie, from left to right, level by level).
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null) return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int level = queue.size();
            for (int i=0; i<level; i++) {
                TreeNode curNode = queue.remove();
                if(curNode.left != null)
                    queue.add(curNode.left);
                if(curNode.right != null)
                    queue.add(curNode.right);
                temp.add(curNode.val);
            }
            output.add(temp);
        }
        return output;
    }
}