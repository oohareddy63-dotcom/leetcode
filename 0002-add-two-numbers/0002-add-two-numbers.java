class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a sentinel/dummy node to build the new result list
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        
        int carry = 0;

        // Loop runs until we process all digits in both lists
        while (l1 != null || l2 != null) {
            int sum = carry; // Start with any carry-over from the previous addition

            // Add the value from the first list, if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add the value from the second list, if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate the new carry and the single-digit value for the node
            carry = sum / 10;
            int nodeValue = sum % 10;

            // Append the new digit node to our result list
            ptr.next = new ListNode(nodeValue);
            ptr = ptr.next;
        }

        // If there is any remaining carry at the end, append it as a final node
        if (carry > 0) {
            ptr.next = new ListNode(carry);
        }

        // Return the actual head of the result list (skipping the dummy node)
        return result.next;
    }
}