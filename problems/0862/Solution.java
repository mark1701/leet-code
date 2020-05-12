class Solution {
    public int shortestSubarray(int[] a, int k) {
        int N = a.length;
        
        int[] B = new int[N+1];
        for(int i = 1; i < B.length; i++){
            B[i] = B[i-1] + a[i-1];
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i <= N; i++){
            while(!queue.isEmpty() && B[i] - B[queue.getFirst()] >= k){
                minLen = Math.min(minLen, i - queue.pollFirst());
            }
            
            while(!queue.isEmpty() && B[i] <= B[queue.getLast()])
                queue.pollLast();
            
            queue.add(i);
        }
        
        return minLen != Integer.MAX_VALUE ? minLen : -1;
    }
}