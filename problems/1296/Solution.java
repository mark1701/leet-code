class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        int N = nums.length;
        if(N % k != 0) return false;
        if(k == 1) return true;
        
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        
        for(int n : nums){
            
                Deque<Integer> counters = map.get(n-1);
                if(counters == null){
                    Deque<Integer> queue = map.getOrDefault(n, new ArrayDeque<>());
                    queue.add(1);
                    map.put(n, queue);
                    continue;
                }
            
                int count  = counters.poll();
                if(counters.isEmpty()) map.remove(n-1);
                
                count++;
                if(count < k){
                    Deque<Integer> nextCounters = map.getOrDefault(n, new ArrayDeque<>());
                    nextCounters.add(count);
                    map.put(n, nextCounters);
                }
            
        }
        return map.size() == 0;
        
    }
}