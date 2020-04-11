/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int K = lists.length;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(K,(a,b) -> a.val - b.val);
        
        for(int i = 0; i < K; i++)
            if(lists[i] != null)
                minHeap.add(lists[i]);        
        
        
        ListNode head = null;        
        ListNode prev = null;
        
        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
             
            if(curr.next != null)
                minHeap.add(curr.next);
           
            if(head == null)
                head = curr;
            
            if(prev != null)
                prev.next = curr; 
            
            prev = curr;
        }
        
        return head;
    }
}