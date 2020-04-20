class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        boolean[] used = new boolean[nums.length];
        
        permute(nums, res, used, new ArrayList<>());
        return res;
    }
    
    private void permute(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> permutation){
        
        if(permutation.size() == nums.length){
            res.add(new ArrayList<>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            permutation.add(nums[i]);
            used[i] = true;
            permute(nums, res, used, permutation);
            used[i] = false;
            permutation.remove(permutation.size() -1);
        }       
        
    }
}