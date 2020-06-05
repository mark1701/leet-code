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
        
        if(n == 0) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        int count = 0;
        while(count < n){
            fast = fast.next;
            count++;
        }
        if(fast == null) return head.next;
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;        
    }
}