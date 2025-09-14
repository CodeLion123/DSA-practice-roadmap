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
class SolutionWithMultiplePass {
    /**
     * Time Complexity: O(n) where n is the number of nodes in the linked list.
     * Space Complexity: O(1) since we are not using any extra space that grows
     * @param head
     * @param n
     * @return head of the modified list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curNode =  head;
        int len = 0;
        while(curNode != null) {
            len++;
            curNode = curNode.next;
        }

        if (n > len)  return head;
        if (len == n) {
            return head.next;
        }

        curNode =  head;
        int nodeCount =  0;
        while(curNode != null) {
            if(nodeCount == len-n-1) {
                ListNode nodeToDelete = curNode.next;
                curNode.next = nodeToDelete.next;
                nodeToDelete= null;
                return head;
            }
            curNode = curNode.next;
            nodeCount++;
        }

        return head;
    }
}