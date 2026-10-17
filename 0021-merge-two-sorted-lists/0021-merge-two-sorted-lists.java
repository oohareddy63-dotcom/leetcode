
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to act as the start of the merged list
    
        ListNode dummy = new ListNode(0);
        ListNode curr=dummy;
        
        // Loop while both lists have nodes remaining
        while(l1!=null && l2 !=null){
            if(l1.val <=l2.val){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        
        // Append the remaining nodes from either l1 or l2
        curr.next = (l1 != null) ? l1 : l2;
        
        // Return the head of the merged list
        return dummy.next;
    }
}