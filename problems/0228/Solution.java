class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList();
        if(nums == null || nums.length == 0) return res;
        
        int start = 0;
        int end = 0;
        while(end < nums.length){
            while(end + 1 < nums.length && nums[end+1] == nums[end]+1)
                end++;
            
            if(start==end)
                res.add("" + nums[start]);
            else
                res.add(nums[start] + "->" + nums[end]);
            
            end++;
            start = end;
        }
        
        return res;
    }
}