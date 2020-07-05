class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        
        int M = nums1.length, N = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (a,b) -> (a[0]+a[1])-(b[0]+b[1]));
        for(int i = 0; i < k && i < M; i++)
            queue.add(new int[]{nums1[i],nums2[0],0});
        
        while(k-- > 0 && !queue.isEmpty()){
            int[] curr = queue.poll();
            res.add(Arrays.asList(curr[0],curr[1]));
            if(curr[2] == N-1) continue;
            queue.add(new int[]{curr[0],nums2[curr[2]+1],curr[2]+1});
        }
        return res;
    }
}