import java.util.*;

public class Solution {
  
  public static ListNode sortList(ListNode head) {
		if(head == null) return null;
	  
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode [] list = new ListNode[2];
		boolean done = false;
		// keep partitioning our list into bigger sublists length. Starting with a size of 1 and doubling each time
		for (int step = 1; !done; step *= 2) {
			
			done = true;
			ListNode prev = dummy;
			ListNode remaining = dummy.next;
			
			do {		
				remaining = split(remaining, list, step);
				// we're done if these are the first two sublists in this pass 
				// and they encompass the entire primary list
				done &= (remaining == null);
				prev = merge(prev, list);			  
			} while (remaining != null);
		}
		  
		return dummy.next;
    }

	// split off two sublists of size step
	private static ListNode split(ListNode remaining, ListNode[] list, int step){
		for(int i = 0; i < 2; i++){
			list[i] = remaining;
			ListNode tail = null;
			for(int j = 0; j < step && remaining != null; j++){
				tail = remaining;
				remaining = remaining.next;
			}			
			if(tail != null)
				tail.next = null;
		}
		return remaining;
	}
	
	// merge the lists
    private static ListNode merge(ListNode prev, ListNode[] list){
		// only one list
		if(list[1] == null){
			prev.next = list[0];
			return prev;
		}
		
		while(list[0] != null || list[1] != null){
			int idx = (list[1] == null || (list[0] != null && list[0].val <= list[1].val)) ? 0 : 1;
			prev.next = list[idx];
			list[idx] = list[idx].next;
			prev = prev.next;
		}
		
		// terminate our new sublist
        prev.next = null;
		
		return prev;
    }
  
  }
