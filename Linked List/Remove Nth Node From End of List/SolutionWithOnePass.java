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
class Solution {
    /**
     * Time Complexity: O(n) where n is the number of nodes in the linked list.
     * Space Complexity: O(1) since we are not using any extra space that grows
     * @param head
     * @param n
     * @return head of the modified list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Step 2: Move first n+1 steps
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 3: Move both until first hits null
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 4: Delete nth node
        second.next = second.next.next;

        return dummy.next;
    }
}