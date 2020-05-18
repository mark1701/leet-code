class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res  = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        
        backtrack(nums, new ArrayList<Integer>(), target, res,0);
        
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> tmp, int target, List<List<Integer>> res, int start){
        if(target == 0) {            
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            if(target - nums[i] >= 0){
                tmp.add(nums[i]);
                backtrack(nums, tmp, target-nums[i], res, i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
}