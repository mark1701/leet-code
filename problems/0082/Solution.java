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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        
        ListNode prev = fakeHead, curr = head;
        while(curr != null){        
            while(curr.next != null && curr.next.val == curr.val) curr = curr.next;
                        
            if(prev.next == curr){
                prev = curr;
                curr = curr.next;
            }else{
                curr = curr.next;
                prev.next = curr;
            }
        }
        return fakeHead.next;
    }
}