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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode temp = head;
        
        // 1. Calculate the total size of the linked list
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        
        // 2. Base case: If we need to remove the first node
        if (n == sz) {
            return head.next;
        }
        
        // 3. Find the node right BEFORE the one we want to delete
        int i = 1;
        int iToFind = sz - n;
        ListNode prev = head; 
        
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        
        // 4. Skip the Nth node
        prev.next = prev.next.next;
        return head; 
    }
}