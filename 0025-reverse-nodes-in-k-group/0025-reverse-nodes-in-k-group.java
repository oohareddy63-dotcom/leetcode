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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if k nodes exist in the current group
        ListNode temp = head;
        int count = 0;
        
        while (count < k) {
            if (temp == null) {
                // If fewer than k nodes remain, return head as-is [00:08:15]
                return head;
            }
            temp = temp.next;
            count++;
        }
        
        // Step 2: Recursively reverse the rest of the linked list
        // temp now points to the head of the next group [00:17:26]
        ListNode prevNode = reverseKGroup(temp, k);
        
        // Step 3: Reverse the current k-group nodes [00:11:37]
        temp = head; // Re-initialize temp back to current head
        count = 0;
        
        while (count < k) {
            ListNode nextNode = temp.next; // Preserve next node
            temp.next = prevNode;          // Reverse connection [00:12:54]
            prevNode = temp;               // Update previous for next iteration
            temp = nextNode;               // Move temp forward
            count++;
        }
        
        // At the end of reversal, prevNode points to the new head of this reversed segment [00:16:08]
        return prevNode;
    }
}