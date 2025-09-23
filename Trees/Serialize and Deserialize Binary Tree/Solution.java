/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    /**
     * Time: O(n)
     * Space: O(h)
     * where n is the number of nodes in the tree and h is the height of the tree
     * Approach: DFS
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> treeValues =  new ArrayList<>();
        traverseTreeSerialize(root, treeValues);
        return treeValues.toString();
    }
    private void traverseTreeSerialize(TreeNode root, List<Integer> treeValues) {
        if (root == null) {treeValues.add(2000); return;}
        treeValues.add(root.val);
        traverseTreeSerialize(root.left, treeValues);
        traverseTreeSerialize(root.right, treeValues);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> treeValues = new ArrayList<>();
        data = data.replaceAll("\\[|\\]", "");
        for(String val: data.split(","))
            treeValues.add(Integer.parseInt(val.trim()));
            
        int[] index = {0};
        return traverseTreeDeSerialize(index, treeValues);
    }

    private TreeNode traverseTreeDeSerialize(int[] index, List<Integer> treeValues) {
        if (treeValues.get(index[0]) == 2000) {
            index[0]++; return null;
        }
        TreeNode root = new TreeNode(treeValues.get(index[0]));
        index[0]++;
        root.left = traverseTreeDeSerialize(index, treeValues);
        root.right = traverseTreeDeSerialize(index, treeValues);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));