class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        build(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void build(int[] nums, int start, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(curr));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            build(nums, i+1, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}