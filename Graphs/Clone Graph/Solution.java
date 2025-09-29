/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /**
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
     * Space Complexity: O(V) where V is the number of vertices
     * @input: node
     * @output: cloned graph
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        int rootVal = node.val;
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> myMap = new LinkedHashMap<>();
        boolean[] isVisited = new boolean[101];
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if(!isVisited[tempNode.val]){
                isVisited[tempNode.val] = true;
                List<Node> neighbors = tempNode.neighbors;
                Node newRoot;
                
                if(myMap.containsKey(tempNode.val))
                    newRoot = myMap.get(tempNode.val);
                else {
                    newRoot = new Node(tempNode.val);;
                    myMap.put(tempNode.val, newRoot);
                }
                List<Node> newNeighbors = new ArrayList<>();
                for (int i=0; i<neighbors.size(); i++) {
                    Node neighbor = neighbors.get(i);
                    queue.offer(neighbor);
                    Node newNode;
                    if(myMap.containsKey(neighbor.val))
                        newNode = myMap.get(neighbor.val);
                    else {
                        newNode = new Node(neighbor.val);
                        myMap.put(neighbor.val, newNode);
                    }
                        
                    newNeighbors.add(newNode);
                }
                newRoot.neighbors = newNeighbors;
            }
        }
        return myMap.get(rootVal);
    }
}