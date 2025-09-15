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
     * Time Complexity: O(N log k) where N is the total number of nodes and k is the number of lists.
     * Space Complexity: O(1) since we are not using any extra space that grows
     * @param lists
     * @return merged sorted list
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length <= 0 ) return null;
        ListNode list1 = lists[0];
        for (int i=1 ; i<lists.length; i++) {
            list1 = mergeList(list1, lists[i]);
        }
        return list1;

    }
    private static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tempNode = dummy;
        if(list1 == null && list2 != null) return list2;
        if(list1 != null && list2 == null) return list1;
        while (list1 != null && list2 != null) {
            if(list1.val  <= list2.val){
                tempNode.next = list1;
                list1 = list1.next; 
            } else {
                tempNode.next = list2;
                list2 = list2.next; 
            }
            tempNode = tempNode.next;
        }
        if(list1 != null)
            tempNode.next = list1;
        if(list2 != null)
            tempNode.next = list2;
        return dummy.next;
    }
}