class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int N = nums.length;
        
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[N-k+1];
        int idx = 0;
        
        for(int i = 0; i < N; i++){
            if(!queue.isEmpty() && queue.peekFirst() < i-k+1)
                queue.pollFirst();
            
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            
            queue.addLast(i);
            if(i-k+1 >= 0)
                res[idx++] = nums[queue.peekFirst()];                
        }
        
        return res;
    }
}