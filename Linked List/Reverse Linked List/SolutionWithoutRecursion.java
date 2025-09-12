/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Reverse a singly linked list.
 * @input: head = [1,2,3,4,5]
 * @output: [5,4,3,2,1]
 */
class SolutionWithoutRecursion {
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode prevNode = null;

        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        head = prevNode;

        return head;
    }
}