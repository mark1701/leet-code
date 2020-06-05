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
        Map<Integer, ListNode> map = new HashMap<>();
        if(n == 0) return head;
        
        int idx = 0;
        ListNode node = head;
        while(node != null){
            map.put(idx++, node);
            node = node.next;            
        }
        if(n == idx) return head.next;
        ListNode target = map.get(idx-n);
        ListNode parent = map.get(idx-n-1);
        parent.next = target.next; 
        return head;
    }
}