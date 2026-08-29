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
    public ListNode rotateRight(ListNode head, int k) {
        // Step 1: Handle edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 1: Find the length of the list and locate the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Step 2: Find the actual number of rotations needed
        k = k % length;
        if (k == 0) {
            return head;
        }
        
        // Step 3: Find the (length - k - 1)-th node which will be the new tail
        ListNode current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }
        
        // Step 4: Perform the rotation
        ListNode newHead = current.next;
        current.next = null; // Disconnect the list (new tail)
        tail.next = head;    // Connect the old tail to the original head
        
        return newHead;
    }
}