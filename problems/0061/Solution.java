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
        if(head == null) return head;
        
        ListNode fast = head;
        int idx = 0;
        while(fast != null){
            idx++;
            fast = fast.next;
        }
        k = k % idx;
        if(k == 0) return head;
        
        fast = head;
        idx = 0;
        
        while(idx < k) {
            fast = fast.next;
            idx++;
        }
        
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;
    }
}