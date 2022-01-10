class Solution {
     public int longestSubarray(int[] A, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
         
        int start = 0, end;
        for (end = 0; end < A.length; ++end) {
            while (!maxQ.isEmpty() && A[end] > maxQ.peekLast()) maxQ.pollLast();
            while (!minQ.isEmpty() && A[end] < minQ.peekLast()) minQ.pollLast();
            
            maxQ.offer(A[end]);
            minQ.offer(A[end]);
            
            if (maxQ.peek() - minQ.peek() > limit) {
                if (maxQ.peek() == A[start]) maxQ.poll();
                if (minQ.peek() == A[start]) minQ.poll();
                start++;
            }
        }
        return end - start;
    }
}