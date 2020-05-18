class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, new ArrayList<Integer>(), res, 0);
            
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> tmp, List<List<Integer>> res, int start){
        
        res.add(new ArrayList<Integer>(tmp));
        
        for(int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(nums, tmp, res, i+1);
            tmp.remove(tmp.size()-1);            
        }
        
    }
}