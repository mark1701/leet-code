class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0 || k == nums.length) return;
        int N = nums.length;
        k = k % N;
        
        int count = 0;
        
        for(int start = 0; count < N; start++){
            
            int prev = nums[start];
            int curr = start;
            do{                
                int next = (curr + k)%N;
                int tmp = nums[next];
                nums[next] = prev;
                curr = next;
                prev = tmp;
                count++;
            } while(curr != start);
            
        }

        
    }
}