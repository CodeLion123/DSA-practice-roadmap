/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * Time Complexity: O(n) where n is the number of nodes in the linked list.
     * Space Complexity: O(1) since we are not using any extra space that grows
     * @param head
     * @return true if there is a cycle in the linked list. Otherwise, false.
     */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        if (head !=null && head.next !=null) {
            ListNode curNode = head;
            ListNode fastForward = head.next.next;
            while(curNode !=null && fastForward != null && fastForward.next != null) {
                 if (!curNode.equals(fastForward)) {
                    curNode = curNode.next;
                    fastForward = fastForward.next.next;
                 } else return true;
            }
        }
        return false;
    }
}