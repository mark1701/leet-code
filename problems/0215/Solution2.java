class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums); //O(N) 
        k = nums.length - k;
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            int j = partition(nums, lo, hi);
            if(j < k) lo = j+1;
            else if(j > k) hi = j-1;
            else break;
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int lo, int hi){
        int i = lo, j = hi+1;
        while(true){
            while(nums[++i] < nums[lo])
                if(i == hi) break;
            while(nums[--j] > nums[lo])
                if(j == lo) break;
            if(i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }
    
    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void shuffle(int[] nums){
        Random rnd = new Random();
        for (int i = nums.length - 1; i > 0; i--){
          int idx = rnd.nextInt(i + 1);
          int tmp = nums[idx];
          nums[idx] = nums[i];
          nums[i] = tmp;
        }
  }
    
}