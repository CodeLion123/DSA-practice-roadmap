/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SolutionWithExtraSpace {
    /**
     * Time Complexity: O(n) where n is the number of nodes in the linked list.
     * Space Complexity: O(n) since we are using an extra list to store the nodes
     * @param head
     * @return void, modifies the list in-place
     */
    public static void reorderList(ListNode head) {
        List<ListNode> nodeArray = new ArrayList<>();
        ListNode curNode = head;
        while(curNode != null) {
            nodeArray.add(curNode);
            curNode = curNode.next;
        }
        int left = 0, right=nodeArray.size()-1;
        ListNode dummyNode = new ListNode(-1);
        curNode = dummyNode;
        while(left<right){
            curNode.next = nodeArray.get(left);
            curNode = curNode.next;
            curNode.next = nodeArray.get(right);
            curNode = curNode.next;
            left++;
            right--;
        }
        if (left==right) {
            curNode.next = nodeArray.get(left);
            curNode = curNode.next;
        }
        curNode.next = null;
        head = dummyNode.next;   
    }
}